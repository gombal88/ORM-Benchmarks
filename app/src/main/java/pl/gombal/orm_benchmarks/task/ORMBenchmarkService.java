package pl.gombal.orm_benchmarks.task;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.PowerManager;
import android.os.RemoteException;
import android.support.v4.app.NotificationCompat;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.gombal.orm_benchmarks.Constants;
import pl.gombal.orm_benchmarks.R;
import pl.gombal.orm_benchmarks.io.sugarorm.SugarORMBenchmarkTask;
import pl.gombal.orm_benchmarks.ui.MainActivity;
import pl.gombal.orm_benchmarks.util.LogUtils;

public class ORMBenchmarkService extends IntentService {

    public static final String TAG = ORMBenchmarkService.class.getSimpleName();

    private List<Messenger> clients = new ArrayList<>();

    private NotificationManager notificationManager;


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

    class IncomingHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case ServiceMessage.Request.REGISTER_CLIENT:
                    clients.add(msg.replyTo);
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

        if (intent != null) {
            handleOnStartCommand(intent);
            super.onStartCommand(intent, flags, startId);
        }
        return START_STICKY;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        LogUtils.LOGD(TAG, "onHandleIntent");

        String action = intent.getAction();

        switch (action) {
            case ServiceMessage.IntentFilers.START_BENCHMARK_SQLITE:

                break;
            case ServiceMessage.IntentFilers.START_BENCHMARK_GREENDAO:

                break;
            case ServiceMessage.IntentFilers.START_BENCHMARK_ORMLITE:

                break;
            case ServiceMessage.IntentFilers.START_BENCHMARK_ACTIVE_ANDROID:

                break;
            case ServiceMessage.IntentFilers.START_BENCHMARK_SUGAR_ORM:

                break;
            default:
                throw new IllegalArgumentException("Illegal action " + action);
        }

        startForeground(Constants.NotificationsID.FOREGROUND_SERVICE, getNotification());

        notifyClients(ServiceMessage.Response.START_BENCHMARK_TASK);

        ORMBenchmarkTasks benchmarkTasks = new SugarORMBenchmarkTask();
        benchmarkTasks.init(getApplicationContext(), false, false);
        try {
            LogUtils.LOGI("ORM BENCHMARKS", "createDB: " + benchmarkTasks.createDB());

            LogUtils.LOGI("ORM BENCHMARKS", "insert to " + ORMBenchmarkTasks.EntityType.SINGLE_TAB + ": "
                    + benchmarkTasks.insert(ORMBenchmarkTasks.EntityType.SINGLE_TAB, 1000, false));
            LogUtils.LOGI("ORM BENCHMARKS", "insert to " + ORMBenchmarkTasks.EntityType.BIG_SINGLE_TAB + ": "
                    + benchmarkTasks.insert(ORMBenchmarkTasks.EntityType.BIG_SINGLE_TAB, 1000, false));
            LogUtils.LOGI("ORM BENCHMARKS", "insert to " + ORMBenchmarkTasks.EntityType.MULTI_TAB_RELATION_TO_ONE + ": "
                    + benchmarkTasks.insert(ORMBenchmarkTasks.EntityType.MULTI_TAB_RELATION_TO_ONE, 1000, false));
            LogUtils.LOGI("ORM BENCHMARKS", "insert to " + ORMBenchmarkTasks.EntityType.SINGLE_TAB_RELATION_TO_MANY + ": "
                    + benchmarkTasks.insert(ORMBenchmarkTasks.EntityType.SINGLE_TAB_RELATION_TO_MANY, 1000, false));

            LogUtils.LOGI("ORM BENCHMARKS", "update " + ORMBenchmarkTasks.EntityType.SINGLE_TAB + ": "
                    + benchmarkTasks.update(ORMBenchmarkTasks.EntityType.SINGLE_TAB, 1000, false));
            LogUtils.LOGI("ORM BENCHMARKS", "update " + ORMBenchmarkTasks.EntityType.BIG_SINGLE_TAB + ": "
                    + benchmarkTasks.update(ORMBenchmarkTasks.EntityType.BIG_SINGLE_TAB, 1000, false));
            LogUtils.LOGI("ORM BENCHMARKS", "update " + ORMBenchmarkTasks.EntityType.MULTI_TAB_RELATION_TO_ONE + ": "
                    + benchmarkTasks.update(ORMBenchmarkTasks.EntityType.MULTI_TAB_RELATION_TO_ONE, 1000, false));
            LogUtils.LOGI("ORM BENCHMARKS", "update " + ORMBenchmarkTasks.EntityType.SINGLE_TAB_RELATION_TO_MANY + ": "
                    + benchmarkTasks.update(ORMBenchmarkTasks.EntityType.SINGLE_TAB_RELATION_TO_MANY, 1000, false));

            LogUtils.LOGI("ORM BENCHMARKS", "selectAll " + ORMBenchmarkTasks.EntityType.SINGLE_TAB + ": "
                    + benchmarkTasks.selectAll(ORMBenchmarkTasks.EntityType.SINGLE_TAB, ORMBenchmarkTasks.SelectionType.COUNT_ONLY));
            LogUtils.LOGI("ORM BENCHMARKS", "selectAll " + ORMBenchmarkTasks.EntityType.BIG_SINGLE_TAB + ": "
                    + benchmarkTasks.selectAll(ORMBenchmarkTasks.EntityType.BIG_SINGLE_TAB, ORMBenchmarkTasks.SelectionType.COUNT_ONLY));
            LogUtils.LOGI("ORM BENCHMARKS", "selectAll " + ORMBenchmarkTasks.EntityType.MULTI_TAB_RELATION_TO_ONE + ": "
                    + benchmarkTasks.selectAll(ORMBenchmarkTasks.EntityType.MULTI_TAB_RELATION_TO_ONE, ORMBenchmarkTasks.SelectionType.COUNT_ONLY));
            LogUtils.LOGI("ORM BENCHMARKS", "selectAll " + ORMBenchmarkTasks.EntityType.SINGLE_TAB_RELATION_TO_MANY + ": "
                    + benchmarkTasks.selectAll(ORMBenchmarkTasks.EntityType.SINGLE_TAB_RELATION_TO_MANY, ORMBenchmarkTasks.SelectionType.COUNT_ONLY));

            LogUtils.LOGI("ORM BENCHMARKS", "searchIndex " + ORMBenchmarkTasks.EntityType.SINGLE_TAB + ": "
                    + benchmarkTasks.searchIndexed(ORMBenchmarkTasks.EntityType.SINGLE_TAB, 5));
            LogUtils.LOGI("ORM BENCHMARKS", "searchIndex " + ORMBenchmarkTasks.EntityType.BIG_SINGLE_TAB + ": "
                    + benchmarkTasks.searchIndexed(ORMBenchmarkTasks.EntityType.BIG_SINGLE_TAB, 5));
            LogUtils.LOGI("ORM BENCHMARKS", "searchIndex " + ORMBenchmarkTasks.EntityType.MULTI_TAB_RELATION_TO_ONE + ": "
                    + benchmarkTasks.searchIndexed(ORMBenchmarkTasks.EntityType.MULTI_TAB_RELATION_TO_ONE, 5));
            LogUtils.LOGI("ORM BENCHMARKS", "searchIndex " + ORMBenchmarkTasks.EntityType.SINGLE_TAB_RELATION_TO_MANY + ": "
                    + benchmarkTasks.searchIndexed(ORMBenchmarkTasks.EntityType.SINGLE_TAB_RELATION_TO_MANY, 5));

            LogUtils.LOGI("ORM BENCHMARKS", "search letter - a " + ORMBenchmarkTasks.EntityType.SINGLE_TAB + ": "
                    + benchmarkTasks.search(ORMBenchmarkTasks.EntityType.SINGLE_TAB, "a"));
            LogUtils.LOGI("ORM BENCHMARKS", "search letter - a " + ORMBenchmarkTasks.EntityType.BIG_SINGLE_TAB + ": "
                    + benchmarkTasks.search(ORMBenchmarkTasks.EntityType.BIG_SINGLE_TAB, "a"));
            LogUtils.LOGI("ORM BENCHMARKS", "search letter - a " + ORMBenchmarkTasks.EntityType.MULTI_TAB_RELATION_TO_ONE + ": "
                    + benchmarkTasks.search(ORMBenchmarkTasks.EntityType.MULTI_TAB_RELATION_TO_ONE, "a"));
            LogUtils.LOGI("ORM BENCHMARKS", "search letter - a " + ORMBenchmarkTasks.EntityType.SINGLE_TAB_RELATION_TO_MANY + ": "
                    + benchmarkTasks.search(ORMBenchmarkTasks.EntityType.SINGLE_TAB_RELATION_TO_MANY, "a"));

            LogUtils.LOGI("ORM BENCHMARKS", "dropDB: " + benchmarkTasks.dropDB());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        notifyClients(ServiceMessage.Response.STOP_BENCHMARK_TASK);
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
                    notifyClients(ServiceMessage.Response.STOP_BENCHMARK_TASK);
                    stopForeground(true);
                    stopSelf();
                    return true;
                default:
                    return false;
            }
        } else {
            return false;
        }
    }

    private void notifyClients(int messageType) {
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
}
