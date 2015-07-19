package pl.gombal.orm_benchmarks.io.greendao;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.common.base.Stopwatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import pl.gombal.orm_benchmarks.io.util.ORMBenchmarkTasks;
import pl.gombal.orm_benchmarks.io.greendao.entity.BigSingleTable;
import pl.gombal.orm_benchmarks.io.greendao.entity.BigSingleTableDao;
import pl.gombal.orm_benchmarks.io.greendao.entity.DaoMaster;
import pl.gombal.orm_benchmarks.io.greendao.entity.DaoSession;
import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_01;
import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_01Dao;
import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_02;
import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_02Dao;
import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_03;
import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_03Dao;
import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_04;
import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_04Dao;
import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_05;
import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_05Dao;
import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_06;
import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_06Dao;
import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_07;
import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_07Dao;
import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_08;
import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_08Dao;
import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_09;
import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_09Dao;
import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_10;
import pl.gombal.orm_benchmarks.io.greendao.entity.MultiTable_10Dao;
import pl.gombal.orm_benchmarks.io.greendao.entity.SingleTable;
import pl.gombal.orm_benchmarks.io.greendao.entity.SingleTableDao;
import pl.gombal.orm_benchmarks.io.greendao.entity.TableWithRelationToMany;
import pl.gombal.orm_benchmarks.io.greendao.entity.TableWithRelationToManyDao;
import pl.gombal.orm_benchmarks.io.greendao.entity.TableWithRelationToOne;
import pl.gombal.orm_benchmarks.io.greendao.entity.TableWithRelationToOneDao;
import pl.gombal.orm_benchmarks.io.sqlite.DataBaseOpenHelper;
import pl.gombal.orm_benchmarks.io.util.DataBaseUtils;
import pl.gombal.orm_benchmarks.io.util.EntityFieldGeneratorUtils;
import pl.gombal.orm_benchmarks.util.LogUtils;

public class GreenDaoBenchmarkTasks implements ORMBenchmarkTasks {

    public static final String TAG = GreenDaoBenchmarkTasks.class.getSimpleName();

    public static final String DB_NAME = "greendao-db";

    private boolean initialized = false;

    private SQLiteOpenHelper dbOpenHelper;

    private DaoMaster daoMaster;

    private DaoSession getDaoSession() {
        return daoMaster.newSession();
    }

    @Override
    public String getName() {
        return "GreenDAO";
    }

    public void init(Context context) {
        init(context, false, false);
    }

    @Override
    public void init(Context context, boolean copyDBFormAssets, boolean inMemoryDB) {
        if (copyDBFormAssets) {
            DataBaseUtils.loadDataBaseFileFomAssets(context, DB_NAME);
        }
        dbOpenHelper = new DataBaseOpenHelper(context, DB_NAME, 8, inMemoryDB);
        initialized = true;
    }

    @Override
    public boolean isInitialized() {
        return initialized;
    }

    @Override
    public long createDB() {
        if (!initialized)
            throw new IllegalStateException("Initialize first GreenDaoBenchmarkTasks by call init()!");

        Stopwatch stopwatch = Stopwatch.createStarted();

        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        DaoMaster.createAllTables(db, true);

        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    @Override
    public long dropDB() {
        if (!initialized)
            throw new IllegalStateException("Initialize first GreenDaoBenchmarkTasks by call init()!");

        Stopwatch stopwatch = Stopwatch.createStarted();

        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        DaoMaster.dropAllTables(db, true);

        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    @Override
    public long insert(EntityType entityType, int num, boolean withTransaction) {
        if (!initialized)
            throw new IllegalStateException("Initialize first GreenDaoBenchmarkTasks by call init()!");

        Stopwatch stopwatch = Stopwatch.createUnstarted();

        DaoSession daoSession = null;

        EntityFieldGeneratorUtils.clearAllInstances();
        EntityFieldGeneratorUtils generatorUtils = EntityFieldGeneratorUtils
                .getInstance(EntityFieldGeneratorUtils.GREEN_DAO_ENTITY_FIELD_GENERATOR_ID, num);

        switch (entityType) {
            case SINGLE_TAB:
                List<SingleTable> singleTableList = new ArrayList<>();
                for (int i = 0; i < num; i++) {
                    singleTableList.add(GreenDaoBenchmarkTasksHelper.getNewSingleTable(generatorUtils));
                }

                stopwatch.start();
                daoSession = getDaoSession();
                SingleTableDao singleTableDao = daoSession.getSingleTableDao();
                if (withTransaction) {
                    singleTableDao.insertOrReplaceInTx(singleTableList);
                } else {
                    for (SingleTable singleTable : singleTableList) {
                        singleTableDao.insertOrReplace(singleTable);
                    }
                }
                break;

            case BIG_SINGLE_TAB:
                List<BigSingleTable> bigSingleTableList = new ArrayList<>();
                for (int i = 0; i < num; i++) {
                    bigSingleTableList.add(GreenDaoBenchmarkTasksHelper.getNewBigSingleTable(generatorUtils));
                }

                stopwatch.start();
                daoSession = getDaoSession();
                BigSingleTableDao bigSingleTableDao = daoSession.getBigSingleTableDao();
                if (withTransaction) {
                    bigSingleTableDao.insertOrReplaceInTx(bigSingleTableList);
                } else {
                    for (BigSingleTable table : bigSingleTableList) {
                        bigSingleTableDao.insertOrReplace(table);
                    }
                }
                break;

            case MULTI_TAB_RELATION_TO_ONE:
                final List<MultiTable_01> multiTableList = new ArrayList<>();
                for (int i = 0; i < num; i++) {
                    multiTableList.add(GreenDaoBenchmarkTasksHelper.getNewMultiTableWithRelationToOne(i, generatorUtils, num));
                }

                stopwatch.start();
                daoSession = getDaoSession();
                if (withTransaction) {
                    final DaoSession finalDaoSession = getDaoSession();
                    finalDaoSession.runInTx(new Runnable() {

                        @Override
                        public void run() {
                            MultiTable_01Dao multiTableDao01 = finalDaoSession.getMultiTable_01Dao();
                            MultiTable_02Dao multiTableDao02 = finalDaoSession.getMultiTable_02Dao();
                            MultiTable_03Dao multiTableDao03 = finalDaoSession.getMultiTable_03Dao();
                            MultiTable_04Dao multiTableDao04 = finalDaoSession.getMultiTable_04Dao();
                            MultiTable_05Dao multiTableDao05 = finalDaoSession.getMultiTable_05Dao();
                            MultiTable_06Dao multiTableDao06 = finalDaoSession.getMultiTable_06Dao();
                            MultiTable_07Dao multiTableDao07 = finalDaoSession.getMultiTable_07Dao();
                            MultiTable_08Dao multiTableDao08 = finalDaoSession.getMultiTable_08Dao();
                            MultiTable_09Dao multiTableDao09 = finalDaoSession.getMultiTable_09Dao();
                            MultiTable_10Dao multiTableDao10 = finalDaoSession.getMultiTable_10Dao();

                            for (MultiTable_01 table : multiTableList) {
                                multiTableDao01.insertOrReplace(table);
                                MultiTable_02 table02 = table.getMultiTable_02();
                                multiTableDao02.insertOrReplace(table02);
                                MultiTable_03 table03 = table02.getMultiTable_03();
                                multiTableDao03.insertOrReplace(table03);
                                MultiTable_04 table04 = table03.getMultiTable_04();
                                multiTableDao04.insertOrReplace(table04);
                                MultiTable_05 table05 = table04.getMultiTable_05();
                                multiTableDao05.insertOrReplace(table05);
                                MultiTable_06 table06 = table05.getMultiTable_06();
                                multiTableDao06.insertOrReplace(table06);
                                MultiTable_07 table07 = table06.getMultiTable_07();
                                multiTableDao07.insertOrReplace(table07);
                                MultiTable_08 table08 = table07.getMultiTable_08();
                                multiTableDao08.insertOrReplace(table08);
                                MultiTable_09 table09 = table08.getMultiTable_09();
                                multiTableDao09.insertOrReplace(table09);
                                MultiTable_10 table10 = table09.getMultiTable_10();
                                multiTableDao10.insertOrReplace(table10);
                            }
                            finalDaoSession.clear();
                        }
                    });
                } else {
                    MultiTable_01Dao multiTableDao01 = daoSession.getMultiTable_01Dao();
                    MultiTable_02Dao multiTableDao02 = daoSession.getMultiTable_02Dao();
                    MultiTable_03Dao multiTableDao03 = daoSession.getMultiTable_03Dao();
                    MultiTable_04Dao multiTableDao04 = daoSession.getMultiTable_04Dao();
                    MultiTable_05Dao multiTableDao05 = daoSession.getMultiTable_05Dao();
                    MultiTable_06Dao multiTableDao06 = daoSession.getMultiTable_06Dao();
                    MultiTable_07Dao multiTableDao07 = daoSession.getMultiTable_07Dao();
                    MultiTable_08Dao multiTableDao08 = daoSession.getMultiTable_08Dao();
                    MultiTable_09Dao multiTableDao09 = daoSession.getMultiTable_09Dao();
                    MultiTable_10Dao multiTableDao10 = daoSession.getMultiTable_10Dao();

                    for (MultiTable_01 table : multiTableList) {
                        multiTableDao01.insertOrReplace(table);
                        MultiTable_02 table02 = table.getMultiTable_02();
                        multiTableDao02.insertOrReplace(table02);
                        MultiTable_03 table03 = table02.getMultiTable_03();
                        multiTableDao03.insertOrReplace(table03);
                        MultiTable_04 table04 = table03.getMultiTable_04();
                        multiTableDao04.insertOrReplace(table04);
                        MultiTable_05 table05 = table04.getMultiTable_05();
                        multiTableDao05.insertOrReplace(table05);
                        MultiTable_06 table06 = table05.getMultiTable_06();
                        multiTableDao06.insertOrReplace(table06);
                        MultiTable_07 table07 = table06.getMultiTable_07();
                        multiTableDao07.insertOrReplace(table07);
                        MultiTable_08 table08 = table07.getMultiTable_08();
                        multiTableDao08.insertOrReplace(table08);
                        MultiTable_09 table09 = table08.getMultiTable_09();
                        multiTableDao09.insertOrReplace(table09);
                        MultiTable_10 table10 = table09.getMultiTable_10();
                        multiTableDao10.insertOrReplace(table10);
                    }
                }
                break;

            case SINGLE_TAB_RELATION_TO_MANY:
                final List<TableWithRelationToMany> tableWithRelationToManyList = new ArrayList<>();
                final List<TableWithRelationToOne> tableWithRelationToOneList = new ArrayList<>();
                for (int i = 0; i < num; i++) {
                    TableWithRelationToMany toMany = GreenDaoBenchmarkTasksHelper.getNewTableWithRelationToMany(i, generatorUtils);
                    tableWithRelationToManyList.add(toMany);
                    tableWithRelationToOneList.addAll(GreenDaoBenchmarkTasksHelper.getNewTableWithRelationToOneList(i, num, 10));
                }

                stopwatch.start();
                if (withTransaction) {
                    final DaoSession finalDaoSession = getDaoSession();
                    finalDaoSession.runInTx(new Runnable() {

                        @Override
                        public void run() {
                            TableWithRelationToManyDao toManyDao = finalDaoSession.getTableWithRelationToManyDao();
                            TableWithRelationToOneDao toOneDao = finalDaoSession.getTableWithRelationToOneDao();
                            for (TableWithRelationToMany table : tableWithRelationToManyList) {
                                toManyDao.insertOrReplace(table);
                            }
                            for (TableWithRelationToOne table : tableWithRelationToOneList) {
                                toOneDao.insertOrReplace(table);
                            }
                            finalDaoSession.clear();
                        }
                    });
                } else {
                    daoSession = getDaoSession();
                    TableWithRelationToManyDao toManyDao = daoSession.getTableWithRelationToManyDao();
                    TableWithRelationToOneDao toOneDao = daoSession.getTableWithRelationToOneDao();
                    for (TableWithRelationToMany table : tableWithRelationToManyList) {
                        toManyDao.insertOrReplace(table);
                    }
                    for (TableWithRelationToOne table : tableWithRelationToOneList) {
                        toOneDao.insertOrReplace(table);
                    }
                }
                break;
        }

        if (daoSession != null)
            daoSession.clear();

        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    @Override
    public long update(EntityType entityType, int num, boolean withTransaction) {
        if (!initialized)
            throw new IllegalStateException("Initialize first GreenDaoBenchmarkTasks by call init()!");

        Stopwatch stopwatch = Stopwatch.createUnstarted();

        DaoSession daoSession = null;

        switch (entityType) {
            case SINGLE_TAB:
                daoSession = getDaoSession();
                SingleTableDao singleTableDao = daoSession.getSingleTableDao();
                List<SingleTable> singleTableList = singleTableDao.queryBuilder().limit(num).list();
                if (singleTableList.size() < num)
                    throw new ExceptionInInitializerError("Number entities to update is smaller than: " + num);
                for (SingleTable table : singleTableList) {
                    table.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                }
                daoSession.clear();

                stopwatch.start();
                daoSession = getDaoSession();
                singleTableDao = daoSession.getSingleTableDao();
                if (withTransaction) {
                    singleTableDao.updateInTx(singleTableList);
                } else {
                    for (SingleTable singleTable : singleTableList) {
                        singleTableDao.update(singleTable);
                    }
                }
                break;

            case BIG_SINGLE_TAB:
                daoSession = getDaoSession();
                BigSingleTableDao bigSingleTableDao = daoSession.getBigSingleTableDao();
                List<BigSingleTable> bigSingleTableList = bigSingleTableDao.queryBuilder().limit(num).list();
                if (bigSingleTableList.size() < num)
                    throw new ExceptionInInitializerError("Number entities to update is smaller than: " + num);
                for (BigSingleTable table : bigSingleTableList) {
                    table.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                }
                daoSession.clear();

                stopwatch.start();
                daoSession = getDaoSession();
                bigSingleTableDao = daoSession.getBigSingleTableDao();
                if (withTransaction) {
                    bigSingleTableDao.updateInTx(bigSingleTableList);
                } else {
                    for (BigSingleTable table : bigSingleTableList) {
                        bigSingleTableDao.update(table);
                    }
                }
                break;

            case MULTI_TAB_RELATION_TO_ONE:
                daoSession = getDaoSession();
                MultiTable_01Dao multiTableDao = daoSession.getMultiTable_01Dao();
                List<MultiTable_01> multiTableList = multiTableDao.queryBuilder().limit(num).list();
                if (multiTableList.size() < num)
                    throw new ExceptionInInitializerError("Number entities to update is smaller than: " + num);
                for (MultiTable_01 table01 : multiTableList) {
                    table01.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                    MultiTable_02 table02 = table01.getMultiTable_02();
                    table02.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                    MultiTable_03 table03 = table02.getMultiTable_03();
                    table03.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                    MultiTable_04 table04 = table03.getMultiTable_04();
                    table04.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                    MultiTable_05 table05 = table04.getMultiTable_05();
                    table05.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                    MultiTable_06 table06 = table05.getMultiTable_06();
                    table06.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                    MultiTable_07 table07 = table06.getMultiTable_07();
                    table07.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                    MultiTable_08 table08 = table07.getMultiTable_08();
                    table08.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                    MultiTable_09 table09 = table08.getMultiTable_09();
                    table09.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                    table09.getMultiTable_10().setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                }
                daoSession.clear();

                stopwatch.start();
                daoSession = getDaoSession();
                multiTableDao = daoSession.getMultiTable_01Dao();
                if (withTransaction) {
                    multiTableDao.updateInTx(multiTableList);
                } else {
                    MultiTable_01Dao multiTableDao01 = daoSession.getMultiTable_01Dao();
                    MultiTable_02Dao multiTableDao02 = daoSession.getMultiTable_02Dao();
                    MultiTable_03Dao multiTableDao03 = daoSession.getMultiTable_03Dao();
                    MultiTable_04Dao multiTableDao04 = daoSession.getMultiTable_04Dao();
                    MultiTable_05Dao multiTableDao05 = daoSession.getMultiTable_05Dao();
                    MultiTable_06Dao multiTableDao06 = daoSession.getMultiTable_06Dao();
                    MultiTable_07Dao multiTableDao07 = daoSession.getMultiTable_07Dao();
                    MultiTable_08Dao multiTableDao08 = daoSession.getMultiTable_08Dao();
                    MultiTable_09Dao multiTableDao09 = daoSession.getMultiTable_09Dao();
                    MultiTable_10Dao multiTableDao10 = daoSession.getMultiTable_10Dao();

                    for (MultiTable_01 table : multiTableList) {
                        multiTableDao01.update(table);
                        MultiTable_02 table02 = table.getMultiTable_02();
                        multiTableDao02.update(table02);
                        MultiTable_03 table03 = table02.getMultiTable_03();
                        multiTableDao03.update(table03);
                        MultiTable_04 table04 = table03.getMultiTable_04();
                        multiTableDao04.update(table04);
                        MultiTable_05 table05 = table04.getMultiTable_05();
                        multiTableDao05.update(table05);
                        MultiTable_06 table06 = table05.getMultiTable_06();
                        multiTableDao06.update(table06);
                        MultiTable_07 table07 = table06.getMultiTable_07();
                        multiTableDao07.update(table07);
                        MultiTable_08 table08 = table07.getMultiTable_08();
                        multiTableDao08.update(table08);
                        MultiTable_09 table09 = table08.getMultiTable_09();
                        multiTableDao09.update(table09);
                        MultiTable_10 table10 = table09.getMultiTable_10();
                        multiTableDao10.update(table10);
                    }
                }
                break;

            case SINGLE_TAB_RELATION_TO_MANY:
                daoSession = getDaoSession();
                TableWithRelationToManyDao toManyDao = daoSession.getTableWithRelationToManyDao();
                final List<TableWithRelationToMany> tableWithRelationToManyList = toManyDao.queryBuilder().limit(num).list();
                if (tableWithRelationToManyList.size() < num)
                    throw new ExceptionInInitializerError("Number entities to update is smaller than: " + num);
                final List<TableWithRelationToOne> tableWithRelationToOneList = new ArrayList<>();
                for (TableWithRelationToMany table : tableWithRelationToManyList) {
                    table.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                    List<TableWithRelationToOne> toOneListTMP = table.getTableWithRelationToOneList();
                    for (TableWithRelationToOne tableToOne : toOneListTMP)
                        tableToOne.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(10));
                    tableWithRelationToOneList.addAll(toOneListTMP);
                }
                daoSession.clear();

                stopwatch.start();
                if (withTransaction) {
                    final DaoSession finalDaoSession = getDaoSession();
                    finalDaoSession.runInTx(new Runnable() {

                        @Override
                        public void run() {
                            TableWithRelationToManyDao toManyDao = finalDaoSession.getTableWithRelationToManyDao();
                            TableWithRelationToOneDao toOneDao = finalDaoSession.getTableWithRelationToOneDao();
                            for (TableWithRelationToMany table : tableWithRelationToManyList) {
                                toManyDao.update(table);
                            }
                            for (TableWithRelationToOne table : tableWithRelationToOneList) {
                                toOneDao.update(table);
                            }
                            finalDaoSession.clear();
                        }
                    });
                } else {
                    daoSession = getDaoSession();
                    toManyDao = daoSession.getTableWithRelationToManyDao();
                    TableWithRelationToOneDao toOneDao = daoSession.getTableWithRelationToOneDao();
                    for (TableWithRelationToMany table : tableWithRelationToManyList) {
                        toManyDao.update(table);
                    }
                    for (TableWithRelationToOne table : tableWithRelationToOneList) {
                        toOneDao.update(table);
                    }
                }
                break;
        }

        if (daoSession != null)
            daoSession.clear();

        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    @Override
    public long selectAll(EntityType entityType, SelectionType selectionType) {
        if (!initialized)
            throw new IllegalStateException("Initialize first GreenDaoBenchmarkTasks by call init()!");

        Stopwatch stopwatch = Stopwatch.createStarted();

        DaoSession daoSession = getDaoSession();
        switch (entityType) {
            case SINGLE_TAB:
                SingleTableDao singleTableDao = daoSession.getSingleTableDao();
                switch (selectionType) {
                    case WITH_LAZY_INIT:
                        singleTableDao.queryBuilder().build().listLazy().close();
                        break;
                    case WITHOUT_LAZY_INIT:
                        singleTableDao.loadAll();
                        break;
                    case COUNT_ONLY:
                        singleTableDao.count();
                        break;
                }
                break;

            case BIG_SINGLE_TAB:
                BigSingleTableDao bigSingleTableDao = daoSession.getBigSingleTableDao();
                switch (selectionType) {
                    case WITH_LAZY_INIT:
                        bigSingleTableDao.queryBuilder().build().listLazy().close();
                        break;
                    case WITHOUT_LAZY_INIT:
                        bigSingleTableDao.loadAll();
                        break;
                    case COUNT_ONLY:
                        bigSingleTableDao.count();
                        break;
                }
                break;

            case MULTI_TAB_RELATION_TO_ONE:
                MultiTable_01Dao multiTableDao = daoSession.getMultiTable_01Dao();
                switch (selectionType) {
                    case WITH_LAZY_INIT:
                        multiTableDao.queryBuilder().build().listLazy().close();
                        break;
                    case WITHOUT_LAZY_INIT:
                        List<MultiTable_01> multiTableList = multiTableDao.loadAll();
                        for (MultiTable_01 table : multiTableList) {
                            table.getMultiTable_02()
                                    .getMultiTable_03()
                                    .getMultiTable_04()
                                    .getMultiTable_05()
                                    .getMultiTable_06()
                                    .getMultiTable_07()
                                    .getMultiTable_08()
                                    .getMultiTable_09()
                                    .getMultiTable_10();
                        }
                        break;
                    case COUNT_ONLY:
                        multiTableDao.count();
                        break;
                }
                break;

            case SINGLE_TAB_RELATION_TO_MANY:
                TableWithRelationToManyDao toManyDao = daoSession.getTableWithRelationToManyDao();
                switch (selectionType) {
                    case WITH_LAZY_INIT:
                        toManyDao.queryBuilder().build().listLazy().close();
                        break;
                    case WITHOUT_LAZY_INIT:
                        List<TableWithRelationToMany> tableWithRelationToManyList = toManyDao.loadAll();
                        for (TableWithRelationToMany table : tableWithRelationToManyList) {
                            table.getTableWithRelationToOneList();
                        }
                        break;
                    case COUNT_ONLY:
                        toManyDao.count();
                        break;
                }
                break;
        }

        daoSession.clear();

        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    @Override
    public long searchIndexed(EntityType entityType, int value) {
        if (!initialized)
            throw new IllegalStateException("Initialize first GreenDaoBenchmarkTasks by call init()!");

        Stopwatch stopwatch = Stopwatch.createStarted();

        int size = 0;
        DaoSession daoSession = getDaoSession();
        switch (entityType) {
            case SINGLE_TAB:
                SingleTableDao singleTableDao = daoSession.getSingleTableDao();
                size = singleTableDao.queryBuilder().where(SingleTableDao.Properties.SampleIntCollIndexed.eq(value)).list().size();
                break;

            case BIG_SINGLE_TAB:
                BigSingleTableDao bigSingleTableDao = daoSession.getBigSingleTableDao();
                size = bigSingleTableDao.queryBuilder().where(BigSingleTableDao.Properties.SampleIntCollIndexed.eq(value)).list().size();
                break;

            case MULTI_TAB_RELATION_TO_ONE:
                MultiTable_01Dao multiTableDao = daoSession.getMultiTable_01Dao();
                size = multiTableDao.queryBuilder().where(MultiTable_01Dao.Properties.SampleIntCollIndexed.eq(value)).list().size();
                break;

            case SINGLE_TAB_RELATION_TO_MANY:
                TableWithRelationToManyDao toManyDao = daoSession.getTableWithRelationToManyDao();
                size = toManyDao.queryBuilder().where(TableWithRelationToManyDao.Properties.SampleIntCollIndexed.eq(value)).list().size();
                break;
        }

        LogUtils.LOGD(TAG, "Found " + size + "rows.");

        daoSession.clear();
        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    @Override
    public long search(EntityType entityType, String value) {
        if (!initialized)
            throw new IllegalStateException("Initialize first GreenDaoBenchmarkTasks by call init()!");

        Stopwatch stopwatch = Stopwatch.createStarted();

        int size = 0;
        DaoSession daoSession = getDaoSession();
        switch (entityType) {
            case SINGLE_TAB:
                SingleTableDao singleTableDao = daoSession.getSingleTableDao();
                size = singleTableDao.queryBuilder().where(SingleTableDao.Properties.SampleStringColl01.like("%" + value + "%")).list().size();
                break;

            case BIG_SINGLE_TAB:
                BigSingleTableDao bigSingleTableDao = daoSession.getBigSingleTableDao();
                size = bigSingleTableDao.queryBuilder().where(BigSingleTableDao.Properties.SampleStringColl01.like("%" + value + "%")).list().size();
                break;

            case MULTI_TAB_RELATION_TO_ONE:
                MultiTable_01Dao multiTableDao = daoSession.getMultiTable_01Dao();
                size = multiTableDao.queryBuilder().where(MultiTable_01Dao.Properties.SampleStringColl01.like("%" + value + "%")).list().size();
                break;

            case SINGLE_TAB_RELATION_TO_MANY:
                TableWithRelationToManyDao toManyDao = daoSession.getTableWithRelationToManyDao();
                size = toManyDao.queryBuilder().where(TableWithRelationToManyDao.Properties.SampleStringColl01.like("%" + value + "%")).list().size();
                break;
        }

        LogUtils.LOGD(TAG, "Found " + size + "rows.");

        daoSession.clear();
        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }
}
