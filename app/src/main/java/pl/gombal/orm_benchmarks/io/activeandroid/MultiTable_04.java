package pl.gombal.orm_benchmarks.io.activeandroid;

import android.provider.BaseColumns;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = MultiTable_04.TABLE_NAME, id = BaseColumns._ID)
public class MultiTable_04 extends BaseSimpleEntity {

    public static final String TABLE_NAME = "MULTI_TABLE_04";

    public static final String MULTI_TABLE_05_ID = "MULTI_TABLE_05_ID";


    @Column(name = MULTI_TABLE_05_ID)
    private MultiTable_05 multiTable_05;

    public MultiTable_04() {
        super();
    }

    public MultiTable_05 getMultiTable_05() {
        return multiTable_05;
    }

    public void setMultiTable_05(MultiTable_05 multiTable_05) {
        this.multiTable_05 = multiTable_05;
    }
}
