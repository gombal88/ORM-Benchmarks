package pl.gombal.orm_benchmarks.io.sqlite.entity;

import android.content.ContentValues;
import android.database.Cursor;

public abstract class BaseEntity {

    protected Long id = null;

    public abstract BaseEntity fromCursor(Cursor cursor);

    public abstract ContentValues getContentValues();

    public BaseEntity() {
    }

    public BaseEntity(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
