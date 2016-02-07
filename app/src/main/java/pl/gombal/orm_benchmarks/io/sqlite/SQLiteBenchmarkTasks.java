package pl.gombal.orm_benchmarks.io.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.StrictMode;
import android.provider.BaseColumns;

import com.google.common.base.Stopwatch;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import pl.gombal.orm_benchmarks.io.sqlite.entity.BaseSampleDao;
import pl.gombal.orm_benchmarks.io.sqlite.entity.BigSingleTable;
import pl.gombal.orm_benchmarks.io.sqlite.entity.BigSingleTableDao;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_01;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_01Dao;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_02;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_02Dao;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_03;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_03Dao;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_04;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_04Dao;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_05;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_05Dao;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_06;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_06Dao;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_07;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_07Dao;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_08;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_08Dao;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_09;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_09Dao;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_10;
import pl.gombal.orm_benchmarks.io.sqlite.entity.MultiTable_10Dao;
import pl.gombal.orm_benchmarks.io.sqlite.entity.SingleTable;
import pl.gombal.orm_benchmarks.io.sqlite.entity.SingleTableDao;
import pl.gombal.orm_benchmarks.io.sqlite.entity.TableWithRelationToMany;
import pl.gombal.orm_benchmarks.io.sqlite.entity.TableWithRelationToManyDao;
import pl.gombal.orm_benchmarks.io.sqlite.entity.TableWithRelationToOne;
import pl.gombal.orm_benchmarks.io.sqlite.entity.TableWithRelationToOneDao;
import pl.gombal.orm_benchmarks.io.util.DataBaseUtils;
import pl.gombal.orm_benchmarks.io.util.EntityFieldGeneratorUtils;
import pl.gombal.orm_benchmarks.task.ORMBenchmarkTasks;
import pl.gombal.orm_benchmarks.util.LogUtils;

public class SQLiteBenchmarkTasks implements ORMBenchmarkTasks {

    public static final String TAG = SQLiteBenchmarkTasks.class.getSimpleName();
    public static final String DB_NAME = "sqlite-db";

    private boolean initialized = false;
    private boolean devMode = false;

    private SQLiteOpenHelper dbOpenHelper;

    @Override
    public String getName() {
        return "SQLite RAW";
    }

    public void init(Context context) {
        init(context, false, false);
    }

    @Override
    public void init(Context context, boolean copyDBFormAssets, boolean inMemoryDB) {
        if (copyDBFormAssets)
            DataBaseUtils.loadDataBaseFileFomAssets(context, DB_NAME);

        dbOpenHelper = new DataBaseOpenHelper(context, inMemoryDB);
        initialized = true;
        if (devMode) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .penaltyLog()
                    .penaltyDeath()
                    .build());
        }
    }

    @Override
    public boolean isInitialized() {
        return initialized;
    }

    @Override
    public long createDB() throws SQLException {
        if (!initialized)
            throw new IllegalStateException("Initialize first SQLiteBenchmarkTasks by call init()!");

        Stopwatch stopwatch = Stopwatch.createStarted();

        SQLiteBenchmarkTasksHelper.createDatabase(dbOpenHelper.getReadableDatabase(), false);

        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    @Override
    public long dropDB() throws SQLException {
        if (!initialized)
            throw new IllegalStateException("Initialize first SQLiteBenchmarkTasks by call init()!");

        Stopwatch stopwatch = Stopwatch.createStarted();

        SQLiteBenchmarkTasksHelper.dropDatabase(dbOpenHelper.getReadableDatabase(), false);

        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    @Override
    public long insert(EntityType entityType, int num, boolean withTransaction) throws SQLException {
        if (!initialized)
            throw new IllegalStateException("Initialize first SQLiteBenchmarkTasks by call init()!");

        Stopwatch stopwatch = Stopwatch.createUnstarted();

        EntityFieldGeneratorUtils.clearAllInstances();
        EntityFieldGeneratorUtils generatorUtils =
                EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.RAW_SQL_ENTITY_FIELD_GENERATOR_ID, num);

        switch (entityType) {
            case SINGLE_TAB:
                List<SingleTable> singleTableList = new ArrayList<>();
                for (int i = 0; i < num; i++)
                    singleTableList.add(SingleTable.getNewEntityWithRandomData(generatorUtils));
                stopwatch.start();
                new SingleTableDao().insert(dbOpenHelper, singleTableList, withTransaction);
                break;

            case BIG_SINGLE_TAB:
                List<BigSingleTable> bigSingleTableList = new ArrayList<>();
                for (int i = 0; i < num; i++)
                    bigSingleTableList.add(BigSingleTable.getNewEntityWithRandomData(generatorUtils));
                stopwatch.start();
                new BigSingleTableDao().insert(dbOpenHelper, bigSingleTableList, withTransaction);
                break;

            case MULTI_TAB_RELATION_TO_ONE:
                List<MultiTable_01> multiTableList = new ArrayList<>();
                for (int i = 0; i < num; i++)
                    multiTableList.add(MultiTable_01.getNewEntityWithRandomData(generatorUtils));
                stopwatch.start();
                new MultiTable_01Dao().insert(dbOpenHelper, multiTableList, withTransaction);
                break;

            case SINGLE_TAB_RELATION_TO_MANY:
                List<TableWithRelationToMany> toManyList = new ArrayList<>();
                for (int i = 0; i < num; i++)
                    toManyList.add(TableWithRelationToMany.getNewEntityWithRandomData(generatorUtils, 10));
                stopwatch.start();
                new TableWithRelationToManyDao().insert(dbOpenHelper, toManyList, withTransaction);
                break;
        }

        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    @Override
    public long update(EntityType entityType, int num, boolean withTransaction) throws SQLException {
        if (!initialized)
            throw new IllegalStateException("Initialize first SQLiteBenchmarkTasks by call init()!");

        Stopwatch stopwatch = Stopwatch.createUnstarted();

        switch (entityType) {
            case SINGLE_TAB:
                List<SingleTable> singleTableList = SQLiteBenchmarkTasksHelper.getSingleTableList(dbOpenHelper, num);

                stopwatch.start();
                new SingleTableDao().update(dbOpenHelper, singleTableList, null, null, withTransaction);
                break;

            case BIG_SINGLE_TAB:
                List<BigSingleTable> bigSingleTableList = SQLiteBenchmarkTasksHelper.getBigSingleTableList(dbOpenHelper, num);

                stopwatch.start();
                new BigSingleTableDao().update(dbOpenHelper, bigSingleTableList, null, null, withTransaction);
                break;

            case MULTI_TAB_RELATION_TO_ONE:
                List<MultiTable_01> multiTableList = SQLiteBenchmarkTasksHelper.getMultiTableList(dbOpenHelper, num);

                stopwatch.start();
                new MultiTable_01Dao().update(dbOpenHelper, multiTableList, null, null, withTransaction);
                break;

            case SINGLE_TAB_RELATION_TO_MANY:
                List<TableWithRelationToMany> toManyList = SQLiteBenchmarkTasksHelper.getTableToManyList(dbOpenHelper, num);

                stopwatch.start();
                new TableWithRelationToManyDao().update(dbOpenHelper, toManyList, null, null, withTransaction);
                break;
        }

        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    @Override
    public long selectAll(EntityType entityType, SelectionType selectionType) throws SQLException {
        if (!initialized)
            throw new IllegalStateException("Initialize first SQLiteBenchmarkTasks by call init()!");

        Stopwatch stopwatch = Stopwatch.createStarted();
        Cursor cursor = null;
        try {
            switch (entityType) {
                case SINGLE_TAB:
                    switch (selectionType) {
                        case WITH_LAZY_INIT:
                            cursor = new SingleTableDao().selectAll(dbOpenHelper);
                            break;
                        case WITHOUT_LAZY_INIT:
                            cursor = new SingleTableDao().selectAll(dbOpenHelper);
                            cursor.moveToFirst();
                            if (cursor.getCount() > 0)
                                do {
                                    new SingleTable().fromCursor(cursor);
                                } while (cursor.moveToNext());
                            break;
                        case COUNT_ONLY:
                            new SelectionBuilder().table(new SingleTableDao().getTableName()).count(dbOpenHelper.getReadableDatabase());
                            break;
                    }
                    break;

                case BIG_SINGLE_TAB:
                    switch (selectionType) {
                        case WITH_LAZY_INIT:
                            cursor = new BigSingleTableDao().selectAll(dbOpenHelper);
                            break;
                        case WITHOUT_LAZY_INIT:
                            cursor = new BigSingleTableDao().selectAll(dbOpenHelper);
                            cursor.moveToFirst();
                            if (cursor.getCount() > 0)
                                do {
                                    new BigSingleTable().fromCursor(cursor);
                                } while (cursor.moveToNext());
                            break;
                        case COUNT_ONLY:
                            new SelectionBuilder().table(new BigSingleTableDao().getTableName()).count(dbOpenHelper.getReadableDatabase());
                            break;
                    }
                    break;

                case MULTI_TAB_RELATION_TO_ONE:
                    switch (selectionType) {
                        case WITH_LAZY_INIT:
                        case WITHOUT_LAZY_INIT:
                            Cursor c1 = null, c2 = null, c3 = null, c4 = null, c5 = null, c6 = null, c7 = null, c8 = null, c9 = null, c10 = null;
                            try {
                                c1 = new MultiTable_01Dao().selectAll(dbOpenHelper);
                                int columnIdIndex = c1.getColumnIndexOrThrow(BaseColumns._ID);
                                c1.moveToFirst();
                                if (c1.getCount() > 0)
                                    do {
                                        if (selectionType == SelectionType.WITHOUT_LAZY_INIT) new MultiTable_01().fromCursor(c1);

                                        c2 = new MultiTable_02Dao().selectById(dbOpenHelper, c1.getInt(columnIdIndex));
                                        c2.moveToFirst();
                                        if (selectionType == SelectionType.WITHOUT_LAZY_INIT) new MultiTable_02().fromCursor(c2);

                                        c3 = new MultiTable_03Dao().selectById(dbOpenHelper, c2.getInt(columnIdIndex));
                                        c2.close();
                                        c2 = null;
                                        c3.moveToFirst();
                                        if (selectionType == SelectionType.WITHOUT_LAZY_INIT) new MultiTable_03().fromCursor(c3);

                                        c4 = new MultiTable_04Dao().selectById(dbOpenHelper, c3.getInt(columnIdIndex));
                                        c3.close();
                                        c3 = null;
                                        c4.moveToFirst();
                                        if (selectionType == SelectionType.WITHOUT_LAZY_INIT) new MultiTable_04().fromCursor(c4);

                                        c5 = new MultiTable_05Dao().selectById(dbOpenHelper, c4.getInt(columnIdIndex));
                                        c4.close();
                                        c4 = null;
                                        c5.moveToFirst();
                                        if (selectionType == SelectionType.WITHOUT_LAZY_INIT) new MultiTable_05().fromCursor(c5);

                                        c6 = new MultiTable_06Dao().selectById(dbOpenHelper, c5.getInt(columnIdIndex));
                                        c5.close();
                                        c5 = null;
                                        c6.moveToFirst();
                                        if (selectionType == SelectionType.WITHOUT_LAZY_INIT) new MultiTable_06().fromCursor(c6);

                                        c7 = new MultiTable_07Dao().selectById(dbOpenHelper, c6.getInt(columnIdIndex));
                                        c6.close();
                                        c6 = null;
                                        c7.moveToFirst();
                                        if (selectionType == SelectionType.WITHOUT_LAZY_INIT) new MultiTable_07().fromCursor(c7);

                                        c8 = new MultiTable_08Dao().selectById(dbOpenHelper, c7.getInt(columnIdIndex));
                                        c7.close();
                                        c7 = null;
                                        c8.moveToFirst();
                                        if (selectionType == SelectionType.WITHOUT_LAZY_INIT) new MultiTable_08().fromCursor(c8);

                                        c9 = new MultiTable_09Dao().selectById(dbOpenHelper, c8.getInt(columnIdIndex));
                                        c8.close();
                                        c8 = null;
                                        c9.moveToFirst();
                                        if (selectionType == SelectionType.WITHOUT_LAZY_INIT) new MultiTable_09().fromCursor(c9);

                                        c10 = new MultiTable_10Dao().selectById(dbOpenHelper, c9.getInt(columnIdIndex));
                                        c9.close();
                                        c9 = null;
                                            c10.moveToFirst();
                                        if (selectionType == SelectionType.WITHOUT_LAZY_INIT) new MultiTable_10().fromCursor(c10);
                                        c10.close();
                                        c10 = null;
                                    } while (c1.moveToNext());
                            } finally {
                                if (c1 != null) {
                                    LogUtils.LOGD(TAG, "Found " + c1.getCount() + "rows.");
                                    c1.close();
                                }
                                if (c2 != null) c2.close();
                                if (c3 != null) c3.close();
                                if (c4 != null) c4.close();
                                if (c5 != null) c5.close();
                                if (c6 != null) c6.close();
                                if (c7 != null) c7.close();
                                if (c8 != null) c8.close();
                                if (c9 != null) c9.close();
                                if (c10 != null) c10.close();
                            }
                            break;
                        case COUNT_ONLY:
                            new SelectionBuilder().table(new MultiTable_01Dao().getTableName()).count(dbOpenHelper.getReadableDatabase());
                            break;
                    }
                    break;

                case SINGLE_TAB_RELATION_TO_MANY:
                    switch (selectionType) {
                        case WITH_LAZY_INIT:
                        case WITHOUT_LAZY_INIT:
                            cursor = new TableWithRelationToManyDao().selectAll(dbOpenHelper);
                            Cursor toOneCursor = null;
                            try {
                                String selection = TableWithRelationToOneDao.TABLE_WITH_RELATION_TO_MANY_ID + " = ?";
                                String selectionArgs;
                                cursor.moveToFirst();
                                if (cursor.getCount() > 0)
                                    do {
                                        selectionArgs = String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(BaseColumns._ID)));
                                        toOneCursor = new TableWithRelationToOneDao().selectByWhere(dbOpenHelper, selection, selectionArgs);
                                        if (selectionType == SelectionType.WITHOUT_LAZY_INIT) {
                                            new TableWithRelationToMany().fromCursor(cursor);
                                            toOneCursor.moveToFirst();
                                            do new TableWithRelationToOne().fromCursor(toOneCursor);
                                            while (toOneCursor.moveToNext());
                                            toOneCursor.close();
                                        }
                                    } while (cursor.moveToNext());
                            } finally {
                                if (toOneCursor != null) toOneCursor.close();
                            }
                            break;
                        case COUNT_ONLY:

                            break;
                    }

                    break;
            }
        } finally {
            if (cursor != null) {
                LogUtils.LOGD(TAG, "Found " + cursor.getCount() + "rows.");
                cursor.close();
            }
        }

        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    @Override
    public long searchIndexed(EntityType entityType, int value) throws SQLException {
        if (!initialized)
            throw new IllegalStateException("Initialize first SQLiteBenchmarkTasks by call init()!");

        Stopwatch stopwatch = Stopwatch.createStarted();
        Cursor cursor = null;
        try {

            String selection = BaseSampleDao.SAMPLE_INT_COLL_INDEXED + " LIKE ?";
            String[] selectionArgs = new String[]{String.valueOf(value)};

            switch (entityType) {
                case SINGLE_TAB:
                    cursor = new SingleTableDao().selectByWhere(dbOpenHelper, selection, selectionArgs);
                    break;

                case BIG_SINGLE_TAB:
                    cursor = new BigSingleTableDao().selectByWhere(dbOpenHelper, selection, selectionArgs);
                    break;

                case MULTI_TAB_RELATION_TO_ONE:
                    cursor = null;
                    Cursor c1 = null, c2 = null, c3 = null, c4 = null, c5 = null, c6 = null, c7 = null, c8 = null, c9 = null, c10 = null;
                    try {
                        c1 = new MultiTable_01Dao().selectByWhere(dbOpenHelper, selection, selectionArgs);
                        int columnIdIndex = c1.getColumnIndexOrThrow(BaseColumns._ID);
                        c1.moveToFirst();
                        if (c1.getCount() > 0)
                            do {
                                c2 = new MultiTable_02Dao().selectById(dbOpenHelper, c1.getInt(columnIdIndex));
                                c2.moveToFirst();
                                c3 = new MultiTable_03Dao().selectById(dbOpenHelper, c2.getInt(columnIdIndex));
                                c2.close();
                                c3.moveToFirst();
                                c4 = new MultiTable_04Dao().selectById(dbOpenHelper, c3.getInt(columnIdIndex));
                                c3.close();
                                c4.moveToFirst();
                                c5 = new MultiTable_05Dao().selectById(dbOpenHelper, c4.getInt(columnIdIndex));
                                c4.close();
                                c5.moveToFirst();
                                c6 = new MultiTable_06Dao().selectById(dbOpenHelper, c5.getInt(columnIdIndex));
                                c5.close();
                                c6.moveToFirst();
                                c7 = new MultiTable_07Dao().selectById(dbOpenHelper, c6.getInt(columnIdIndex));
                                c6.close();
                                c7.moveToFirst();
                                c8 = new MultiTable_08Dao().selectById(dbOpenHelper, c7.getInt(columnIdIndex));
                                c7.close();
                                c8.moveToFirst();
                                c9 = new MultiTable_09Dao().selectById(dbOpenHelper, c8.getInt(columnIdIndex));
                                c8.close();
                                c9.moveToFirst();
                                c10 = new MultiTable_10Dao().selectById(dbOpenHelper, c9.getInt(columnIdIndex));
                                c10.close();
                            } while (c1.moveToNext());
                    } finally {
                        if (c1 != null) {
                            LogUtils.LOGD(TAG, "Found " + c1.getCount() + "rows.");
                            c1.close();
                        }
                        if (c2 != null) c2.close();
                        if (c3 != null) c3.close();
                        if (c4 != null) c4.close();
                        if (c5 != null) c5.close();
                        if (c6 != null) c6.close();
                        if (c7 != null) c7.close();
                        if (c8 != null) c8.close();
                        if (c9 != null) c9.close();
                        if (c10 != null) c10.close();
                    }
                    break;

                case SINGLE_TAB_RELATION_TO_MANY:
                    cursor = new TableWithRelationToManyDao().selectByWhere(dbOpenHelper, selection, selectionArgs);
                    Cursor toOneCursor = null;
                    try {
                        String toOneSelection = TableWithRelationToOneDao.TABLE_WITH_RELATION_TO_MANY_ID + " = ?";
                        String toOneSelectionArgs;
                        int columnIdIndex = cursor.getColumnIndexOrThrow(BaseColumns._ID);
                        cursor.moveToFirst();
                        if (cursor.getCount() > 0)
                            do {
                                toOneSelectionArgs = String.valueOf(cursor.getInt(columnIdIndex));
                                toOneCursor = new TableWithRelationToOneDao().selectByWhere(dbOpenHelper, toOneSelection, toOneSelectionArgs);
                                toOneCursor.close();
                            } while (cursor.moveToNext());
                    } finally {
                        if (toOneCursor != null) toOneCursor.close();
                    }
                    break;
            }
        } finally {
            if (cursor != null) {
                LogUtils.LOGD(TAG, "Found " + cursor.getCount() + "rows.");
                cursor.close();
            }
        }

        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    @Override
    public long search(EntityType entityType, String value) throws SQLException {
        if (!initialized)
            throw new IllegalStateException("Initialize first SQLiteBenchmarkTasks by call init()!");

        Stopwatch stopwatch = Stopwatch.createStarted();
        Cursor cursor = null;
        try {
            String selection = BaseSampleDao.SAMPLE_STRING_COLL_01 + " LIKE ?";
            String[] selectionArgs = new String[]{"%" + value + "%"};

            switch (entityType) {
                case SINGLE_TAB:
                    cursor = new SingleTableDao().selectByWhere(dbOpenHelper, selection, selectionArgs); // todo zamykać wszędzie kursor w encjach
                    break;

                case BIG_SINGLE_TAB:
                    cursor = new BigSingleTableDao().selectByWhere(dbOpenHelper, selection, selectionArgs);
                    break;

                case MULTI_TAB_RELATION_TO_ONE:
                    cursor = null;
                    Cursor c1 = null, c2 = null, c3 = null, c4 = null, c5 = null, c6 = null, c7 = null, c8 = null, c9 = null, c10 = null;
                    try {
                        c1 = new MultiTable_01Dao().selectByWhere(dbOpenHelper, selection, selectionArgs);
                        c1.moveToFirst();
                        if (c1.getCount() > 0) {
                            int columnIdIndex = c1.getColumnIndexOrThrow(BaseColumns._ID);
                            do {
                                c2 = new MultiTable_02Dao().selectById(dbOpenHelper, c1.getInt(columnIdIndex));
                                c2.moveToFirst();
                                c3 = new MultiTable_03Dao().selectById(dbOpenHelper, c2.getInt(columnIdIndex));
                                c2.close();
                                c3.moveToFirst();
                                c4 = new MultiTable_04Dao().selectById(dbOpenHelper, c3.getInt(columnIdIndex));
                                c3.close();
                                c4.moveToFirst();
                                c5 = new MultiTable_05Dao().selectById(dbOpenHelper, c4.getInt(columnIdIndex));
                                c4.close();
                                c5.moveToFirst();
                                c6 = new MultiTable_06Dao().selectById(dbOpenHelper, c5.getInt(columnIdIndex));
                                c5.close();
                                c6.moveToFirst();
                                c7 = new MultiTable_07Dao().selectById(dbOpenHelper, c6.getInt(columnIdIndex));
                                c6.close();
                                c7.moveToFirst();
                                c8 = new MultiTable_08Dao().selectById(dbOpenHelper, c7.getInt(columnIdIndex));
                                c7.close();
                                c8.moveToFirst();
                                c9 = new MultiTable_09Dao().selectById(dbOpenHelper, c8.getInt(columnIdIndex));
                                c8.close();
                                c9.moveToFirst();
                                c10 = new MultiTable_10Dao().selectById(dbOpenHelper, c9.getInt(columnIdIndex));
                                c10.close();
                            } while (c1.moveToNext());
                        }
                    } finally {
                        if (c1 != null) {
                            LogUtils.LOGD(TAG, "Found " + c1.getCount() + "rows.");
                            c1.close();
                        }
                        if (c2 != null) c2.close();
                        if (c3 != null) c3.close();
                        if (c4 != null) c4.close();
                        if (c5 != null) c5.close();
                        if (c6 != null) c6.close();
                        if (c7 != null) c7.close();
                        if (c8 != null) c8.close();
                        if (c9 != null) c9.close();
                        if (c10 != null) c10.close();
                    }
                    break;

                case SINGLE_TAB_RELATION_TO_MANY:
                    cursor = new TableWithRelationToManyDao().selectByWhere(dbOpenHelper, selection, selectionArgs);
                    Cursor toOneCursor = null;
                    try {
                        String toOneSelection = TableWithRelationToOneDao.TABLE_WITH_RELATION_TO_MANY_ID + " = ?";
                        String toOneSelectionArgs;
                        int columnIdIndex = cursor.getColumnIndexOrThrow(BaseColumns._ID);
                        cursor.moveToFirst();
                        if (cursor.getCount() > 0)
                            do {
                                toOneSelectionArgs = String.valueOf(cursor.getInt(columnIdIndex));
                                toOneCursor = new TableWithRelationToOneDao().selectByWhere(dbOpenHelper, toOneSelection, toOneSelectionArgs);
                                toOneCursor.close();
                            } while (cursor.moveToNext());
                    } finally {
                        if (toOneCursor != null) toOneCursor.close();
                    }
                    break;
            }
        } finally {
            if (cursor != null) {
                LogUtils.LOGD(TAG, "Found " + cursor.getCount() + "rows.");
                cursor.close();
            }
        }

        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }
}
