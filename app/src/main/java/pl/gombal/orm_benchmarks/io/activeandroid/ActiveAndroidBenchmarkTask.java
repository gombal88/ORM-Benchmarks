package pl.gombal.orm_benchmarks.io.activeandroid;


import android.content.Context;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Select;
import com.google.common.base.Stopwatch;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import pl.gombal.orm_benchmarks.io.activeandroid.entity.BaseSimpleEntity;
import pl.gombal.orm_benchmarks.io.activeandroid.entity.BigSingleTable;
import pl.gombal.orm_benchmarks.io.activeandroid.entity.MultiTable_01;
import pl.gombal.orm_benchmarks.io.activeandroid.entity.MultiTable_02;
import pl.gombal.orm_benchmarks.io.activeandroid.entity.MultiTable_03;
import pl.gombal.orm_benchmarks.io.activeandroid.entity.MultiTable_04;
import pl.gombal.orm_benchmarks.io.activeandroid.entity.MultiTable_05;
import pl.gombal.orm_benchmarks.io.activeandroid.entity.MultiTable_06;
import pl.gombal.orm_benchmarks.io.activeandroid.entity.MultiTable_07;
import pl.gombal.orm_benchmarks.io.activeandroid.entity.MultiTable_08;
import pl.gombal.orm_benchmarks.io.activeandroid.entity.MultiTable_09;
import pl.gombal.orm_benchmarks.io.activeandroid.entity.MultiTable_10;
import pl.gombal.orm_benchmarks.io.activeandroid.entity.SingleTable;
import pl.gombal.orm_benchmarks.io.activeandroid.entity.TableWithRelationToMany;
import pl.gombal.orm_benchmarks.io.activeandroid.entity.TableWithRelationToOne;
import pl.gombal.orm_benchmarks.io.util.DataBaseUtils;
import pl.gombal.orm_benchmarks.io.util.EntityFieldGeneratorUtils;
import pl.gombal.orm_benchmarks.io.util.ORMBenchmarkTasks;
import pl.gombal.orm_benchmarks.util.LogUtils;

public class ActiveAndroidBenchmarkTask implements ORMBenchmarkTasks {

    public static final String TAG = ActiveAndroidBenchmarkTask.class.getSimpleName();

    public static final String DB_NAME = "activeandroid-db";

    private boolean initialized = false;

    @Override
    public String getName() {
        return "ActiveAndroidBenchmarkTask";
    }

    public void init(Context context) {
        init(context, false, false);
    }

    @Override
    public void init(Context context, boolean copyDBFormAssets, boolean inMemoryDB) {
        if (copyDBFormAssets)
            DataBaseUtils.loadDataBaseFileFomAssets(context, DB_NAME);

        initialized = true;
    }

    @Override
    public boolean isInitialized() {
        return initialized;
    }

    @Override
    public long createDB() throws SQLException {
        return -1;
    }

    @Override
    public long dropDB() throws SQLException {
        if (!initialized)
            throw new IllegalStateException("Initialize first ActiveAndroidBenchmarkTask by call init()!");

        Stopwatch stopwatch = Stopwatch.createStarted();

        ActiveAndroid.execSQL("delete from " + SingleTable.TABLE_NAME + ";");
        ActiveAndroid.execSQL("delete from sqlite_sequence where name='" + SingleTable.TABLE_NAME + "';");
        ActiveAndroid.execSQL("delete from " + BigSingleTable.TABLE_NAME + ";");
        ActiveAndroid.execSQL("delete from sqlite_sequence where name='" + BigSingleTable.TABLE_NAME + "';");
        ActiveAndroid.execSQL("delete from " + MultiTable_01.TABLE_NAME + ";");
        ActiveAndroid.execSQL("delete from sqlite_sequence where name='" + MultiTable_01.TABLE_NAME + "';");
        ActiveAndroid.execSQL("delete from " + MultiTable_02.TABLE_NAME + ";");
        ActiveAndroid.execSQL("delete from sqlite_sequence where name='" + MultiTable_02.TABLE_NAME + "';");
        ActiveAndroid.execSQL("delete from " + MultiTable_03.TABLE_NAME + ";");
        ActiveAndroid.execSQL("delete from sqlite_sequence where name='" + MultiTable_03.TABLE_NAME + "';");
        ActiveAndroid.execSQL("delete from " + MultiTable_04.TABLE_NAME + ";");
        ActiveAndroid.execSQL("delete from sqlite_sequence where name='" + MultiTable_04.TABLE_NAME + "';");
        ActiveAndroid.execSQL("delete from " + MultiTable_05.TABLE_NAME + ";");
        ActiveAndroid.execSQL("delete from sqlite_sequence where name='" + MultiTable_05.TABLE_NAME + "';");
        ActiveAndroid.execSQL("delete from " + MultiTable_06.TABLE_NAME + ";");
        ActiveAndroid.execSQL("delete from sqlite_sequence where name='" + MultiTable_06.TABLE_NAME + "';");
        ActiveAndroid.execSQL("delete from " + MultiTable_07.TABLE_NAME + ";");
        ActiveAndroid.execSQL("delete from sqlite_sequence where name='" + MultiTable_07.TABLE_NAME + "';");
        ActiveAndroid.execSQL("delete from " + MultiTable_08.TABLE_NAME + ";");
        ActiveAndroid.execSQL("delete from sqlite_sequence where name='" + MultiTable_08.TABLE_NAME + "';");
        ActiveAndroid.execSQL("delete from " + MultiTable_09.TABLE_NAME + ";");
        ActiveAndroid.execSQL("delete from sqlite_sequence where name='" + MultiTable_09.TABLE_NAME + "';");
        ActiveAndroid.execSQL("delete from " + MultiTable_10.TABLE_NAME + ";");
        ActiveAndroid.execSQL("delete from sqlite_sequence where name='" + MultiTable_10.TABLE_NAME + "';");
        ActiveAndroid.execSQL("delete from " + TableWithRelationToOne.TABLE_NAME + ";");
        ActiveAndroid.execSQL("delete from sqlite_sequence where name='" + TableWithRelationToOne.TABLE_NAME + "';");
        ActiveAndroid.execSQL("delete from " + TableWithRelationToMany.TABLE_NAME + ";");
        ActiveAndroid.execSQL("delete from sqlite_sequence where name='" + TableWithRelationToMany.TABLE_NAME + "';");

        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    @Override
    public long insert(EntityType entityType, int num, boolean withTransaction) throws SQLException {
        return saveOrUpdateAction(entityType, num, withTransaction, false);
    }

    @Override
    public long update(EntityType entityType, int num, boolean withTransaction) throws SQLException {
        return saveOrUpdateAction(entityType, num, withTransaction, true);
    }

    private long saveOrUpdateAction(EntityType entityType, int num, boolean withTransaction, boolean update) {
        if (!initialized)
            throw new IllegalStateException("Initialize first ActiveAndroidBenchmarkTask by call init()!");

        Stopwatch stopwatch = Stopwatch.createUnstarted();

        EntityFieldGeneratorUtils generatorUtils = null;
        if (!update) {
            EntityFieldGeneratorUtils.clearAllInstances();
            generatorUtils = EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.ACTIVE_ANDROID_ENTITY_FIELD_GENERATOR_ID, num);
        }

        switch (entityType) {
            case SINGLE_TAB:
                List<SingleTable> singleTableList = new ArrayList<>();
                if (!update) {
                    for (int i = 0; i < num; i++)
                        singleTableList.add(SingleTable.getNewEntityWithRandomData(generatorUtils));
                } else {
                    singleTableList = ActiveAndroidBenchmarkTaskHelper.getSingleTableListToUpdate(num);
                    if (singleTableList.size() < num)
                        throw new ExceptionInInitializerError("Number entities to update is smaller than: " + num);
                }

                stopwatch.start();
                if (withTransaction) {
                    ActiveAndroid.beginTransaction();
                    try {
                        for (SingleTable table : singleTableList)
                            table.save();
                        ActiveAndroid.setTransactionSuccessful();
                    } finally {
                        ActiveAndroid.endTransaction();
                    }
                } else {
                    for (SingleTable table : singleTableList)
                        table.save();
                }
                break;

            case BIG_SINGLE_TAB:
                List<BigSingleTable> bigSingleTableList = new ArrayList<>();
                if (!update) {
                    for (int i = 0; i < num; i++)
                        bigSingleTableList.add(BigSingleTable.getNewEntityWithRandomData(generatorUtils));
                } else {
                    bigSingleTableList = ActiveAndroidBenchmarkTaskHelper.getBigSingleTableListToUpdate(num);
                    if (bigSingleTableList.size() < num)
                        throw new ExceptionInInitializerError("Number entities to update is smaller than: " + num);
                }

                stopwatch.start();
                if (withTransaction) {
                    ActiveAndroid.beginTransaction();
                    try {
                        for (BigSingleTable table : bigSingleTableList)
                            table.save();
                        ActiveAndroid.setTransactionSuccessful();
                    } finally {
                        ActiveAndroid.endTransaction();
                    }
                } else {
                    for (BigSingleTable table : bigSingleTableList)
                        table.save();
                }
                break;

            case MULTI_TAB_RELATION_TO_ONE:
                List<MultiTable_01> multiTableList = new ArrayList<>();
                if (!update) {
                    for (int i = 0; i < num; i++)
                        multiTableList.add(MultiTable_01.getNewEntityWithRandomData(generatorUtils));
                } else {
                    multiTableList = ActiveAndroidBenchmarkTaskHelper.getMultiTableListToUpdate(num);
                    if (multiTableList.size() < num)
                        throw new ExceptionInInitializerError("Number entities to update is smaller than: " + num);
                }

                stopwatch.start();
                if (withTransaction) {
                    ActiveAndroid.beginTransaction();
                    try {
                        for (MultiTable_01 table01 : multiTableList) {
                            MultiTable_02 table02 = table01.getMultiTable_02();
                            MultiTable_03 table03 = table02.getMultiTable_03();
                            MultiTable_04 table04 = table03.getMultiTable_04();
                            MultiTable_05 table05 = table04.getMultiTable_05();
                            MultiTable_06 table06 = table05.getMultiTable_06();
                            MultiTable_07 table07 = table06.getMultiTable_07();
                            MultiTable_08 table08 = table07.getMultiTable_08();
                            MultiTable_09 table09 = table08.getMultiTable_09();
                            MultiTable_10 table10 = table09.getMultiTable_10();

                            table10.save();
                            table09.save();
                            table08.save();
                            table07.save();
                            table06.save();
                            table05.save();
                            table04.save();
                            table03.save();
                            table02.save();
                            table01.save();
                        }
                        ActiveAndroid.setTransactionSuccessful();
                    } finally {
                        ActiveAndroid.endTransaction();
                    }
                } else {
                    for (MultiTable_01 table01 : multiTableList) {
                        MultiTable_02 table02 = table01.getMultiTable_02();
                        MultiTable_03 table03 = table02.getMultiTable_03();
                        MultiTable_04 table04 = table03.getMultiTable_04();
                        MultiTable_05 table05 = table04.getMultiTable_05();
                        MultiTable_06 table06 = table05.getMultiTable_06();
                        MultiTable_07 table07 = table06.getMultiTable_07();
                        MultiTable_08 table08 = table07.getMultiTable_08();
                        MultiTable_09 table09 = table08.getMultiTable_09();
                        MultiTable_10 table10 = table09.getMultiTable_10();

                        table10.save();
                        table09.save();
                        table08.save();
                        table07.save();
                        table06.save();
                        table05.save();
                        table04.save();
                        table03.save();
                        table02.save();
                        table01.save();
                    }
                }
                break;

            case SINGLE_TAB_RELATION_TO_MANY:
                List<TableWithRelationToMany> toManyList = new ArrayList<>();
                List<TableWithRelationToOne> toOneList = new ArrayList<>();
                if (!update) {
                    EntityFieldGeneratorUtils generatorUtilsToOne =
                            EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.ACTIVE_ANDROID_ENTITY_FIELD_GENERATOR_ID + 50, generatorUtils.getUniqueNumberRange() * 10);
                    for (int i = 0; i < num; i++) {
                        TableWithRelationToMany toMany = TableWithRelationToMany.getNewEntityWithRandomData(generatorUtils);
                        toManyList.add(toMany);
                        for (int j = 0; j < 10; j++) {
                            toOneList.add(TableWithRelationToOne.getNewEntityWithRandomData(toMany, generatorUtilsToOne));
                        }
                    }
                } else {
                    toManyList = ActiveAndroidBenchmarkTaskHelper.getTableToManyListToUpdate(num);
                    toOneList = ActiveAndroidBenchmarkTaskHelper.getTableToOneListToUpdate(toManyList);
                    if (toManyList.size() < num)
                        throw new ExceptionInInitializerError("Number entities to update is smaller than: " + num);
                }

                stopwatch.start();
                if (withTransaction) {
                    ActiveAndroid.beginTransaction();
                    try {
                        for (TableWithRelationToMany table : toManyList)
                            table.save();
                        for (TableWithRelationToOne tableToOne : toOneList)
                            tableToOne.save();
                        ActiveAndroid.setTransactionSuccessful();
                    } finally {
                        ActiveAndroid.endTransaction();
                    }
                } else {
                    for (TableWithRelationToMany table : toManyList)
                        table.save();
                    for (TableWithRelationToOne tableToOne : toOneList)
                        tableToOne.save();
                }
                break;
        }

        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    @Override
    public long selectAll(EntityType entityType, SelectionType selectionType) throws SQLException {
        if (!initialized)
            throw new IllegalStateException("Initialize first ActiveAndroidBenchmarkTask by call init()!");

        Stopwatch stopwatch = Stopwatch.createStarted();

        switch (entityType) {
            case SINGLE_TAB:
                switch (selectionType) {
                    case WITH_LAZY_INIT:
                        return -1;
                    case WITHOUT_LAZY_INIT:
                        new Select().all().from(SingleTable.class).execute();
                        break;
                    case COUNT_ONLY:
                        new Select().all().from(SingleTable.class).count();
                        break;
                }
                break;

            case BIG_SINGLE_TAB:
                switch (selectionType) {
                    case WITH_LAZY_INIT:
                        return -1;
                    case WITHOUT_LAZY_INIT:
                        new Select().all().from(BigSingleTable.class).execute();
                        break;
                    case COUNT_ONLY:
                        new Select().all().from(BigSingleTable.class).count();
                        break;
                }
                break;

            case MULTI_TAB_RELATION_TO_ONE:
                switch (selectionType) {
                    case WITH_LAZY_INIT:
                        return -1;
                    case WITHOUT_LAZY_INIT:
                        new Select().all().from(MultiTable_01.class).execute();
                        break;
                    case COUNT_ONLY:
                        new Select().all().from(MultiTable_01.class).count();
                        break;
                }
                break;

            case SINGLE_TAB_RELATION_TO_MANY:
                switch (selectionType) {
                    case WITH_LAZY_INIT:
                        new Select().all().from(TableWithRelationToMany.class).execute();
                        break;
                    case WITHOUT_LAZY_INIT:
                        List<TableWithRelationToMany> toManyList = new Select().all().from(TableWithRelationToMany.class).execute();
                        for (TableWithRelationToMany tableToMany : toManyList)
                            tableToMany.getTableWithRelationToOneList();
                        break;
                    case COUNT_ONLY:
                        new Select().all().from(TableWithRelationToMany.class).count();
                        break;
                }
                break;
        }
        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    @Override
    public long searchIndexed(EntityType entityType, int value) throws SQLException {
        if (!initialized)
            throw new IllegalStateException("Initialize first ActiveAndroidBenchmarkTask by call init()!");

        int size = 0;

        String selection = BaseSimpleEntity.SAMPLE_INT_COLL_INDEXED + " = ? ";
        Stopwatch stopwatch = Stopwatch.createStarted();
        switch (entityType) {
            case SINGLE_TAB:
                size = new Select().from(SingleTable.class).where(selection, String.valueOf(value)).execute().size();
                break;
            case BIG_SINGLE_TAB:
                size = new Select().from(BigSingleTable.class).where(selection, String.valueOf(value)).execute().size();
                break;
            case MULTI_TAB_RELATION_TO_ONE:
                size = new Select().from(MultiTable_01.class).where(selection, String.valueOf(value)).execute().size();
                break;
            case SINGLE_TAB_RELATION_TO_MANY:
                size = new Select().from(TableWithRelationToMany.class).where(selection, String.valueOf(value)).execute().size();
                break;
        }
        LogUtils.LOGD(TAG, "Found " + size + "rows.");
        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    @Override
    public long search(EntityType entityType, String value) throws SQLException {
        if (!initialized)
            throw new IllegalStateException("Initialize first ActiveAndroidBenchmarkTask by call init()!");

        int size = 0;

        String selection = BaseSimpleEntity.SAMPLE_STRING_COLL_01 + " LIKE ? ";
        String arg = "%" + value + "%";
        Stopwatch stopwatch = Stopwatch.createStarted();
        switch (entityType) {
            case SINGLE_TAB:
                size = new Select().from(SingleTable.class).where(selection, arg).execute().size();
                break;
            case BIG_SINGLE_TAB:
                size = new Select().from(BigSingleTable.class).where(selection, arg).execute().size();
                break;
            case MULTI_TAB_RELATION_TO_ONE:
                size = new Select().from(MultiTable_01.class).where(selection, arg).execute().size();
                break;
            case SINGLE_TAB_RELATION_TO_MANY:
                size = new Select().from(TableWithRelationToMany.class).where(selection, arg).execute().size();
                break;
        }
        LogUtils.LOGD(TAG, "Found " + size + "rows.");
        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }
}
