package pl.gombal.orm_benchmarks.io.ormlite.entity;

import android.provider.BaseColumns;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = MultiTable_05.TABLE_NAME)
public class MultiTable_05 extends BaseSampleEntity  {

    public static final String TABLE_NAME = "MULTI_TABLE_05";

    public static final String MULTI_TABLE_06_ID = "MULTI_TABLE_06_ID";

    private static final String MULTI_TABLE_06_NAME = pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_06.TABLE_NAME;

    @DatabaseField(columnName = MULTI_TABLE_06_ID, foreign = true,
            columnDefinition = "integer references " + MULTI_TABLE_06_NAME + "(" + BaseColumns._ID + " ) on delete cascade")
    private MultiTable_06 MultiTable_06;

    public pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_06 getMultiTable_06() {
        return MultiTable_06;
    }

    public void setMultiTable_06(pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_06 multiTable_06) {
        MultiTable_06 = multiTable_06;
    }
}
