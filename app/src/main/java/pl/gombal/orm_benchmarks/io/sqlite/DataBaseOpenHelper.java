package pl.gombal.orm_benchmarks.io.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by gombal on 21.06.2015.
 */
public class DataBaseOpenHelper extends SQLiteOpenHelper {

    private Context context;

    private static String DATA_BASE_NAME = "sqlite-db";
    private static String DB_PATH;
    public static final int DATA_BASE_VERSION = 1;


    public DataBaseOpenHelper(Context context, boolean inMemory) {
        this(context, DATA_BASE_NAME, inMemory, false);
    }

    public DataBaseOpenHelper(Context context, String databaseName, boolean inMemory, boolean loadFromAssets) {
        super(context, inMemory ? null : databaseName, null, DATA_BASE_VERSION);
        this.context = context;
        DATA_BASE_NAME = databaseName;

        if (loadFromAssets) {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
            if (databaseExists()) {
                deleteDataBase();
            } else {
                /* Database does not exists create blank database */
                getReadableDatabase().close();
            }
            copyDataBase();
        }
    }

    /**
     * Check Database if it exists
     */
    private boolean databaseExists() {
        String databasePath = DB_PATH + DATA_BASE_NAME;
        File dbFile = context.getDatabasePath(databasePath);
        return dbFile.exists();
    }

    private void deleteDataBase() {
        String databasePath = DB_PATH + DATA_BASE_NAME;
        File file = new File(databasePath);
        if (file.exists()) {
            file.delete();
        }
    }

    public void copyDataBase() {

        String databasePath = DB_PATH + DATA_BASE_NAME;

        try {
            InputStream inputDataBaseFile = context.getAssets().open(DATA_BASE_NAME);
            OutputStream outputDataBaseFile = new FileOutputStream(databasePath);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = inputDataBaseFile.read(buffer)) > 0) {
                outputDataBaseFile.write(buffer, 0, length);
            }

            // Close the streams
            outputDataBaseFile.flush();
            outputDataBaseFile.close();
            inputDataBaseFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
