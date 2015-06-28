package pl.gombal.orm_benchmarks.io.ormlite.entity;

import android.provider.BaseColumns;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = MultiTable_04.TABLE_NAME)
public class MultiTable_04 extends BaseSampleEntity  {

    public static final String TABLE_NAME = "MULTI_TABLE_04";

    public static final String MULTI_TABLE_05_ID = "MULTI_TABLE_05_ID";

    private static final String MULTI_TABLE_05_NAME = pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_05.TABLE_NAME;

    @DatabaseField(columnName = MULTI_TABLE_05_ID, foreign = true,
            columnDefinition = "integer references " + MULTI_TABLE_05_NAME + "(" + BaseColumns._ID + " ) on delete cascade")
    private MultiTable_05 MultiTable_05;

    public pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_05 getMultiTable_05() {
        return MultiTable_05;
    }

    public void setMultiTable_05(pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_05 multiTable_05) {
        MultiTable_05 = multiTable_05;
    }
}
