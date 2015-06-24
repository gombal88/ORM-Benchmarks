package pl.gombal.orm_benchmarks.io.ormlite.entity;

import android.provider.BaseColumns;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

/**
 * Created by gombal on 24.06.2015.
 */
public class BaseEntity {

    @DatabaseField(columnName = BaseColumns._ID, generatedId = true, dataType = DataType.LONG)
    protected long id;


}
