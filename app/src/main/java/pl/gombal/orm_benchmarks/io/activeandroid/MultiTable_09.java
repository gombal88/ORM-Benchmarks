package pl.gombal.orm_benchmarks.io.activeandroid;

import android.provider.BaseColumns;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = MultiTable_09.TABLE_NAME, id = BaseColumns._ID)
public class MultiTable_09 extends BaseSimpleEntity {

    public static final String TABLE_NAME = "MULTI_TABLE_09";

    public static final String MULTI_TABLE_10_ID = "MULTI_TABLE_10_ID";


    @Column(name = MULTI_TABLE_10_ID)
    private MultiTable_10 multiTable_10;

    public MultiTable_09() {
        super();
    }


    public MultiTable_10 getMultiTable_10() {
        return multiTable_10;
    }

    public void setMultiTable_10(MultiTable_10 multiTable_10) {
        this.multiTable_10 = multiTable_10;
    }
}
