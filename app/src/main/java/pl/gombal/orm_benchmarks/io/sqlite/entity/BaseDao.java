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
public abstract class BaseDao<T extends BaseEntity> implements BaseColumns {

    protected boolean innerTab = false;
    protected String tableName;
    private SelectionBuilder selectionBuilder;

    public abstract String getCreateTableStatement(boolean ifNotExists);
    public abstract String[] getCreateIndexStatements(boolean ifNotExists);
    public abstract String getDropTableStatement(boolean ifExists);
    public abstract String[] getColumns();
    protected abstract long saveAction(SQLiteDatabase db, T entity);
    protected abstract int updateAction(SQLiteDatabase db, T entity, String selection, String[] selectionArgs);

    public BaseDao(String tableName) {
        this(tableName, false);
    }

    public BaseDao(String tableName, boolean innerTab) {

        this.innerTab = innerTab;
        this.tableName = tableName;
        this.selectionBuilder = new SelectionBuilder();
    }

    public boolean isInnerTab() {
        return innerTab;
    }

    public void setInnerTab(boolean innerTab) {
        this.innerTab = innerTab;
    }

    public String getTableName() {
        return tableName;
    }


    public Cursor sellectAll(DataBaseOpenHelper dataBaseOpenHelper) {
        SQLiteDatabase database = dataBaseOpenHelper.getReadableDatabase();
        return selectionBuilder.table(tableName).query(database, null, null);
    }

    public Cursor sellectById(DataBaseOpenHelper dataBaseOpenHelper, long id) {
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

        if (withTransaction) {
            try {
                beginTransaction(database, innerTab);
                for (T entity : objects) {
                    result = saveAction(database, entity);
                }
                setTransactionSuccessful(database, innerTab);
            } catch (Exception e) {
                LogUtils.LOGD("Entity: " + tableName, "catch exception while inserting");
            } finally {
                endTransaction(database, innerTab);
            }
        } else {
            for (T entity : objects) {
                result = saveAction(database, entity);
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


        if (withTransaction) {
            try {
                beginTransaction(database, innerTab);
                result = updateAction(database, object, selection, selectionArgs);
                setTransactionSuccessful(database, innerTab);
            } catch (Exception e) {
                LogUtils.LOGD("Entity: " + tableName, "catch exception while updating");
            } finally {
                endTransaction(database, innerTab);
            }
        } else {
            result = updateAction(database, object, selection, selectionArgs);
        }

        database.close();

        return result;
    }

    public int delete(DataBaseOpenHelper dataBaseOpenHelper, BaseSampleEntity object, boolean withTransaction) {
        return deleteByWhere(dataBaseOpenHelper, BaseColumns._ID + " = ?",
                new String[]{String.valueOf(object.getId())}, withTransaction);
    }

    public synchronized int deleteByWhere(DataBaseOpenHelper dataBaseOpenHelper,
                                          String selection, String[] selectionArgs, boolean withTransaction) {
        int result = -1;
        if (tableName == null)
            return result;

        SQLiteDatabase database = dataBaseOpenHelper.getWritableDatabase();
        selectionBuilder.reset().table(tableName).where(selection, selectionArgs);

        if (withTransaction) {
            try {
                beginTransaction(database, false);
                selectionBuilder.delete(database);
                setTransactionSuccessful(database, false);
            } catch (Exception e) {
                LogUtils.LOGD("Entity: " + tableName, "catch exception while deleting");
            } finally {
                endTransaction(database, false);
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
