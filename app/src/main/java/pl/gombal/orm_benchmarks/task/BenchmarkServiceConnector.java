package pl.gombal.orm_benchmarks.task;


import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

import pl.gombal.orm_benchmarks.util.LogUtils;

public class BenchmarkServiceConnector implements ServiceConnection {

    private static final String TAG = "BenchmarkServiceConnector";

    class ResponseHandler extends Handler {

        public ResponseHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case ServiceMessage.Response.START_BENCHMARK_TASK:
                    if (serviceCallback != null) {
                        serviceCallback.onBenchmarkTaskStart();
                    }
                    break;
                case ServiceMessage.Response.STOP_BENCHMARK_TASK:
                    if (serviceCallback != null) {
                        serviceCallback.onBenchmarkTaskStop();
                    }
                    break;
                case ServiceMessage.Response.NOTIFY_BENCHMARK_PROGRESS:
                    if (serviceCallback != null) {
                        serviceCallback.onBenchmarkNotifyProgress();
                    }
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }

    public interface BenchmarkServiceCallback {
        void onBenchmarkServiceConnected();
        void onBenchmarkServiceDisconnected();
        void bindingServiceFailed();
        void onBenchmarkTaskStart();
        void onBenchmarkTaskStop();
        void onBenchmarkNotifyProgress();
    }

    private BenchmarkServiceCallback serviceCallback = null;

    private final Messenger clientMessenger = new Messenger(new ResponseHandler(Looper.getMainLooper()));
    private Messenger serviceMessenger = null;
    private boolean bound = false;

    private Context context;


    private static BenchmarkServiceConnector instance = null;

    public static synchronized BenchmarkServiceConnector getInstance(Context context) {
        if (instance == null)
            instance = new BenchmarkServiceConnector(context);
        return instance;
    }

    private BenchmarkServiceConnector(Context context) {
        this.context = context.getApplicationContext();
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        LogUtils.LOGD(TAG, "onServiceConnected " + name.getShortClassName());
        serviceMessenger = new Messenger(service);
        registerClient();
        if (serviceCallback != null) {
            serviceCallback.onBenchmarkServiceConnected();
        }
    }


    @Override
    public void onServiceDisconnected(ComponentName name) {
        LogUtils.LOGD(TAG, "onServiceDisconnected " + name.getShortClassName());
        bound = false;
        serviceMessenger = null;
        if (serviceCallback != null)
            serviceCallback.onBenchmarkServiceDisconnected();
    }

    public void startBenchmarkService() {
        context.startService(new Intent(context, ORMBenchmarkService.class));
    }

    public void doBindService() {
        doBindService(null);
    }

    public void doBindService(BenchmarkServiceCallback serviceCallback) {
        this.serviceCallback = serviceCallback;
        Intent bindIntent = new Intent(context, ORMBenchmarkService.class);
        if (context.bindService(bindIntent, this, Context.BIND_AUTO_CREATE)) {
            bound = true;
            LogUtils.LOGD(TAG, "ORMBenchmarkService bound");
        } else {
            LogUtils.LOGD(TAG, "ORMBenchmarkService not bound");
            if (serviceCallback != null)
                serviceCallback.bindingServiceFailed();
        }
    }

    public void doUnbindService() {
        if (bound && serviceMessenger != null) {
            unregisterClient();
            context.unbindService(this);
            bound = false;
        }
    }

    private void registerClient() {
        try {
            Message msg = Message.obtain(null, ServiceMessage.Request.REGISTER_CLIENT);
            msg.replyTo = clientMessenger;
            serviceMessenger.send(msg);
        } catch (RemoteException ignored) {
            // Service has crashed
        }
    }

    private void unregisterClient() {
        try {
            Message msgUnregister = Message.obtain(null, ServiceMessage.Request.UNREGISTER_CLIENT);
            msgUnregister.replyTo = clientMessenger;
            serviceMessenger.send(msgUnregister);
        } catch (RemoteException ignored) {
            // Service has crashed
        }
    }
}
