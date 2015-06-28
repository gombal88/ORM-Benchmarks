package pl.gombal.orm_benchmarks.io.activeandroid;

import android.provider.BaseColumns;

import com.activeandroid.annotation.Table;

@Table(name = SingleTable.TABLE_NAME, id = BaseColumns._ID)
public class SingleTable extends BaseSimpleEntity {

    public static final String TABLE_NAME = "SINGLE_TABLE";

    public SingleTable() {
        super();
    }
}
