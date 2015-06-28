package pl.gombal.orm_benchmarks.io.activeandroid;

import android.provider.BaseColumns;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = MultiTable_05.TABLE_NAME, id = BaseColumns._ID)
public class MultiTable_05 extends BaseSimpleEntity {

    public static final String TABLE_NAME = "MULTI_TABLE_05";

    public static final String MULTI_TABLE_06_ID = "MULTI_TABLE_06_ID";


    @Column(name = MULTI_TABLE_06_ID)
    private MultiTable_06 multiTable_06;

    public MultiTable_05() {
        super();
    }

    public MultiTable_06 getMultiTable_06() {
        return multiTable_06;
    }

    public void setMultiTable_06(MultiTable_06 multiTable_06) {
        this.multiTable_06 = multiTable_06;
    }
}
