package pl.gombal.orm_benchmarks.io.activeandroid;

import android.provider.BaseColumns;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = MultiTable_02.TABLE_NAME, id = BaseColumns._ID)
public class MultiTable_02 extends BaseSimpleEntity {

    public static final String TABLE_NAME = "MULTI_TABLE_02";

    public static final String MULTI_TABLE_03_ID = "MULTI_TABLE_03_ID";


    @Column(name = MULTI_TABLE_03_ID)
    private MultiTable_03 multiTable_03;

    public MultiTable_02() {
        super();
    }

    
}
