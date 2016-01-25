package pl.gombal.orm_benchmarks.task;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.PowerManager;
import android.os.RemoteException;
import android.support.v4.app.NotificationCompat;

import java.util.ArrayList;
import java.util.List;

import pl.gombal.orm_benchmarks.Constants;
import pl.gombal.orm_benchmarks.R;
import pl.gombal.orm_benchmarks.io.activeandroid.ActiveAndroidBenchmarkTask;
import pl.gombal.orm_benchmarks.io.greendao.GreenDaoBenchmarkTasks;
import pl.gombal.orm_benchmarks.io.ormlite.ORMLiteBenchmarkTasks;
import pl.gombal.orm_benchmarks.io.sqlite.SQLiteBenchmarkTasks;
import pl.gombal.orm_benchmarks.io.sugarorm.SugarORMBenchmarkTask;
import pl.gombal.orm_benchmarks.io.util.OrmExcelFileLogger;
import pl.gombal.orm_benchmarks.ui.MainActivity;
import pl.gombal.orm_benchmarks.util.LogUtils;

public class ORMBenchmarkService extends IntentService {

    public static final String TAG = ORMBenchmarkService.class.getSimpleName();

    private static List<Messenger> clients = new ArrayList<>();

    private NotificationManager notificationManager;

    private static boolean isBenchmarkRunning = false;


    private static volatile PowerManager.WakeLock lockStatic = null;

    synchronized private static PowerManager.WakeLock getLock(Context context) {
        if (lockStatic == null) {
            PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
            lockStatic = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "UpdateServiceWakeLock");
            lockStatic.setReferenceCounted(true);
        }

        return (lockStatic);
    }

    private final Messenger messenger = new Messenger(new IncomingHandler());

    static class IncomingHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case ServiceMessage.Request.REGISTER_CLIENT:
                    clients.add(msg.replyTo);
                    if (isBenchmarkRunning)
                        notifyClients(ServiceMessage.Response.NOTIFY_BENCHMARK_PROGRESS);
                    break;
                case ServiceMessage.Request.UNREGISTER_CLIENT:
                    clients.remove(msg.replyTo);
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }


    public ORMBenchmarkService() {
        super(TAG);
        LogUtils.LOGD(TAG, "Constructor");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.LOGD(TAG, "onCreate");
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtils.LOGD(TAG, "onStartCommand");

        if (intent != null && !handleOnStartCommand(intent)) {
            super.onStartCommand(intent, flags, startId);
        }
        return START_STICKY;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        LogUtils.LOGD(TAG, "onHandleIntent");

        String action = intent.getAction();
        if (action == null)
            throw new IllegalArgumentException("Action can not be null");

        int rowCount = intent.getIntExtra(ServiceMessage.IntentExtrasKeys.ROW_COUNT, 10);
        int withTransaction = intent.getIntExtra(ServiceMessage.IntentExtrasKeys.WITH_TRANSACTION, 0);
        int selectionTypeOrdinal = intent.getIntExtra(ServiceMessage.IntentExtrasKeys.SELECTION_TYPE, 0);
        ORMBenchmarkTasks.SelectionType selectionType = ORMBenchmarkTasks.SelectionType.byOrdinal(selectionTypeOrdinal);

        ORMBenchmarkTasks benchmarkTasks;
        switch (action) {
            case ServiceMessage.IntentFilers.START_BENCHMARK_SQLITE:
                benchmarkTasks = new SQLiteBenchmarkTasks();
                break;
            case ServiceMessage.IntentFilers.START_BENCHMARK_GREENDAO:
                benchmarkTasks = new GreenDaoBenchmarkTasks();
                break;
            case ServiceMessage.IntentFilers.START_BENCHMARK_ORMLITE:
                benchmarkTasks = new ORMLiteBenchmarkTasks();
                break;
            case ServiceMessage.IntentFilers.START_BENCHMARK_ACTIVE_ANDROID:
                benchmarkTasks = new ActiveAndroidBenchmarkTask();
                break;
            case ServiceMessage.IntentFilers.START_BENCHMARK_SUGAR_ORM:
                benchmarkTasks = new SugarORMBenchmarkTask();
                break;
            default:
                throw new IllegalArgumentException("Illegal action " + action);
        }
        startORMBenchmark(benchmarkTasks, rowCount, withTransaction == 1, selectionType);
    }

    private void startORMBenchmark(ORMBenchmarkTasks benchmarkTasks, int rowCount, boolean withTransaction, ORMBenchmarkTasks.SelectionType selectionType) {
        startForeground(Constants.NotificationsID.FOREGROUND_SERVICE, getNotification());

        notifyClients(ServiceMessage.Response.START_BENCHMARK_TASK);

        boolean finishedWithoutErrors;
        OrmExcelFileLogger logger = new OrmExcelFileLogger(benchmarkTasks.getName());

        LogUtils.LOGI(TAG, "Start benchmark for: " + benchmarkTasks.getName());

        benchmarkTasks.init(getApplicationContext(), false, false);
        try {
            logger.logCreate(rowCount, benchmarkTasks.createDB());

            long time;
            for (ORMBenchmarkTasks.EntityType entityType : ORMBenchmarkTasks.EntityType.values()) {
                LogUtils.LOGI(TAG, "Start INSERT operation. Rows: " + rowCount);
                time = benchmarkTasks.insert(entityType, rowCount, withTransaction);
                logger.logInsert(entityType, withTransaction, rowCount, time);
            }
            for (ORMBenchmarkTasks.EntityType entityType : ORMBenchmarkTasks.EntityType.values()) {
                LogUtils.LOGI(TAG, "Start UPDATE operation. Rows: " + rowCount);
                time = benchmarkTasks.update(entityType, rowCount, withTransaction);
                logger.logUpdate(entityType, withTransaction, rowCount, time);
            }
            for (ORMBenchmarkTasks.EntityType entityType : ORMBenchmarkTasks.EntityType.values()) {
                LogUtils.LOGI(TAG, "Start SELECT ALL operation. Rows: " + rowCount);
                time = benchmarkTasks.selectAll(entityType, selectionType);
                logger.logSelect(entityType, selectionType, rowCount, time);
            }
            for (ORMBenchmarkTasks.EntityType entityType : ORMBenchmarkTasks.EntityType.values()) {
                LogUtils.LOGI(TAG, "Start SEARCH INDEXED operation. Rows: " + rowCount);
                time = benchmarkTasks.searchIndexed(entityType, 5);
                logger.logSearchIndexed(entityType, rowCount, time);
            }
            for (ORMBenchmarkTasks.EntityType entityType : ORMBenchmarkTasks.EntityType.values()) {
                LogUtils.LOGI(TAG, "Start SEARCH operation. Rows: " + rowCount);
                time = benchmarkTasks.search(entityType, "a");
                logger.logSearch(entityType, rowCount, time);
            }

            //logger.logDropDb(rowCount, benchmarkTasks.dropDB());

            finishedWithoutErrors = logger.commit();

        } catch (Exception e) {
            e.printStackTrace();
            finishedWithoutErrors = false;
        }

        if (finishedWithoutErrors)
            LogUtils.LOGI("ORM BENCHMARKS", "FINISH_" + benchmarkTasks.getName()
                    + "_rows=" + rowCount
                    + "_t=" + (withTransaction ? 1 : 0)
                    + "_select=" + selectionType.ordinal());
        else
            notificationManager.notify(1000, getAlertNotification());

        benchmarkFinished();

    }

    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }

    private boolean handleOnStartCommand(Intent intent) {
        if (intent != null && intent.getAction() != null) {
            String action = intent.getAction();

            switch (action) {
                case Constants.Actions.STOP_FOREGROUND_SERVICE:
                    benchmarkFinished();
                    return true;
                default:
                    return false;
            }
        } else {
            return false;
        }
    }

    private void benchmarkFinished() {
        notifyClients(ServiceMessage.Response.STOP_BENCHMARK_TASK);
        stopForeground(true);
        stopSelf();
        // todo delete databases if exists
    }

    private static void notifyClients(int messageType) {
        Bundle bundle = new Bundle();
        switch (messageType) {
            case ServiceMessage.Response.START_BENCHMARK_TASK:
                break;
            case ServiceMessage.Response.STOP_BENCHMARK_TASK:

                break;
            case ServiceMessage.Response.NOTIFY_BENCHMARK_PROGRESS:

                break;
        }
        for (Messenger client : clients) {
            try {
                Message msg = Message.obtain(null, messageType);
                msg.setData(bundle);
                client.send(msg);
            } catch (RemoteException e) {
                // Client is dead - unregister client
                LogUtils.LOGI(TAG, "UnregisterClient: " + client.toString());
                clients.remove(client);
            }
        }
    }

    private Notification getNotification() {
        Intent mainActivityIntent = new Intent(this, MainActivity.class);
        mainActivityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, mainActivityIntent, 0);

        Intent stopServiceIntent = new Intent(this, ORMBenchmarkService.class);
        stopServiceIntent.setAction(Constants.Actions.STOP_FOREGROUND_SERVICE);
        PendingIntent stopServicePendingIntent = PendingIntent.getService(this, 1, stopServiceIntent, 0);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setContentTitle("ORM Benchmark Task")
                .setTicker("ORM Benchmark Task")
                .setContentText("Testing ORMs and SQLite...")
                .setSmallIcon(R.drawable.notification_benchmark_service_small_icon)
                .setContentIntent(pendingIntent)
                .setOngoing(true)
                .addAction(R.drawable.notification_stop_service, "Stop", stopServicePendingIntent);

        return notificationBuilder.build();
    }

    private Notification getAlertNotification() {
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setContentTitle("ORM Benchmark Task FAIL")
                .setTicker("ORM Benchmark Task FAIL")
                .setContentText("Something goes wrong")
                .setSmallIcon(R.drawable.notification_benchmark_service_small_icon)
                .setSound(Uri.parse("android.resource://pl.gombal.orm_benchmarks/" + R.raw.alarm))
                .setLights(Color.RED, 1000, 500)
                .setVibrate(new long[]{1000, 1000, 1000});
        return notificationBuilder.build();
    }
}
