package pl.gombal.orm_benchmarks.io.ormlite.entity;

import android.provider.BaseColumns;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = MultiTable_07.TABLE_NAME)
public class MultiTable_07 extends BaseSampleEntity  {

    public static final String TABLE_NAME = "MULTI_TABLE_07";

    public static final String MULTI_TABLE_08_ID = "MULTI_TABLE_08_ID";

    private static final String MULTI_TABLE_08_NAME = pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_08.TABLE_NAME;

    @DatabaseField(columnName = MULTI_TABLE_08_ID, foreign = true,
            columnDefinition = "integer references " + MULTI_TABLE_08_NAME + "(" + BaseColumns._ID + " ) on delete cascade")
    private MultiTable_08 MultiTable_08;

    public pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_08 getMultiTable_08() {
        return MultiTable_08;
    }

    public void setMultiTable_08(pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_08 multiTable_08) {
        MultiTable_08 = multiTable_08;
    }
}
