package pl.gombal.orm_benchmarks.io.sqlite.entity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

import pl.gombal.orm_benchmarks.io.sqlite.DataBaseOpenHelper;
import pl.gombal.orm_benchmarks.io.sqlite.SelectionBuilder;
import pl.gombal.orm_benchmarks.util.LogUtils;

/**
 * Created by gombal on 21.06.2015.
 */
public class BaseDao<T extends BaseModel> {

    private SelectionBuilder selectionBuilder;

    public BaseDao() {
        selectionBuilder = new SelectionBuilder();
    }

    public Cursor sellectAll(DataBaseOpenHelper dataBaseOpenHelper, String tableName) {
        SQLiteDatabase database = dataBaseOpenHelper.getReadableDatabase();
        return selectionBuilder.table(tableName).query(database, null, null);
    }

    public Cursor sellectById(DataBaseOpenHelper dataBaseOpenHelper, String tableName, long id) {
        SQLiteDatabase database = dataBaseOpenHelper.getReadableDatabase();
        return selectionBuilder
                .table(tableName)
                .where(BaseColumns._ID + " = ?", new String[]{String.valueOf(id)})
                .query(database, null, null);
    }

    public long insert(DataBaseOpenHelper dataBaseOpenHelper, T object, boolean withTransaction) {
        if (object == null)
            return -1;

        ArrayList<T> valuesList = new ArrayList<>();
        valuesList.add(object);
        return insert(dataBaseOpenHelper, valuesList, withTransaction);
    }

    public synchronized long insert(DataBaseOpenHelper dataBaseOpenHelper, List<T> objects, boolean withTransaction) {
        long result = -1;
        if (objects.isEmpty())
            return result;

        SQLiteDatabase database = dataBaseOpenHelper.getWritableDatabase();

        String tableName = objects.get(0).getTableName();
        boolean isInnerTab = objects.get(0).isInnerTab();

        if (withTransaction) {
            try {
                beginTransaction(database, isInnerTab);
                for (T entity : objects) {
                    result = entity.saveAction(database);
                }
                endTransaction(database, isInnerTab);
            } catch (Exception e) {
                LogUtils.LOGD("Entity: " + tableName, "catch exception while inserting");
            } finally {
                setTransactionSuccessful(database, isInnerTab);
            }
        } else {
            for (T entity : objects) {
                result = entity.saveAction(database);
            }
        }

        database.close();

        return result;
    }

    public synchronized int update(DataBaseOpenHelper dataBaseOpenHelper, T object, String selection, String[] selectionArgs, boolean withTransaction) {
        int result = -1;
        if (object == null)
            return result;

        SQLiteDatabase database = dataBaseOpenHelper.getWritableDatabase();

        String tableName = object.getTableName();
        boolean isInnerTab = object.isInnerTab();

        if (withTransaction) {
            try {
                beginTransaction(database, isInnerTab);
                object.updateAction(database, selection, selectionArgs);
                endTransaction(database, isInnerTab);
            } catch (Exception e) {
                LogUtils.LOGD("Entity: " + tableName, "catch exception while updating");
            } finally {
                setTransactionSuccessful(database, isInnerTab);
            }
        } else {
            object.updateAction(database, selection, selectionArgs);
        }

        database.close();

        return result;
    }

    public int delete(DataBaseOpenHelper dataBaseOpenHelper, String table, BaseEntity object, boolean withTransaction) {
        return deleteByWhere(dataBaseOpenHelper, table, BaseColumns._ID + " = ?",
                new String[]{String.valueOf(object.getId())}, withTransaction);
    }

    public synchronized int deleteByWhere(DataBaseOpenHelper dataBaseOpenHelper, String table,
                                          String selection, String[] selectionArgs, boolean withTransaction) {
        int result = -1;
        if (table == null)
            return result;

        SQLiteDatabase database = dataBaseOpenHelper.getWritableDatabase();
        selectionBuilder.reset().table(table).where(selection, selectionArgs);

        if (withTransaction) {
            try {
                beginTransaction(database, false);
                selectionBuilder.delete(database);
                endTransaction(database, false);
            } catch (Exception e) {
                LogUtils.LOGD("Entity: " + table, "catch exception while deleting");
            } finally {
                setTransactionSuccessful(database, false);
            }
        } else {
            selectionBuilder.delete(database);
        }

        database.close();

        return result;
    }

    private void beginTransaction(SQLiteDatabase database, boolean innerTab) {
        if (!innerTab)
            database.beginTransaction();
    }

    private void endTransaction(SQLiteDatabase database, boolean innerTab) {
        if (!innerTab)
            database.endTransaction();
    }

    private void setTransactionSuccessful(SQLiteDatabase database, boolean innerTab) {
        if (!innerTab)
            database.setTransactionSuccessful();
    }

}
