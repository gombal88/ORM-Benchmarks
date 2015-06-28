package pl.gombal.orm_benchmarks.io.ormlite.entity;

import android.provider.BaseColumns;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = MultiTable_03.TABLE_NAME)
public class MultiTable_03 extends BaseSampleEntity  {

    public static final String TABLE_NAME = "MULTI_TABLE_03";

    public static final String MULTI_TABLE_04_ID = "MULTI_TABLE_04_ID";

    private static final String MULTI_TABLE_04_NAME = pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_04.TABLE_NAME;

    @DatabaseField(columnName = MULTI_TABLE_04_ID, foreign = true,
            columnDefinition = "integer references " + MULTI_TABLE_04_NAME + "(" + BaseColumns._ID + " ) on delete cascade")
    private MultiTable_04 MultiTable_04;

    public pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_04 getMultiTable_04() {
        return MultiTable_04;
    }

    public void setMultiTable_04(pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_04 multiTable_04) {
        MultiTable_04 = multiTable_04;
    }
}
