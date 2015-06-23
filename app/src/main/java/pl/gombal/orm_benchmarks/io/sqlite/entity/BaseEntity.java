package pl.gombal.orm_benchmarks.io.sqlite.entity;

import android.content.ContentValues;

/**
 * Created by gombal on 21.06.2015.
 */
public abstract class BaseEntity {

    protected long id;

    public abstract ContentValues getContentValues();

    public BaseEntity() {
    }

    public BaseEntity(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
