package pl.gombal.orm_benchmarks.io.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
    private final TableWithRelationToManyDao tableTomanyDao = new TableWithRelationToManyDao();
    private final MultiTable_02Dao table02Dao = new MultiTable_02Dao();
    private final MultiTable_03Dao table03Dao = new MultiTable_03Dao();
    private final MultiTable_04Dao table04Dao = new MultiTable_04Dao();
    private final MultiTable_05Dao table05Dao = new MultiTable_05Dao();
    private final MultiTable_06Dao table06Dao = new MultiTable_06Dao();
    private final MultiTable_07Dao table07Dao = new MultiTable_07Dao();
    private final MultiTable_08Dao table08Dao = new MultiTable_08Dao();
    private final MultiTable_09Dao table09Dao = new MultiTable_09Dao();
    private final MultiTable_10Dao table10Dao = new MultiTable_10Dao();
    private final TableWithRelationToOneDao tableToOneDao = new TableWithRelationToOneDao();

    private Context context;

    private boolean initialized = false;
    private boolean devMode = false;

    private SQLiteDatabase db;

    private SingleTableDao singleTableDao = new SingleTableDao();
    private BigSingleTableDao bigSingleTableDao = new BigSingleTableDao();
    private MultiTable_01Dao table01Dao = new MultiTable_01Dao();

    @Override
    public String getName() {
        return "SQLite RAW";
    }

    public void init(Context context) {
        init(context, false, false);
    }

    @Override
    public void init(Context context, boolean copyDBFormAssets, boolean inMemoryDB) {
        this.context = context;

        if (copyDBFormAssets)
            DataBaseUtils.loadDataBaseFileFomAssets(context, DB_NAME);

        db = new DataBaseOpenHelper(context, inMemoryDB).getWritableDatabase();
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

        SQLiteBenchmarkTasksHelper.createDatabase(db, false);

        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    @Override
    public long dropDB() throws SQLException {
        if (!initialized)
            throw new IllegalStateException("Initialize first SQLiteBenchmarkTasks by call init()!");

        Stopwatch stopwatch = Stopwatch.createStarted();

        SQLiteBenchmarkTasksHelper.dropDatabase(context, DB_NAME);

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
                singleTableDao.insert(db, singleTableList, withTransaction);
                break;

            case BIG_SINGLE_TAB:
                List<BigSingleTable> bigSingleTableList = new ArrayList<>();
                for (int i = 0; i < num; i++)
                    bigSingleTableList.add(BigSingleTable.getNewEntityWithRandomData(generatorUtils));
                stopwatch.start();
                bigSingleTableDao.insert(db, bigSingleTableList, withTransaction);
                break;

            case MULTI_TAB_RELATION_TO_ONE:
                List<MultiTable_01> multiTableList = new ArrayList<>();
                for (int i = 0; i < num; i++)
                    multiTableList.add(MultiTable_01.getNewEntityWithRandomData(generatorUtils));
                stopwatch.start();
                table01Dao.insert(db, multiTableList, withTransaction);
                break;

            case SINGLE_TAB_RELATION_TO_MANY:
                List<TableWithRelationToMany> toManyList = new ArrayList<>();
                for (int i = 0; i < num; i++)
                    toManyList.add(TableWithRelationToMany.getNewEntityWithRandomData(generatorUtils, 10));
                stopwatch.start();
                tableTomanyDao.insert(db, toManyList, withTransaction);
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
                List<SingleTable> singleTableList = SQLiteBenchmarkTasksHelper.getSingleTableList(db, num);

                stopwatch.start();
                singleTableDao.update(db, singleTableList, null, null, withTransaction);
                break;

            case BIG_SINGLE_TAB:
                List<BigSingleTable> bigSingleTableList = SQLiteBenchmarkTasksHelper.getBigSingleTableList(db, num);

                stopwatch.start();
                bigSingleTableDao.update(db, bigSingleTableList, null, null, withTransaction);
                break;

            case MULTI_TAB_RELATION_TO_ONE:
                List<MultiTable_01> multiTableList = SQLiteBenchmarkTasksHelper.getMultiTableList(db, num);

                stopwatch.start();
                table01Dao.update(db, multiTableList, null, null, withTransaction);
                break;

            case SINGLE_TAB_RELATION_TO_MANY:
                List<TableWithRelationToMany> toManyList = SQLiteBenchmarkTasksHelper.getTableToManyList(db, num);

                stopwatch.start();
                tableTomanyDao.update(db, toManyList, null, null, withTransaction);
                break;
        }

        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    @Override
    public long selectAll(EntityType entityType, SelectionType selectionType) throws SQLException {
        if (!initialized)
            throw new IllegalStateException("Initialize first SQLiteBenchmarkTasks by call init()!");

        SelectionBuilder selectionBuilder = new SelectionBuilder();

        Stopwatch stopwatch = Stopwatch.createStarted();
        Cursor cursor = null;
        try {
            switch (entityType) {
                case SINGLE_TAB:
                    switch (selectionType) {
                        case WITH_LAZY_INIT:
                            cursor = singleTableDao.selectAll(db);
                            break;
                        case WITHOUT_LAZY_INIT:
                            cursor = singleTableDao.selectAll(db);
                            cursor.moveToFirst();
                            if (cursor.getCount() > 0) {
                                SingleTable singleTable = new SingleTable();
                                do {
                                    singleTable.fromCursor(cursor);
                                } while (cursor.moveToNext());
                            }
                            break;
                        case COUNT_ONLY:
                            selectionBuilder.table(singleTableDao.getTableName()).count(db);
                            break;
                    }
                    break;

                case BIG_SINGLE_TAB:
                    switch (selectionType) {
                        case WITH_LAZY_INIT:
                            cursor = bigSingleTableDao.selectAll(db);
                            break;
                        case WITHOUT_LAZY_INIT:
                            cursor = bigSingleTableDao.selectAll(db);
                            cursor.moveToFirst();
                            if (cursor.getCount() > 0) {
                                BigSingleTable bigSingleTable = new BigSingleTable();
                                do {
                                    bigSingleTable.fromCursor(cursor);
                                } while (cursor.moveToNext());
                            }
                            break;
                        case COUNT_ONLY:
                            selectionBuilder.table(bigSingleTableDao.getTableName()).count(db);
                            break;
                    }
                    break;

                case MULTI_TAB_RELATION_TO_ONE:
                    switch (selectionType) {
                        case WITH_LAZY_INIT:
                            cursor = table01Dao.selectAll(db);
                            break;
                        case WITHOUT_LAZY_INIT:
                            Cursor c1 = null, c2 = null, c3 = null, c4 = null, c5 = null, c6 = null, c7 = null, c8 = null, c9 = null, c10 = null;
                            try {
                                c1 = table01Dao.selectAll(db);
                                int columnIdIndex = c1.getColumnIndexOrThrow(BaseColumns._ID);
                                c1.moveToFirst();
                                if (c1.getCount() > 0) {

                                    MultiTable_01 table01 = new MultiTable_01();
                                    MultiTable_02 table02 = new MultiTable_02();
                                    MultiTable_03 table03 = new MultiTable_03();
                                    MultiTable_04 table04 = new MultiTable_04();
                                    MultiTable_05 table05 = new MultiTable_05();
                                    MultiTable_06 table06 = new MultiTable_06();
                                    MultiTable_07 table07 = new MultiTable_07();
                                    MultiTable_08 table08 = new MultiTable_08();
                                    MultiTable_09 table09 = new MultiTable_09();
                                    MultiTable_10 table10 = new MultiTable_10();

                                    do {
                                        table01.fromCursor(c1);

                                        c2 = table02Dao.selectById(db, c1.getInt(columnIdIndex));
                                        c2.moveToFirst();
                                        table02.fromCursor(c2);

                                        c3 = table03Dao.selectById(db, c2.getInt(columnIdIndex));
                                        c2.close();
                                        c2 = null;
                                        c3.moveToFirst();
                                        table03.fromCursor(c3);

                                        c4 = table04Dao.selectById(db, c3.getInt(columnIdIndex));
                                        c3.close();
                                        c3 = null;
                                        c4.moveToFirst();
                                        table04.fromCursor(c4);

                                        c5 = table05Dao.selectById(db, c4.getInt(columnIdIndex));
                                        c4.close();
                                        c4 = null;
                                        c5.moveToFirst();
                                        table05.fromCursor(c5);

                                        c6 = table06Dao.selectById(db, c5.getInt(columnIdIndex));
                                        c5.close();
                                        c5 = null;
                                        c6.moveToFirst();
                                        table06.fromCursor(c6);

                                        c7 = table07Dao.selectById(db, c6.getInt(columnIdIndex));
                                        c6.close();
                                        c6 = null;
                                        c7.moveToFirst();
                                        table07.fromCursor(c7);

                                        c8 = table08Dao.selectById(db, c7.getInt(columnIdIndex));
                                        c7.close();
                                        c7 = null;
                                        c8.moveToFirst();
                                        table08.fromCursor(c8);

                                        c9 = table09Dao.selectById(db, c8.getInt(columnIdIndex));
                                        c8.close();
                                        c8 = null;
                                        c9.moveToFirst();
                                        table09.fromCursor(c9);

                                        c10 = table10Dao.selectById(db, c9.getInt(columnIdIndex));
                                        c9.close();
                                        c9 = null;
                                        c10.moveToFirst();
                                        table10.fromCursor(c10);
                                        c10.close();
                                        c10 = null;
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
                        case COUNT_ONLY:
                            selectionBuilder.table(table01Dao.getTableName()).count(db);
                            break;
                    }
                    break;

                case SINGLE_TAB_RELATION_TO_MANY:
                    switch (selectionType) {
                        case WITH_LAZY_INIT:
                            cursor = tableTomanyDao.selectAll(db);
                            break;
                        case WITHOUT_LAZY_INIT:
                            cursor = tableTomanyDao.selectAll(db);
                            Cursor toOneCursor = null;
                            try {
                                String selection = TableWithRelationToOneDao.TABLE_WITH_RELATION_TO_MANY_ID + " = ?";
                                String selectionArgs;
                                cursor.moveToFirst();
                                if (cursor.getCount() > 0)
                                    do {
                                        selectionArgs = String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(BaseColumns._ID)));
                                        toOneCursor = tableToOneDao.selectByWhere(db, selection, selectionArgs);
                                        new TableWithRelationToMany().fromCursor(cursor);
                                        toOneCursor.moveToFirst();
                                        TableWithRelationToOne tableToOne = new TableWithRelationToOne();
                                        do tableToOne.fromCursor(toOneCursor);
                                        while (toOneCursor.moveToNext());
                                        toOneCursor.close();
                                    } while (cursor.moveToNext());
                            } finally {
                                if (toOneCursor != null) toOneCursor.close();
                            }
                            break;
                        case COUNT_ONLY:
                            selectionBuilder.table(tableToOneDao.getTableName()).count(db);
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
                    cursor = singleTableDao.selectByWhere(db, selection, selectionArgs);
                    break;

                case BIG_SINGLE_TAB:
                    cursor = bigSingleTableDao.selectByWhere(db, selection, selectionArgs);
                    break;

                case MULTI_TAB_RELATION_TO_ONE:
                    cursor = null;
                    Cursor c1 = null, c2 = null, c3 = null, c4 = null, c5 = null, c6 = null, c7 = null, c8 = null, c9 = null, c10 = null;
                    try {
                        c1 = table01Dao.selectByWhere(db, selection, selectionArgs);
                        int columnIdIndex = c1.getColumnIndexOrThrow(BaseColumns._ID);
                        c1.moveToFirst();
                        if (c1.getCount() > 0)
                            do {
                                c2 = table02Dao.selectById(db, c1.getInt(columnIdIndex));
                                c2.moveToFirst();
                                c3 = table03Dao.selectById(db, c2.getInt(columnIdIndex));
                                c2.close();
                                c3.moveToFirst();
                                c4 = table04Dao.selectById(db, c3.getInt(columnIdIndex));
                                c3.close();
                                c4.moveToFirst();
                                c5 = table05Dao.selectById(db, c4.getInt(columnIdIndex));
                                c4.close();
                                c5.moveToFirst();
                                c6 = table06Dao.selectById(db, c5.getInt(columnIdIndex));
                                c5.close();
                                c6.moveToFirst();
                                c7 = table07Dao.selectById(db, c6.getInt(columnIdIndex));
                                c6.close();
                                c7.moveToFirst();
                                c8 = table08Dao.selectById(db, c7.getInt(columnIdIndex));
                                c7.close();
                                c8.moveToFirst();
                                c9 = table09Dao.selectById(db, c8.getInt(columnIdIndex));
                                c8.close();
                                c9.moveToFirst();
                                c10 = table10Dao.selectById(db, c9.getInt(columnIdIndex));
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
                    cursor = tableTomanyDao.selectByWhere(db, selection, selectionArgs);
                    Cursor toOneCursor = null;
                    try {
                        String toOneSelection = TableWithRelationToOneDao.TABLE_WITH_RELATION_TO_MANY_ID + " = ?";
                        String toOneSelectionArgs;
                        int columnIdIndex = cursor.getColumnIndexOrThrow(BaseColumns._ID);
                        cursor.moveToFirst();
                        if (cursor.getCount() > 0)
                            do {
                                toOneSelectionArgs = String.valueOf(cursor.getInt(columnIdIndex));
                                toOneCursor = tableToOneDao.selectByWhere(db, toOneSelection, toOneSelectionArgs);
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
                    cursor = singleTableDao.selectByWhere(db, selection, selectionArgs);
                    break;

                case BIG_SINGLE_TAB:
                    cursor = bigSingleTableDao.selectByWhere(db, selection, selectionArgs);
                    break;

                case MULTI_TAB_RELATION_TO_ONE:
                    cursor = null;
                    Cursor c1 = null, c2 = null, c3 = null, c4 = null, c5 = null, c6 = null, c7 = null, c8 = null, c9 = null, c10 = null;
                    try {
                        c1 = table01Dao.selectByWhere(db, selection, selectionArgs);
                        c1.moveToFirst();
                        if (c1.getCount() > 0) {
                            int columnIdIndex = c1.getColumnIndexOrThrow(BaseColumns._ID);
                            do {
                                c2 = table02Dao.selectById(db, c1.getInt(columnIdIndex));
                                c2.moveToFirst();
                                c3 = table03Dao.selectById(db, c2.getInt(columnIdIndex));
                                c2.close();
                                c3.moveToFirst();
                                c4 = table04Dao.selectById(db, c3.getInt(columnIdIndex));
                                c3.close();
                                c4.moveToFirst();
                                c5 = table05Dao.selectById(db, c4.getInt(columnIdIndex));
                                c4.close();
                                c5.moveToFirst();
                                c6 = table06Dao.selectById(db, c5.getInt(columnIdIndex));
                                c5.close();
                                c6.moveToFirst();
                                c7 = table07Dao.selectById(db, c6.getInt(columnIdIndex));
                                c6.close();
                                c7.moveToFirst();
                                c8 = table08Dao.selectById(db, c7.getInt(columnIdIndex));
                                c7.close();
                                c8.moveToFirst();
                                c9 = table09Dao.selectById(db, c8.getInt(columnIdIndex));
                                c8.close();
                                c9.moveToFirst();
                                c10 = table10Dao.selectById(db, c9.getInt(columnIdIndex));
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
                    cursor = tableTomanyDao.selectByWhere(db, selection, selectionArgs);
                    Cursor toOneCursor = null;
                    try {
                        String toOneSelection = TableWithRelationToOneDao.TABLE_WITH_RELATION_TO_MANY_ID + " = ?";
                        String toOneSelectionArgs;
                        int columnIdIndex = cursor.getColumnIndexOrThrow(BaseColumns._ID);
                        cursor.moveToFirst();
                        if (cursor.getCount() > 0)
                            do {
                                toOneSelectionArgs = String.valueOf(cursor.getInt(columnIdIndex));
                                toOneCursor = tableToOneDao.selectByWhere(db, toOneSelection, toOneSelectionArgs);
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
