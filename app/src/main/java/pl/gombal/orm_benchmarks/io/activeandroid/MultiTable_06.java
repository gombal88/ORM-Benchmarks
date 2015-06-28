package pl.gombal.orm_benchmarks.io.activeandroid;

import android.provider.BaseColumns;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = MultiTable_06.TABLE_NAME, id = BaseColumns._ID)
public class MultiTable_06 extends BaseSimpleEntity {

    public static final String TABLE_NAME = "MULTI_TABLE_06";

    public static final String MULTI_TABLE_07_ID = "MULTI_TABLE_07_ID";


    @Column(name = MULTI_TABLE_07_ID)
    private MultiTable_07 multiTable_07;

    public MultiTable_06() {
        super();
    }

    public MultiTable_07 getMultiTable_07() {
        return multiTable_07;
    }

    public void setMultiTable_07(MultiTable_07 multiTable_07) {
        this.multiTable_07 = multiTable_07;
    }
}
