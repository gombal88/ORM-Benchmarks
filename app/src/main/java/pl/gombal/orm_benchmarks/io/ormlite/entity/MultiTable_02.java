package pl.gombal.orm_benchmarks.io.ormlite.entity;

import android.provider.BaseColumns;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = MultiTable_02.TABLE_NAME)
public class MultiTable_02 extends BaseSampleEntity  {

    public static final String TABLE_NAME = "MULTI_TABLE_02";

    public static final String MULTI_TABLE_03_ID = "MULTI_TABLE_03_ID";

    private static final String MULTI_TABLE_03_NAME = pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_03.TABLE_NAME;

    @DatabaseField(columnName = MULTI_TABLE_03_ID, foreign = true,
            columnDefinition = "integer references " + MULTI_TABLE_03_NAME + "(" + BaseColumns._ID + " ) on delete cascade")
    private MultiTable_03 MultiTable_03;

    public pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_03 getMultiTable_03() {
        return MultiTable_03;
    }

    public void setMultiTable_03(pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_03 multiTable_03) {
        MultiTable_03 = multiTable_03;
    }
}
