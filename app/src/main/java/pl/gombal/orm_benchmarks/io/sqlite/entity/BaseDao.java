package pl.gombal.orm_benchmarks.io.sqlite.entity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

import pl.gombal.orm_benchmarks.io.sqlite.SelectionBuilder;
import pl.gombal.orm_benchmarks.util.LogUtils;


public abstract class BaseDao<T extends BaseEntity> implements BaseColumns {

    protected boolean innerTab = false;
    protected String tableName;
    private SelectionBuilder selectionBuilder;

    public abstract String getCreateTableStatement(boolean ifNotExists);

    public abstract String[] getCreateIndexStatements(boolean ifNotExists);

    public abstract String getDropTableStatement(boolean ifExists);

    public abstract String[] getColumns();

    protected abstract long saveAction(SQLiteDatabase database, T entity);

    protected abstract int updateAction(SQLiteDatabase database, T entity, String selection, String[] selectionArgs);

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


    public Cursor selectAll(SQLiteDatabase database) {
        return selectionBuilder.reset().table(tableName).query(database, null, null);
    }

    public Cursor selectById(SQLiteDatabase database, long id) {
        return selectionBuilder
                .reset()
                .table(tableName)
                .where(BaseColumns._ID + " = ?", new String[]{String.valueOf(id)})
                .query(database, null, null);
    }

    public Cursor selectByWhere(SQLiteDatabase database, String selection, String... selectionArgs) {
        return selectionBuilder
                .reset()
                .table(tableName)
                .where(selection, selectionArgs)
                .query(database, null, null);
    }

    public synchronized long insert(SQLiteDatabase database, T object, boolean withTransaction) {
        if (object == null)
            return -1;

        ArrayList<T> valuesList = new ArrayList<>();
        valuesList.add(object);
        return insert(database, valuesList, withTransaction);
    }

    public synchronized long insert(SQLiteDatabase database, List<T> objects, boolean withTransaction) {
        long result = -1;
        if (objects.isEmpty())
            return result;

        if (withTransaction) {
            try {
                beginTransaction(database, innerTab);
                for (T entity : objects) {
                    result = saveAction(database, entity);
                }
                setTransactionSuccessful(database, innerTab);
            } catch (Exception e) {
                LogUtils.LOGD("Entity: " + tableName, "catch exception while inserting. Rollback changes.");
            } finally {
                endTransaction(database, innerTab);
            }
        } else {
            for (T entity : objects) {
                result = saveAction(database, entity);
            }
        }

        return result;
    }

    public synchronized int update(SQLiteDatabase database, T object, String selection, String[] selectionArgs, boolean withTransaction) {
        if (object == null)
            return -1;

        ArrayList<T> valuesList = new ArrayList<>();
        valuesList.add(object);
        return update(database, valuesList, selection, selectionArgs, withTransaction);
    }

    public synchronized int update(SQLiteDatabase database, List<T> objects, String selection, String[] selectionArgs, boolean withTransaction) {
        int result = -1;
        if (objects.isEmpty())
            return result;

        if (withTransaction) {
            try {
                beginTransaction(database, innerTab);
                for (T entity : objects) {
                    if (selection == null || selectionArgs == null) {
                        selection = BaseColumns._ID + " = ?";
                        selectionArgs = new String[]{String.valueOf(entity.getId())};
                    }
                    result = updateAction(database, entity, selection, selectionArgs);
                }
                setTransactionSuccessful(database, innerTab);
            } catch (Exception e) {
                LogUtils.LOGD("Entity: " + tableName, "catch exception while updating. Rollback changes.");
            } finally {
                endTransaction(database, innerTab);
            }
        } else {
            for (T entity : objects) {
                if (selection == null || selectionArgs == null) {
                    selection = BaseColumns._ID + " = ?";
                    selectionArgs = new String[]{String.valueOf(entity.getId())};
                }
                result = updateAction(database, entity, selection, selectionArgs);
            }
        }

        return result;
    }

    public int delete(SQLiteDatabase database, BaseSampleEntity object, boolean withTransaction) {
        return deleteByWhere(database, BaseColumns._ID + " = ?",
                new String[]{String.valueOf(object.getId())}, withTransaction);
    }

    public synchronized int deleteByWhere(SQLiteDatabase database,
                                          String selection, String[] selectionArgs, boolean withTransaction) {
        int result = -1;
        if (tableName == null)
            return result;

        selectionBuilder.reset().table(tableName).where(selection, selectionArgs);

        if (withTransaction) {
            try {
                beginTransaction(database, false);
                selectionBuilder.delete(database);
                setTransactionSuccessful(database, false);
            } catch (Exception e) {
                LogUtils.LOGD("Entity: " + tableName, "catch exception while deleting. . Rollback changes.");
            } finally {
                endTransaction(database, false);
            }
        } else {
            selectionBuilder.delete(database);
        }

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
