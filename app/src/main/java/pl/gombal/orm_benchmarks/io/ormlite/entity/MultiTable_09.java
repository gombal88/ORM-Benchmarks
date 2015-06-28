package pl.gombal.orm_benchmarks.io.ormlite.entity;

import android.provider.BaseColumns;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = MultiTable_09.TABLE_NAME)
public class MultiTable_09 extends BaseSampleEntity  {

    public static final String TABLE_NAME = "MULTI_TABLE_09";

    public static final String MULTI_TABLE_10_ID = "MULTI_TABLE_10_ID";

    private static final String MULTI_TABLE_10_NAME = pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_10.TABLE_NAME;

    @DatabaseField(columnName = MULTI_TABLE_10_ID, foreign = true,
            columnDefinition = "integer references " + MULTI_TABLE_10_NAME + "(" + BaseColumns._ID + " ) on delete cascade")
    private MultiTable_10 MultiTable_10;

    public pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_10 getMultiTable_10() {
        return MultiTable_10;
    }

    public void setMultiTable_10(pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_10 multiTable_10) {
        MultiTable_10 = multiTable_10;
    }
}
