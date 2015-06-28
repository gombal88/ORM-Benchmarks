package pl.gombal.orm_benchmarks.io.ormlite.entity;

import android.provider.BaseColumns;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;


public abstract class BaseEntity {

    @DatabaseField(columnName = BaseColumns._ID, generatedId = true, dataType = DataType.LONG)
    protected long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
