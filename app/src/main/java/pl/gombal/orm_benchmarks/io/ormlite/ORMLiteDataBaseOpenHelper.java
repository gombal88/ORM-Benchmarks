package pl.gombal.orm_benchmarks.io.ormlite;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;

import pl.gombal.orm_benchmarks.R;

public class ORMLiteDataBaseOpenHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATA_BASE_NAME = "ormlite-db";
    public static final int DATA_BASE_VERSION = 2;

    private static ORMLiteDataBaseOpenHelper instance;

    public static ORMLiteDataBaseOpenHelper getInstance() {
        if (instance == null) {
            throw new InstantiationError("Initialize first ORMLiteDataBaseOpenHelper by call init()!");
        }
        return instance;
    }

    public static void init(Context context) {
        init(context, false);
    }

    public static void init(Context context, boolean inMemory) {
        instance  = new ORMLiteDataBaseOpenHelper(context, inMemory);
    }

    private ORMLiteDataBaseOpenHelper(Context context, boolean inMemory) {
        super(context, inMemory ? null : DATA_BASE_NAME, null, DATA_BASE_VERSION, R.raw.ormlite_config);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }
}
