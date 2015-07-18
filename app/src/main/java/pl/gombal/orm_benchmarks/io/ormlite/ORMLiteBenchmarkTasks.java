package pl.gombal.orm_benchmarks.io.ormlite;

import android.content.Context;

import com.google.common.base.Stopwatch;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import pl.gombal.orm_benchmarks.io.ORMBenchmarkTasks;
import pl.gombal.orm_benchmarks.io.ormlite.entity.BigSingleTable;
import pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_01;
import pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_02;
import pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_03;
import pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_04;
import pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_05;
import pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_06;
import pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_07;
import pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_08;
import pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_09;
import pl.gombal.orm_benchmarks.io.ormlite.entity.MultiTable_10;
import pl.gombal.orm_benchmarks.io.ormlite.entity.ORMLiteDao;
import pl.gombal.orm_benchmarks.io.ormlite.entity.SingleTable;
import pl.gombal.orm_benchmarks.io.ormlite.entity.TableWithRelationToMany;
import pl.gombal.orm_benchmarks.io.ormlite.entity.TableWithRelationToOne;
import pl.gombal.orm_benchmarks.util.DataBaseUtils;
import pl.gombal.orm_benchmarks.util.EntityFieldGeneratorUtils;

public class ORMLiteBenchmarkTasks implements ORMBenchmarkTasks {

    public static final String TAG = ORMLiteBenchmarkTasks.class.getSimpleName();

    public static final String DB_NAME = "ormlite-db";

    private boolean initialized = false;
    private ORMLiteDataBaseOpenHelper dbOpenHelper;

    @Override
    public String getName() {
        return "ORMLite";
    }

    public void init(Context context) {
        init(context, false, false);
    }

    @Override
    public void init(Context context, boolean copyDBFormAssets, boolean inMemoryDB) {
        if (copyDBFormAssets) {
            DataBaseUtils.loadDataBaseFileFomAssets(context, DB_NAME);
        }
        ORMLiteDataBaseOpenHelper.init(context, inMemoryDB);
        dbOpenHelper = ORMLiteDataBaseOpenHelper.getInstance();
        initialized = true;
    }

    @Override
    public boolean isInitialized() {
        return initialized;
    }

    @Override
    public long createDB() throws SQLException {
        if (!initialized)
            throw new IllegalStateException("Initialize first ORMLiteBenchmarkTasks by call init()!");

        Stopwatch stopwatch = Stopwatch.createStarted();

        //// TODO: 12.07.2015 Remove If not Exists statement
        ConnectionSource connectionSource = dbOpenHelper.getConnectionSource();
        TableUtils.createTableIfNotExists(connectionSource, SingleTable.class);
        TableUtils.createTableIfNotExists(connectionSource, BigSingleTable.class);
        TableUtils.createTableIfNotExists(connectionSource, MultiTable_01.class);
        TableUtils.createTableIfNotExists(connectionSource, MultiTable_02.class);
        TableUtils.createTableIfNotExists(connectionSource, MultiTable_03.class);
        TableUtils.createTableIfNotExists(connectionSource, MultiTable_04.class);
        TableUtils.createTableIfNotExists(connectionSource, MultiTable_05.class);
        TableUtils.createTableIfNotExists(connectionSource, MultiTable_06.class);
        TableUtils.createTableIfNotExists(connectionSource, MultiTable_07.class);
        TableUtils.createTableIfNotExists(connectionSource, MultiTable_08.class);
        TableUtils.createTableIfNotExists(connectionSource, MultiTable_09.class);
        TableUtils.createTableIfNotExists(connectionSource, MultiTable_10.class);
        TableUtils.createTableIfNotExists(connectionSource, TableWithRelationToMany.class);
        TableUtils.createTableIfNotExists(connectionSource, TableWithRelationToOne.class);
        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    @Override
    public long dropDB() throws SQLException {
        if (!initialized)
            throw new IllegalStateException("Initialize first ORMLiteBenchmarkTasks by call init()!");

        Stopwatch stopwatch = Stopwatch.createStarted();

        ConnectionSource connectionSource = dbOpenHelper.getConnectionSource();
        TableUtils.dropTable(connectionSource, SingleTable.class, true);
        TableUtils.dropTable(connectionSource, BigSingleTable.class, true);
        TableUtils.dropTable(connectionSource, MultiTable_01.class, true);
        TableUtils.dropTable(connectionSource, MultiTable_02.class, true);
        TableUtils.dropTable(connectionSource, MultiTable_03.class, true);
        TableUtils.dropTable(connectionSource, MultiTable_04.class, true);
        TableUtils.dropTable(connectionSource, MultiTable_05.class, true);
        TableUtils.dropTable(connectionSource, MultiTable_06.class, true);
        TableUtils.dropTable(connectionSource, MultiTable_07.class, true);
        TableUtils.dropTable(connectionSource, MultiTable_08.class, true);
        TableUtils.dropTable(connectionSource, MultiTable_09.class, true);
        TableUtils.dropTable(connectionSource, MultiTable_10.class, true);
        TableUtils.dropTable(connectionSource, TableWithRelationToMany.class, true);
        TableUtils.dropTable(connectionSource, TableWithRelationToOne.class, true);
        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    @Override
    public long insert(EntityType entityType, int num, boolean withTransaction) throws SQLException {
        if (!initialized)
            throw new IllegalStateException("Initialize first ORMLiteBenchmarkTasks by call init()!");

        Stopwatch stopwatch = Stopwatch.createUnstarted();

        EntityFieldGeneratorUtils.clearAllInstances();
        EntityFieldGeneratorUtils generatorUtils = EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.ORM_LITE_ENTITY_FIELD_GENERATOR_ID, num);

        switch (entityType) {
            case SINGLE_TAB:
                final List<SingleTable> singleTableList = new ArrayList<>();
                for (int i = 0; i < num; i++)
                    singleTableList.add(SingleTable.getNewEntityWithRandomData(generatorUtils));

                stopwatch.start();
                final Dao<SingleTable, Long> singleTableDao = new ORMLiteDao<SingleTable, Long>(SingleTable.class).getDao();
                if (withTransaction) {
                    TransactionManager.callInTransaction(dbOpenHelper.getConnectionSource(), new Callable<SingleTable>() {
                        @Override
                        public SingleTable call() throws Exception {
                            for (SingleTable table : singleTableList)
                                singleTableDao.create(table);
                            return null;
                        }
                    });
                } else {
                    for (SingleTable table : singleTableList)
                        singleTableDao.create(table);
                }
                break;

            case BIG_SINGLE_TAB:
                final List<BigSingleTable> bigSingleTableList = new ArrayList<>();
                for (int i = 0; i < num; i++)
                    bigSingleTableList.add(BigSingleTable.getNewEntityWithRandomData(generatorUtils));

                stopwatch.start();
                final Dao<BigSingleTable, Long> bigSingleTableDao = new ORMLiteDao<BigSingleTable, Long>(BigSingleTable.class).getDao();
                if (withTransaction) {
                    TransactionManager.callInTransaction(dbOpenHelper.getConnectionSource(), new Callable<BigSingleTable>() {
                        @Override
                        public BigSingleTable call() throws Exception {
                            for (BigSingleTable table : bigSingleTableList)
                                bigSingleTableDao.create(table);
                            return null;
                        }
                    });
                } else {
                    for (BigSingleTable table : bigSingleTableList)
                        bigSingleTableDao.create(table);
                }
                break;

            case MULTI_TAB_RELATION_TO_ONE:
                final List<MultiTable_01> multiTableList = new ArrayList<>();
                for (int i = 0; i < num; i++)
                    multiTableList.add(MultiTable_01.getNewEntityWithRandomData(generatorUtils));

                stopwatch.start();

                final Dao<MultiTable_01, Long> toOneDao01 = new ORMLiteDao<MultiTable_01, Long>(MultiTable_01.class).getDao();
                final Dao<MultiTable_02, Long> toOneDao02 = new ORMLiteDao<MultiTable_02, Long>(MultiTable_02.class).getDao();
                final Dao<MultiTable_03, Long> toOneDao03 = new ORMLiteDao<MultiTable_03, Long>(MultiTable_03.class).getDao();
                final Dao<MultiTable_04, Long> toOneDao04 = new ORMLiteDao<MultiTable_04, Long>(MultiTable_04.class).getDao();
                final Dao<MultiTable_05, Long> toOneDao05 = new ORMLiteDao<MultiTable_05, Long>(MultiTable_05.class).getDao();
                final Dao<MultiTable_06, Long> toOneDao06 = new ORMLiteDao<MultiTable_06, Long>(MultiTable_06.class).getDao();
                final Dao<MultiTable_07, Long> toOneDao07 = new ORMLiteDao<MultiTable_07, Long>(MultiTable_07.class).getDao();
                final Dao<MultiTable_08, Long> toOneDao08 = new ORMLiteDao<MultiTable_08, Long>(MultiTable_08.class).getDao();
                final Dao<MultiTable_09, Long> toOneDao09 = new ORMLiteDao<MultiTable_09, Long>(MultiTable_09.class).getDao();
                final Dao<MultiTable_10, Long> toOneDao10 = new ORMLiteDao<MultiTable_10, Long>(MultiTable_10.class).getDao();

                if (withTransaction) {
                    TransactionManager.callInTransaction(dbOpenHelper.getConnectionSource(), new Callable<MultiTable_01>() {
                        @Override
                        public MultiTable_01 call() throws Exception {
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

                                toOneDao10.create(table10);
                                toOneDao09.create(table09);
                                toOneDao08.create(table08);
                                toOneDao07.create(table07);
                                toOneDao06.create(table06);
                                toOneDao05.create(table05);
                                toOneDao04.create(table04);
                                toOneDao03.create(table03);
                                toOneDao02.create(table02);
                                toOneDao01.create(table01);
                            }
                            return null;
                        }
                    });
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

                        toOneDao10.create(table10);
                        toOneDao09.create(table09);
                        toOneDao08.create(table08);
                        toOneDao07.create(table07);
                        toOneDao06.create(table06);
                        toOneDao05.create(table05);
                        toOneDao04.create(table04);
                        toOneDao03.create(table03);
                        toOneDao02.create(table02);
                        toOneDao01.create(table01);
                    }
                }
                break;

            case SINGLE_TAB_RELATION_TO_MANY:
                final List<TableWithRelationToMany> toManyList = new ArrayList<>();
                final List<TableWithRelationToOne> toOneList = new ArrayList<>();
                EntityFieldGeneratorUtils generatorUtilsToOne =
                        EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.ORM_LITE_ENTITY_FIELD_GENERATOR_ID + 50, generatorUtils.getUniqueNumberRange() * 10);
                for (int i = 0; i < num; i++) {
                    TableWithRelationToMany toMany = TableWithRelationToMany.getNewEntityWithRandomData(generatorUtils);
                    toManyList.add(toMany);
                    for (int j = 0; j < 10; j++) {
                        toOneList.add(TableWithRelationToOne.getNewEntityWithRandomData(toMany, generatorUtilsToOne));
                    }
                }

                stopwatch.start();
                final Dao<TableWithRelationToMany, Long> toManyDao = new ORMLiteDao<TableWithRelationToMany, Long>(TableWithRelationToMany.class).getDao();
                final Dao<TableWithRelationToOne, Long> toOneDao = new ORMLiteDao<TableWithRelationToOne, Long>(TableWithRelationToOne.class).getDao();
                if (withTransaction) {
                    TransactionManager.callInTransaction(dbOpenHelper.getConnectionSource(), new Callable<TableWithRelationToMany>() {
                        @Override
                        public TableWithRelationToMany call() throws Exception {
                            for (TableWithRelationToMany table : toManyList)
                                toManyDao.create(table);
                            for (TableWithRelationToOne toOne : toOneList)
                                toOneDao.create(toOne);
                            return null;
                        }
                    });
                } else {
                    for (TableWithRelationToMany table : toManyList)
                        toManyDao.create(table);
                    for (TableWithRelationToOne toOne : toOneList)
                        toOneDao.create(toOne);
                }
                break;
        }

        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    @Override
    public long update(EntityType entityType, int num, boolean withTransaction) throws SQLException {
        if (!initialized)
            throw new IllegalStateException("Initialize first ORMLiteBenchmarkTasks by call init()!");
        Stopwatch stopwatch = Stopwatch.createUnstarted();

        switch (entityType) {
            case SINGLE_TAB:
                final List<SingleTable> singleTableList = getSingleTableList(num);

                stopwatch.start();
                final Dao<SingleTable, Long> singleTableDao = new ORMLiteDao<SingleTable, Long>(SingleTable.class).getDao();
                if (withTransaction) {
                    TransactionManager.callInTransaction(dbOpenHelper.getConnectionSource(), new Callable<SingleTable>() {
                        @Override
                        public SingleTable call() throws Exception {
                            for (SingleTable table : singleTableList)
                                singleTableDao.update(table);
                            return null;
                        }
                    });
                } else {
                    for (SingleTable table : singleTableList)
                        singleTableDao.update(table);
                }
                break;

            case BIG_SINGLE_TAB:
                List<BigSingleTable> bigSingleTableList = getBigSingleTableList(num);

                stopwatch.start();

                break;

            case MULTI_TAB_RELATION_TO_ONE:
                List<MultiTable_01> multiTableList = getMultiTableList(num);

                stopwatch.start();

                break;

            case SINGLE_TAB_RELATION_TO_MANY:
                List<TableWithRelationToMany> toManyList = getTableToManyList(num);

                stopwatch.start();

                break;
        }

        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    @Override
    public long selectAll(EntityType entityType, boolean lazy) throws SQLException {
        return 0;
    }

    @Override
    public long searchIndexed(EntityType entityType, int value) throws SQLException {
        return 0;
    }

    @Override
    public long search(EntityType entityType, String value) throws SQLException {
        return 0;
    }

    private List<SingleTable> getSingleTableList(long num) throws SQLException {
        Dao<SingleTable, Long> dao = new ORMLiteDao<SingleTable, Long>(SingleTable.class).getDao();
        List<SingleTable> tableList = dao.queryBuilder().limit(num).query();
        for (SingleTable table : tableList) {
            table.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(10));
        }
        return tableList;
    }

    private List<BigSingleTable> getBigSingleTableList(long num) throws SQLException {
        Dao<BigSingleTable, Long> dao = new ORMLiteDao<BigSingleTable, Long>(BigSingleTable.class).getDao();
        List<BigSingleTable> tableList = dao.queryBuilder().limit(num).query();
        for (BigSingleTable table : tableList) {
            table.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(10));
        }
        return tableList;
    }

    private List<MultiTable_01> getMultiTableList(long num) throws SQLException {
        Dao<MultiTable_01, Long> dao = new ORMLiteDao<MultiTable_01, Long>(MultiTable_01.class).getDao();
        List<MultiTable_01> tableList = dao.queryBuilder().limit(num).query();
        for (MultiTable_01 table : tableList) {
            MultiTable_02 table02 = table.getMultiTable_02();
            MultiTable_03 table03 = table02.getMultiTable_03();
            MultiTable_04 table04 = table03.getMultiTable_04();
            MultiTable_05 table05 = table04.getMultiTable_05();
            MultiTable_06 table06 = table05.getMultiTable_06();
            MultiTable_07 table07 = table06.getMultiTable_07();
            MultiTable_08 table08 = table07.getMultiTable_08();
            MultiTable_09 table09 = table08.getMultiTable_09();
            MultiTable_10 table10 = table09.getMultiTable_10();

            table.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(10));
            table02.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(10));
            table03.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(10));
            table04.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(10));
            table05.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(10));
            table06.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(10));
            table07.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(10));
            table08.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(10));
            table09.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(10));
            table10.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(10));
        }
        return tableList;
    }

    private List<TableWithRelationToMany> getTableToManyList(long num) throws SQLException {
        Dao<TableWithRelationToMany, Long> dao = new ORMLiteDao<TableWithRelationToMany, Long>(TableWithRelationToMany.class).getDao();
        List<TableWithRelationToMany> tableList = dao.queryBuilder().limit(num).query();
        for (TableWithRelationToMany table : tableList) {
            table.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(10));
            for (TableWithRelationToOne tableToOne : table.getTableWithRelationToOneList())
                tableToOne.setSampleStringColl01(EntityFieldGeneratorUtils.getRandomString(10));
        }
        return tableList;
    }
}
