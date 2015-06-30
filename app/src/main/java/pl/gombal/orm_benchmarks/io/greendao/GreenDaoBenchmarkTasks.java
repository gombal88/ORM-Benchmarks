package pl.gombal.orm_benchmarks.io.greendao;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.common.base.Stopwatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import pl.gombal.orm_benchmarks.io.ORMBenchmarkTasks;
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
import pl.gombal.orm_benchmarks.util.DataBaseUtils;
import pl.gombal.orm_benchmarks.util.EntityFieldGeneratorUtils;
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

        EntityFieldGeneratorUtils.init(num);
        EntityFieldGeneratorUtils generatorUtils = EntityFieldGeneratorUtils.getInstance();

        switch (entityType) {
            case SINGLE_TAB:
                List<SingleTable> singleTableList = new ArrayList<>();
                for (int i = 0; i < num; i++) {
                    singleTableList.add(getNewSingleTable(generatorUtils));
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
                    bigSingleTableList.add(getNewBigSingleTable(generatorUtils));
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
                    multiTableList.add(getNewMultiTableWithRelationToOne(i, generatorUtils));
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
                    Stopwatch stopwatchTMP = Stopwatch.createStarted();
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
                    LogUtils.LOGI("ORM_BENCHMARKS", "getDAOs time: " + stopwatchTMP.elapsed(TimeUnit.MILLISECONDS));

                    for (MultiTable_01 table : multiTableList) {
                        multiTableDao01.insertOrReplace(table);
                        Stopwatch stopwatchEntity = Stopwatch.createStarted();
                        MultiTable_02 table02 = table.getMultiTable_02();
                        LogUtils.LOGI("ORM_BENCHMARKS", "getEntity time: " + stopwatchEntity.elapsed(TimeUnit.NANOSECONDS));
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
                    TableWithRelationToMany toMany = getNewTableWithRelationToMany(i, generatorUtils);
                    tableWithRelationToManyList.add(toMany);
                    tableWithRelationToOneList.addAll(getNewTableWithRelationToOneList(i, toMany.getSampleIntCollIndexed(), 10));
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
    public long selectAll(EntityType entityType, boolean lazy) {
        if (!initialized)
            throw new IllegalStateException("Initialize first GreenDaoBenchmarkTasks by call init()!");

        Stopwatch stopwatch = Stopwatch.createUnstarted();

        DaoSession daoSession = null;

        switch (entityType) {
            case SINGLE_TAB:
                stopwatch.start();
                daoSession = getDaoSession();
                SingleTableDao singleTableDao = daoSession.getSingleTableDao();
                if (lazy) {
                    singleTableDao.queryBuilder().build().listLazy().close();
                } else {
                    singleTableDao.loadAll();
                }
                break;

            case BIG_SINGLE_TAB:
                stopwatch.start();
                daoSession = getDaoSession();
                BigSingleTableDao bigSingleTableDao = daoSession.getBigSingleTableDao();
                if (lazy) {
                    bigSingleTableDao.queryBuilder().build().listLazy().close();
                } else {
                    bigSingleTableDao.loadAll();
                }
                break;

            case MULTI_TAB_RELATION_TO_ONE:
                stopwatch.start();
                daoSession = getDaoSession();
                MultiTable_01Dao multiTableDao = daoSession.getMultiTable_01Dao();
                if (lazy) {
                    multiTableDao.queryBuilder().build().listLazy().close();
                } else {
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
                }
                break;

            case SINGLE_TAB_RELATION_TO_MANY:
                stopwatch.start();
                daoSession = getDaoSession();
                TableWithRelationToManyDao toManyDao = daoSession.getTableWithRelationToManyDao();
                if (lazy) {
                    toManyDao.queryBuilder().build().listLazy().close();
                } else {
                    List<TableWithRelationToMany> tableWithRelationToManyList = toManyDao.loadAll();
                    for (TableWithRelationToMany table : tableWithRelationToManyList) {
                        table.getTableWithRelationToOneList();
                    }
                }
                break;
        }

        if (daoSession != null)
            daoSession.clear();

        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    @Override
    public long searchIndexed(EntityType entityType, int value) {
        if (!initialized)
            throw new IllegalStateException("Initialize first GreenDaoBenchmarkTasks by call init()!");

        Stopwatch stopwatch = Stopwatch.createUnstarted();

        DaoSession daoSession = null;
        int size = 0;

        switch (entityType) {
            case SINGLE_TAB:
                stopwatch.start();
                daoSession = getDaoSession();
                SingleTableDao singleTableDao = daoSession.getSingleTableDao();
                size = singleTableDao.queryBuilder().where(SingleTableDao.Properties.SampleIntCollIndexed.eq(value)).list().size();
                break;

            case BIG_SINGLE_TAB:
                stopwatch.start();
                daoSession = getDaoSession();
                BigSingleTableDao bigSingleTableDao = daoSession.getBigSingleTableDao();
                size = bigSingleTableDao.queryBuilder().where(BigSingleTableDao.Properties.SampleIntCollIndexed.eq(value)).list().size();
                break;

            case MULTI_TAB_RELATION_TO_ONE:
                stopwatch.start();
                daoSession = getDaoSession();
                MultiTable_01Dao multiTableDao = daoSession.getMultiTable_01Dao();
                size = multiTableDao.queryBuilder().where(MultiTable_01Dao.Properties.SampleIntCollIndexed.eq(value)).list().size();
                break;

            case SINGLE_TAB_RELATION_TO_MANY:
                stopwatch.start();
                daoSession = getDaoSession();
                TableWithRelationToManyDao toManyDao = daoSession.getTableWithRelationToManyDao();
                size = toManyDao.queryBuilder().where(TableWithRelationToManyDao.Properties.SampleIntCollIndexed.eq(value)).list().size();
                break;
        }

        LogUtils.LOGD(TAG, "Found " + size + "rows.");

        if (daoSession != null)
            daoSession.clear();
        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    @Override
    public long search(EntityType entityType, String value) {
        if (!initialized)
            throw new IllegalStateException("Initialize first GreenDaoBenchmarkTasks by call init()!");

        Stopwatch stopwatch = Stopwatch.createUnstarted();

        DaoSession daoSession = null;
        int size = 0;

        switch (entityType) {
            case SINGLE_TAB:
                stopwatch.start();
                daoSession = getDaoSession();
                SingleTableDao singleTableDao = daoSession.getSingleTableDao();
                size = singleTableDao.queryBuilder().where(SingleTableDao.Properties.SampleStringColl01.like("%" + value + "%")).list().size();
                break;

            case BIG_SINGLE_TAB:
                stopwatch.start();
                daoSession = getDaoSession();
                BigSingleTableDao bigSingleTableDao = daoSession.getBigSingleTableDao();
                size = bigSingleTableDao.queryBuilder().where(BigSingleTableDao.Properties.SampleStringColl01.like("%" + value + "%")).list().size();
                break;

            case MULTI_TAB_RELATION_TO_ONE:
                stopwatch.start();
                daoSession = getDaoSession();
                MultiTable_01Dao multiTableDao = daoSession.getMultiTable_01Dao();
                size = multiTableDao.queryBuilder().where(MultiTable_01Dao.Properties.SampleStringColl01.like("%" + value + "%")).list().size();
                break;

            case SINGLE_TAB_RELATION_TO_MANY:
                stopwatch.start();
                daoSession = getDaoSession();
                TableWithRelationToManyDao toManyDao = daoSession.getTableWithRelationToManyDao();
                size = toManyDao.queryBuilder().where(TableWithRelationToManyDao.Properties.SampleStringColl01.like("%" + value + "%")).list().size();
                break;
        }

        LogUtils.LOGD(TAG, "Found " + size + "rows.");

        if (daoSession != null)
            daoSession.clear();
        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }


    private SingleTable getNewSingleTable(EntityFieldGeneratorUtils generatorUtils) {
        SingleTable singleTable = new SingleTable();
        singleTable.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        singleTable.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        singleTable.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        singleTable.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        singleTable.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        singleTable.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        singleTable.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        singleTable.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        singleTable.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        singleTable.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        singleTable.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
        singleTable.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
        singleTable.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
        singleTable.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
        singleTable.setSampleIntCollIndexed(generatorUtils.getNextUniqueRandomInt());
        return singleTable;
    }

    private BigSingleTable getNewBigSingleTable(EntityFieldGeneratorUtils generatorUtils) {
        BigSingleTable bigSingleTable = new BigSingleTable();
        bigSingleTable.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
        bigSingleTable.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
        bigSingleTable.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
        bigSingleTable.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
        bigSingleTable.setSampleIntCollIndexed(generatorUtils.getNextUniqueRandomInt());

        bigSingleTable.setExtraSmplStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl11(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl12(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl13(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl14(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl15(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl16(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl17(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl18(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl19(EntityFieldGeneratorUtils.getRandomString(20));
        bigSingleTable.setExtraSmplStringColl20(EntityFieldGeneratorUtils.getRandomString(20));

        bigSingleTable.setExtraSmplDoubleColl01(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl02(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl03(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl04(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl05(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl06(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl07(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl08(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl09(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl10(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl11(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl12(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl13(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl14(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl15(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl16(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl17(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl18(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl19(EntityFieldGeneratorUtils.getRandomDouble(20));
        bigSingleTable.setExtraSmplDoubleColl20(EntityFieldGeneratorUtils.getRandomDouble(20));

        return bigSingleTable;
    }

    private MultiTable_01 getNewMultiTableWithRelationToOne(long id, EntityFieldGeneratorUtils generatorUtils) {
        int nextUniqueRandomInt = generatorUtils.getNextUniqueRandomInt();

        MultiTable_10 multiTable_10 = new MultiTable_10(id);
        multiTable_10.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_10.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_10.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_10.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_10.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_10.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_10.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_10.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_10.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_10.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_10.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_10.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_10.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_10.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_10.setSampleIntCollIndexed(nextUniqueRandomInt);

        MultiTable_09 multiTable_09 = new MultiTable_09(id);
        multiTable_09.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_09.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_09.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_09.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_09.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_09.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_09.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_09.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_09.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_09.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_09.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_09.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_09.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_09.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_09.setSampleIntCollIndexed(nextUniqueRandomInt);
        multiTable_09.setMultiTable_10(multiTable_10);
        multiTable_09.setMultiTable_10Id(id);

        MultiTable_08 multiTable_08 = new MultiTable_08(id);
        multiTable_08.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_08.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_08.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_08.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_08.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_08.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_08.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_08.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_08.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_08.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_08.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_08.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_08.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_08.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_08.setSampleIntCollIndexed(nextUniqueRandomInt);
        multiTable_08.setMultiTable_09(multiTable_09);
        multiTable_08.setMultiTable_09Id(id);

        MultiTable_07 multiTable_07 = new MultiTable_07(id);
        multiTable_07.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_07.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_07.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_07.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_07.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_07.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_07.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_07.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_07.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_07.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_07.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_07.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_07.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_07.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_07.setSampleIntCollIndexed(nextUniqueRandomInt);
        multiTable_07.setMultiTable_08(multiTable_08);
        multiTable_07.setMultiTable_08Id(id);

        MultiTable_06 multiTable_06 = new MultiTable_06(id);
        multiTable_06.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_06.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_06.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_06.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_06.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_06.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_06.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_06.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_06.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_06.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_06.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_06.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_06.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_06.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_06.setSampleIntCollIndexed(nextUniqueRandomInt);
        multiTable_06.setMultiTable_07(multiTable_07);
        multiTable_06.setMultiTable_07Id(id);

        MultiTable_05 multiTable_05 = new MultiTable_05(id);
        multiTable_05.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_05.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_05.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_05.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_05.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_05.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_05.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_05.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_05.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_05.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_05.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_05.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_05.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_05.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_05.setSampleIntCollIndexed(nextUniqueRandomInt);
        multiTable_05.setMultiTable_06(multiTable_06);
        multiTable_05.setMultiTable_06Id(id);

        MultiTable_04 multiTable_04 = new MultiTable_04(id);
        multiTable_04.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_04.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_04.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_04.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_04.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_04.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_04.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_04.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_04.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_04.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_04.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_04.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_04.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_04.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_04.setSampleIntCollIndexed(nextUniqueRandomInt);
        multiTable_04.setMultiTable_05(multiTable_05);
        multiTable_04.setMultiTable_05Id(id);

        MultiTable_03 multiTable_03 = new MultiTable_03(id);
        multiTable_03.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_03.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_03.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_03.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_03.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_03.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_03.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_03.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_03.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_03.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_03.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_03.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_03.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_03.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_03.setSampleIntCollIndexed(nextUniqueRandomInt);
        multiTable_03.setMultiTable_04(multiTable_04);
        multiTable_03.setMultiTable_04Id(id);

        MultiTable_02 multiTable_02 = new MultiTable_02(id);
        multiTable_02.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_02.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_02.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_02.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_02.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_02.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_02.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_02.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_02.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_02.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_02.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_02.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_02.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_02.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_02.setSampleIntCollIndexed(nextUniqueRandomInt);
        multiTable_02.setMultiTable_03(multiTable_03);
        multiTable_02.setMultiTable_03Id(id);

        MultiTable_01 multiTable_01 = new MultiTable_01(id);
        multiTable_01.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_01.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_01.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_01.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_01.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_01.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_01.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_01.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_01.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_01.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        multiTable_01.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_01.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
        multiTable_01.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_01.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
        multiTable_01.setSampleIntCollIndexed(nextUniqueRandomInt);
        multiTable_01.setMultiTable_02(multiTable_02);
        multiTable_01.setMultiTable_02Id(id);

        return multiTable_01;
    }

    private TableWithRelationToMany getNewTableWithRelationToMany(long id, EntityFieldGeneratorUtils generatorUtils) {

        TableWithRelationToMany relationToMany = new TableWithRelationToMany(id);
        relationToMany.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
        relationToMany.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
        relationToMany.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
        relationToMany.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
        relationToMany.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
        relationToMany.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
        relationToMany.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
        relationToMany.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
        relationToMany.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
        relationToMany.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
        relationToMany.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
        relationToMany.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
        relationToMany.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
        relationToMany.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
        relationToMany.setSampleIntCollIndexed(generatorUtils.getNextUniqueRandomInt());

        return relationToMany;
    }

    private List<TableWithRelationToOne> getNewTableWithRelationToOneList(long parentTableID, int uniqueInt, int count) {

        List<TableWithRelationToOne> tableWithRelationToOneList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            TableWithRelationToOne relationToOne = new TableWithRelationToOne();
            relationToOne.setTableWithRelationToManyId(parentTableID);
            relationToOne.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(20));
            relationToOne.setSampleStringColl02(EntityFieldGeneratorUtils.getRandomString(20));
            relationToOne.setSampleStringColl03(EntityFieldGeneratorUtils.getRandomString(20));
            relationToOne.setSampleStringColl04(EntityFieldGeneratorUtils.getRandomString(20));
            relationToOne.setSampleStringColl05(EntityFieldGeneratorUtils.getRandomString(20));
            relationToOne.setSampleStringColl06(EntityFieldGeneratorUtils.getRandomString(20));
            relationToOne.setSampleStringColl07(EntityFieldGeneratorUtils.getRandomString(20));
            relationToOne.setSampleStringColl08(EntityFieldGeneratorUtils.getRandomString(20));
            relationToOne.setSampleStringColl09(EntityFieldGeneratorUtils.getRandomString(20));
            relationToOne.setSampleStringColl10(EntityFieldGeneratorUtils.getRandomString(20));
            relationToOne.setSampleIntColl01(EntityFieldGeneratorUtils.getRandomInt(1000));
            relationToOne.setSampleIntColl02(EntityFieldGeneratorUtils.getRandomInt(1000));
            relationToOne.setSampleRealColl01(EntityFieldGeneratorUtils.getRandomDouble(10));
            relationToOne.setSampleRealColl02(EntityFieldGeneratorUtils.getRandomDouble(10));
            relationToOne.setSampleIntCollIndexed(uniqueInt);

            tableWithRelationToOneList.add(relationToOne);
        }

        return tableWithRelationToOneList;
    }

}
