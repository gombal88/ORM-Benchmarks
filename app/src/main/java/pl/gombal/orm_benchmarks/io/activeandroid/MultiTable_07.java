package pl.gombal.orm_benchmarks.io.activeandroid;

import android.provider.BaseColumns;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = MultiTable_07.TABLE_NAME, id = BaseColumns._ID)
public class MultiTable_07 extends BaseSimpleEntity {

    public static final String TABLE_NAME = "MULTI_TABLE_07";

    public static final String MULTI_TABLE_08_ID = "MULTI_TABLE_08_ID";


    @Column(name = MULTI_TABLE_08_ID)
    private MultiTable_08 multiTable_08;

    public MultiTable_07() {
        super();
    }

    public MultiTable_08 getMultiTable_08() {
        return multiTable_08;
    }

    public void setMultiTable_08(MultiTable_08 multiTable_08) {
        this.multiTable_08 = multiTable_08;
    }
}
