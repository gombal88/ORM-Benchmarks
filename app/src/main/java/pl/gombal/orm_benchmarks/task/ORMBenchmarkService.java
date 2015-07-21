package pl.gombal.orm_benchmarks.task;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat;

import java.util.ArrayList;
import java.util.List;

import pl.gombal.orm_benchmarks.Constants;
import pl.gombal.orm_benchmarks.R;
import pl.gombal.orm_benchmarks.ui.MainActivity;

public class ORMBenchmarkService extends Service {

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
                case ServiceMessage.Request.RUN_BENCHMARK:

                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }


    @Override
    public void onCreate() {
        super.onCreate();
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        handleCommand(intent);

        startForeground(Constants.NotificationsID.FOREGROUND_SERVICE, getNotification());

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return true;
    }

    private boolean handleCommand(Intent intent) {
        if (intent != null && intent.getAction() != null) {
            String action = intent.getAction();

            switch (action) {
                case Constants.Actions.STOP_FOREGROUND_SERVICE:
                    //// TODO:
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
