package pl.gombal.orm_benchmarks.io.sqlite.entity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by gombal on 21.06.2015.
 */
public class SingleTableModel extends BaseModel {


    public SingleTableModel(String tableName) {
        super(tableName);
    }

    @Override
    public String getCreateStatement() {
        return null;
    }

    @Override
    public String getDropStatement() {
        return null;
    }

    @Override
    public String[] getColumns() {
        return new String[0];
    }

    @Override
    public ContentValues getContentValues() {
        return null;
    }

    @Override
    protected long saveAction(SQLiteDatabase db) {
        return 0;
    }

    @Override
    protected void updateAction(SQLiteDatabase db, String selection, String[] selectionArgs) {

    }
}
