package pl.gombal.orm_benchmarks.io.ormlite.entity;

import android.provider.BaseColumns;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = MultiTable_08.TABLE_NAME)
public class MultiTable_08 extends BaseSampleEntity  {

    public static final String TABLE_NAME = "MULTI_TABLE_08";

    public static final String MULTI_TABLE_09_ID = "MULTI_TABLE_09_ID";

    private static final String MULTI_TABLE_09_NAME = pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_09.TABLE_NAME;

    @DatabaseField(columnName = MULTI_TABLE_09_ID, foreign = true,
            columnDefinition = "integer references " + MULTI_TABLE_09_NAME + "(" + BaseColumns._ID + " ) on delete cascade")
    private MultiTable_09 MultiTable_09;

    public pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_09 getMultiTable_09() {
        return MultiTable_09;
    }

    public void setMultiTable_09(pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_09 multiTable_09) {
        MultiTable_09 = multiTable_09;
    }
}
