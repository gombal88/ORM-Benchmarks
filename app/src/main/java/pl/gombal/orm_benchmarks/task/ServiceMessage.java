package pl.gombal.orm_benchmarks.task;


public interface ServiceMessage {

    interface Request {
        int REGISTER_CLIENT = 1;
        int UNREGISTER_CLIENT = 2;
        int RUN_BENCHMARK = 3;
    }

    interface Response {

    }

}
