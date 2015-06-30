package pl.gombal.orm_benchmarks.util;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class DataBaseUtils {



    public static boolean databaseExists(Context context, String dbName) {
        String databasePath = context.getApplicationInfo().dataDir + "/databases/" + dbName;
        File dbFile = context.getDatabasePath(databasePath);
        return dbFile.exists();
    }

    public static void deleteDataBase(Context context, String dbName) {
        String databasePath = context.getApplicationInfo().dataDir + "/databases/" + dbName;
        File file = new File(databasePath);
        if (file.exists()) {
            file.delete();
        }
    }

    public static void copyDBFileFromAssets(Context context, String dbName) {

        String databasePath = context.getApplicationInfo().dataDir + "/databases/" + dbName;

        try {
            InputStream inputDataBaseFile = context.getAssets().open(dbName);
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

    public static void loadDataBaseFileFomAssets(Context context, String dbName) {
        if (databaseExists(context, dbName)) {
            deleteDataBase(context, dbName);
        }
        copyDBFileFromAssets(context, dbName);
    }

}
