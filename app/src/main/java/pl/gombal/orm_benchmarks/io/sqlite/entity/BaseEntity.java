package pl.gombal.orm_benchmarks.io.sqlite.entity;

import android.content.ContentValues;
import android.database.Cursor;

public abstract class BaseEntity {

    protected long id;

    public abstract BaseEntity fromCursor(Cursor cursor);

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
