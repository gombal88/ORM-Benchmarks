package pl.gombal.orm_benchmarks.app;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import pl.gombal.orm_benchmarks.io.greendao.entity.DaoMaster;
import pl.gombal.orm_benchmarks.io.greendao.entity.DaoSession;


public class AppController extends Application {

    public static final boolean DEBUG = true;

    public DaoSession daoSession;

    private Context appContext;

    public Context getAppContext() {
        return appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appContext = getApplicationContext();
//        setupDatabase();

//        ActiveAndroid.initialize(this, false);
    }

    private void setupDatabase() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "greendao-db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

}
