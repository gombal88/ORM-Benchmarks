package pl.gombal.orm_benchmarks.app;

import android.database.sqlite.SQLiteDatabase;

import com.activeandroid.ActiveAndroid;
import com.orm.SugarApp;

import pl.gombal.orm_benchmarks.io.greendao.entity.DaoMaster;
import pl.gombal.orm_benchmarks.io.greendao.entity.DaoSession;


public class AppController extends SugarApp {

    public static final boolean DEBUG = false;

    public DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

//        setupDatabase();


        ActiveAndroid.initialize(this);
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
