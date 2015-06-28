package pl.gombal.orm_benchmarks.io.ormlite.entity;

import android.provider.BaseColumns;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = MultiTable_01.TABLE_NAME)
public class MultiTable_01 extends BaseSampleEntity {

    public static final String TABLE_NAME = "MULTI_TABLE_01";

    public static final String MULTI_TABLE_02_ID = "MULTI_TABLE_02_ID";

    private static final String MULTI_TABLE_02_NAME = pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_02.TABLE_NAME;

    @DatabaseField(columnName = MULTI_TABLE_02_ID, foreign = true,
            columnDefinition = "integer references " + MULTI_TABLE_02_NAME + "(" + BaseColumns._ID + " ) on delete cascade")
    private MultiTable_02 MultiTable_02;

    public pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_02 getMultiTable_02() {
        return MultiTable_02;
    }

    public void setMultiTable_02(pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_02 multiTable_02) {
        MultiTable_02 = multiTable_02;
    }
}
