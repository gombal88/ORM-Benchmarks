package pl.gombal.orm_benchmarks.io.activeandroid;

import android.provider.BaseColumns;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = MultiTable_03.TABLE_NAME, id = BaseColumns._ID)
public class MultiTable_03 extends BaseSimpleEntity {

    public static final String TABLE_NAME = "MULTI_TABLE_03";

    public static final String MULTI_TABLE_04_ID = "MULTI_TABLE_04_ID";


    @Column(name = MULTI_TABLE_04_ID)
    private MultiTable_04 multiTable_04;

    public MultiTable_03() {
        super();
    }

    public MultiTable_04 getMultiTable_04() {
        return multiTable_04;
    }

    public void setMultiTable_04(MultiTable_04 multiTable_04) {
        this.multiTable_04 = multiTable_04;
    }
}
