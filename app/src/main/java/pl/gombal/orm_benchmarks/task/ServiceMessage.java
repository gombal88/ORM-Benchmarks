package pl.gombal.orm_benchmarks.task;


public interface ServiceMessage {

    String PACKAGE_NAME = "pl.gombal.orm_benchmarks";

    interface Request {
        int REGISTER_CLIENT = 1;
        int UNREGISTER_CLIENT = 2;
    }

    interface Response {
        int START_BENCHMARK_TASK = 1;
        int STOP_BENCHMARK_TASK = 2;
        int NOTIFY_BENCHMARK_PROGRESS = 3;
        int NOTIFY_ERROR = 4;
    }

    interface IntentFilers {
        String START_BENCHMARK_SQLITE = PACKAGE_NAME + ".action.START_SQLITE_BENCHMARK";
        String START_BENCHMARK_GREENDAO = PACKAGE_NAME + ".action.START_GREENDAO_BENCHMARK";
        String START_BENCHMARK_ORMLITE = PACKAGE_NAME + ".action.START_ORMLITE_BENCHMARK";
        String START_BENCHMARK_ACTIVE_ANDROID = PACKAGE_NAME + ".action.START_ACTIVE_ANDROID_BENCHMARK";
        String START_BENCHMARK_SUGAR_ORM = PACKAGE_NAME + ".action.START_SUGAR_ORM_BENCHMARK";
    }

}
