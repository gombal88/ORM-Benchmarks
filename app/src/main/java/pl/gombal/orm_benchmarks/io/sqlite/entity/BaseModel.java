package pl.gombal.orm_benchmarks.io.sqlite.entity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by gombal on 21.06.2015.
 */
public abstract class BaseModel implements BaseColumns {

    private boolean innerTab = false;
    private String tableName;

    public static final String SAMPLE_STRING_COLL_01 = "SampleStringColl01";
    public static final String SAMPLE_STRING_COLL_02 = "SampleStringColl02";
    public static final String SAMPLE_STRING_COLL_03 = "SampleStringColl03";
    public static final String SAMPLE_STRING_COLL_04 = "SampleStringColl04";
    public static final String SAMPLE_STRING_COLL_05 = "SampleStringColl05";
    public static final String SAMPLE_STRING_COLL_06 = "SampleStringColl06";
    public static final String SAMPLE_STRING_COLL_07 = "SampleStringColl07";
    public static final String SAMPLE_STRING_COLL_08 = "SampleStringColl08";
    public static final String SAMPLE_STRING_COLL_09 = "SampleStringColl09";
    public static final String SAMPLE_STRING_COLL_10 = "SampleStringColl10";
    public static final String SAMPLE_INT_COLL_01 = "SampleIntColl01";
    public static final String SAMPLE_INT_COLL_02 = "SampleIntColl02";
    public static final String SAMPLE_REAL_COLL_01 = "SampleRealColl01";
    public static final String SAMPLE_REAL_COLL_02 = "SampleRealColl02";
    public static final String SAMPLE_INT_COLL_INDEXED = "SampleIntCollIndexed";

    public abstract String getCreateStatement();
    public abstract String getDropStatement();
    public abstract String[] getColumns();
    public abstract ContentValues getContentValues();
    protected abstract long saveAction(SQLiteDatabase db);
    protected abstract void updateAction(SQLiteDatabase db, String selection, String[] selectionArgs);

    public BaseModel(String tableName) {
        this(tableName, false);
    }

    public BaseModel(String tableName, boolean innerTab) {

        this.innerTab = innerTab;
        this.tableName = tableName;
    }

    public boolean isInnerTab() {
        return innerTab;
    }

    public void setInnerTab(boolean innerTab) {
        this.innerTab = innerTab;
    }

    public String getTableName() {
        return tableName;
    }

}
