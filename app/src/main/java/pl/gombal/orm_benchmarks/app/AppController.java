package pl.gombal.orm_benchmarks.app;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import pl.gombal.orm_benchmarks.io.greendao.entity.DaoMaster;
import pl.gombal.orm_benchmarks.io.greendao.entity.DaoSession;


/**
 * Created by gombal on 20.06.2015.
 */
public class AppController extends Application {

    public static final boolean DEBUG = true;

    public DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        setupDatabase();
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
