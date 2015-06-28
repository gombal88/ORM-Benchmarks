package pl.gombal.orm_benchmarks.io.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBaseOpenHelper extends SQLiteOpenHelper {

    private static String DATA_BASE_NAME = "sqlite-db";
    public static final int DATA_BASE_VERSION = 1;

    public DataBaseOpenHelper(Context context) {
        this(context, DATA_BASE_NAME, DATA_BASE_VERSION, false);
    }

    public DataBaseOpenHelper(Context context, boolean inMemory) {
        this(context, DATA_BASE_NAME, DATA_BASE_VERSION, inMemory);
    }

    public DataBaseOpenHelper(Context context, String databaseName, int dbVersion, boolean inMemory) {
        super(context, inMemory ? null : databaseName, null, dbVersion);
        DATA_BASE_NAME = databaseName;

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        // Enable foreign key constraints
        db.execSQL("PRAGMA foreign_keys=ON;");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
