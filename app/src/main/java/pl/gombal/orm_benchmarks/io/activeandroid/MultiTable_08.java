package pl.gombal.orm_benchmarks.io.activeandroid;

import android.provider.BaseColumns;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = MultiTable_08.TABLE_NAME, id = BaseColumns._ID)
public class MultiTable_08 extends BaseSimpleEntity {

    public static final String TABLE_NAME = "MULTI_TABLE_08";

    public static final String MULTI_TABLE_09_ID = "MULTI_TABLE_09_ID";


    @Column(name = MULTI_TABLE_09_ID)
    private MultiTable_09 multiTable_09;

    public MultiTable_08() {
        super();
    }

    public MultiTable_09 getMultiTable_09() {
        return multiTable_09;
    }

    public void setMultiTable_09(MultiTable_09 multiTable_09) {
        this.multiTable_09 = multiTable_09;
    }
}
