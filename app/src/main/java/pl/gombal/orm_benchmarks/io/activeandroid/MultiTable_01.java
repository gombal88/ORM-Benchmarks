package pl.gombal.orm_benchmarks.io.activeandroid;

import android.provider.BaseColumns;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = MultiTable_01.TABLE_NAME, id = BaseColumns._ID)
public class MultiTable_01 extends BaseSimpleEntity {

    public static final String TABLE_NAME = "MULTI_TABLE_01";

    public static final String MULTI_TABLE_02_ID = "MULTI_TABLE_02_ID";


    @Column(name = MULTI_TABLE_02_ID)
    private MultiTable_02 multiTable_02;

    public MultiTable_01() {
        super();
    }

    public MultiTable_02 getMultiTable_02() {
        return multiTable_02;
    }

    public void setMultiTable_02(MultiTable_02 multiTable_02) {
        this.multiTable_02 = multiTable_02;
    }
}
