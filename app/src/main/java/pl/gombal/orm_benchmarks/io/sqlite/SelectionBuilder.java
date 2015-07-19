package pl.gombal.orm_benchmarks.io.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import pl.gombal.orm_benchmarks.util.LogUtils;

public class SelectionBuilder {
    private static final String TAG =  SelectionBuilder.class.getSimpleName();

    boolean distinct = false;
    private String table = null;
    private Map<String, String> projectionMap = new HashMap<String, String>();
    private StringBuilder selection = new StringBuilder();
    private ArrayList<String> selectionArgs = new ArrayList<String>();

    public SelectionBuilder reset() {
        table = null;
        selection.setLength(0);
        selectionArgs.clear();
        return this;
    }

    public SelectionBuilder where(String selection, String... selectionArgs) {
        if (TextUtils.isEmpty(selection)) {
            if (selectionArgs != null && selectionArgs.length > 0) {
                throw new IllegalArgumentException("Valid selection required when including arguments=");
            }
            return this;
        }

        if (this.selection.length() > 0) {
            this.selection.append(" AND ");
        }

        this.selection.append("(").append(selection).append(")");
        if (selectionArgs != null) {
            Collections.addAll(this.selectionArgs, selectionArgs);
        }
        return this;
    }

    public SelectionBuilder table(String table) {
        this.table = table;
        return this;
    }

    public SelectionBuilder distinct(boolean distinct) {
        this.distinct = distinct;
        return this;
    }

    private void assertTable() {
        if (table == null) {
            throw new IllegalStateException("Table not specified");
        }
    }

    public SelectionBuilder mapToTable(String column, String table) {
        projectionMap.put(column, table + "." + column);
        return this;
    }

    public SelectionBuilder map(String fromColumn, String toClause) {
        projectionMap.put(fromColumn, toClause + " AS " + fromColumn);
        return this;
    }

    public String getSelection() {
        return selection.toString();
    }

    public String[] getSelectionArgs() {
        return selectionArgs.toArray(new String[selectionArgs.size()]);
    }

    private void mapColumns(String[] columns) {
        for (int i = 0; i < columns.length; i++) {
            final String target = projectionMap.get(columns[i]);
            if (target != null)
                columns[i] = target;
        }
    }

    private String[] getColumns() {
        String[] columns = new String[projectionMap.size()];
        int i = 0;
        for (String column : projectionMap.values()) {
            columns[i++] = column;
        }
        return columns;
    }

    @Override
    public String toString() {
        return "SelectionBuilder[table=" + table
                + ", selection=" + getSelection()
                + ", selectionArgs=" + Arrays.toString(getSelectionArgs()) + "]";
    }

    public Cursor query(SQLiteDatabase db, String[] columns, String orderBy) {
        return query(db, columns, null, null, orderBy, null);
    }

    public Cursor query(SQLiteDatabase db, String[] columns, String groupBy, String having, String orderBy, String limit) {
        assertTable();
        if (columns != null) mapColumns(columns);
        else columns = getColumns();
        LogUtils.LOGD(TAG, "query(columns=" + Arrays.toString(columns) + ") " + this);
        return db.query(distinct, table, columns, getSelection(), getSelectionArgs(), groupBy, having, orderBy, limit);
    }

    public long count(SQLiteDatabase db) {
        return DatabaseUtils.queryNumEntries(db, table, getSelection(), getSelectionArgs());
    }

    public long insert(SQLiteDatabase db, ContentValues values) {
        assertTable();
        LogUtils.LOGD(TAG, "insert() " + this);
        return db.insertOrThrow(table, null, values);
    }

    public int update(SQLiteDatabase db, ContentValues values) {
        assertTable();
        LogUtils.LOGD(TAG, "update() " + this);
        return db.update(table, values, getSelection(), getSelectionArgs());
    }

    public int delete(SQLiteDatabase db) {
        assertTable();
        LogUtils.LOGD(TAG, "delete() " + this);
        return db.delete(table, getSelection(), getSelectionArgs());
    }
}
