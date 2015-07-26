package pl.gombal.orm_benchmarks.task;


import android.os.Handler;
import android.os.Looper;
import android.os.Message;


public class BenchmarkWorker extends Thread {

    public static final int START_WORK = 100;

    private Handler serviceProgressHandler = null;
    private Handler workerHandler = null;

    public BenchmarkWorker(Handler serviceProgressHandler) {
        this.serviceProgressHandler = serviceProgressHandler;
    }

    @Override
    public void run() {
        Looper.prepare();

        workerHandler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case START_WORK:
                        serviceProgressHandler.sendEmptyMessage(1);


                        break;
                }
                super.handleMessage(msg);
            }
        };

        Looper.loop();
    }

    public Handler getWorkerHandler() {
        return workerHandler;
    }

    public void startBenchmarkWork() {
        if (workerHandler != null) {
            Message msg = workerHandler.obtainMessage(START_WORK);
            workerHandler.sendMessage(msg);
        }
    }
}
