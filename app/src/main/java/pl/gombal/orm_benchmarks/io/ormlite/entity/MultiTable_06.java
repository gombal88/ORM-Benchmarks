package pl.gombal.orm_benchmarks.io.ormlite.entity;

import android.provider.BaseColumns;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = MultiTable_06.TABLE_NAME)
public class MultiTable_06 extends BaseSampleEntity  {

    public static final String TABLE_NAME = "MULTI_TABLE_06";

    public static final String MULTI_TABLE_07_ID = "MULTI_TABLE_07_ID";

    private static final String MULTI_TABLE_07_NAME = pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_07.TABLE_NAME;

    @DatabaseField(columnName = MULTI_TABLE_07_ID, foreign = true,
            columnDefinition = "integer references " + MULTI_TABLE_07_NAME + "(" + BaseColumns._ID + " ) on delete cascade")
    private MultiTable_07 MultiTable_07;

    public pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_07 getMultiTable_07() {
        return MultiTable_07;
    }

    public void setMultiTable_07(pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_07 multiTable_07) {
        MultiTable_07 = multiTable_07;
    }
}
