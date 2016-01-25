package pl.gombal.orm_benchmarks.io.sugarorm;


import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.common.base.Stopwatch;
import com.orm.SchemaGenerator;
import com.orm.SugarContext;
import com.orm.SugarTransactionHelper;
import com.orm.query.Condition;
import com.orm.query.Select;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import pl.gombal.orm_benchmarks.io.sqlite.DataBaseOpenHelper;
import pl.gombal.orm_benchmarks.io.sugarorm.entity.BigSingleTable;
import pl.gombal.orm_benchmarks.io.sugarorm.entity.MultiTable_01;
import pl.gombal.orm_benchmarks.io.sugarorm.entity.MultiTable_02;
import pl.gombal.orm_benchmarks.io.sugarorm.entity.MultiTable_03;
import pl.gombal.orm_benchmarks.io.sugarorm.entity.MultiTable_04;
import pl.gombal.orm_benchmarks.io.sugarorm.entity.MultiTable_05;
import pl.gombal.orm_benchmarks.io.sugarorm.entity.MultiTable_06;
import pl.gombal.orm_benchmarks.io.sugarorm.entity.MultiTable_07;
import pl.gombal.orm_benchmarks.io.sugarorm.entity.MultiTable_08;
import pl.gombal.orm_benchmarks.io.sugarorm.entity.MultiTable_09;
import pl.gombal.orm_benchmarks.io.sugarorm.entity.MultiTable_10;
import pl.gombal.orm_benchmarks.io.sugarorm.entity.SingleTable;
import pl.gombal.orm_benchmarks.io.sugarorm.entity.TableWithRelationToMany;
import pl.gombal.orm_benchmarks.io.sugarorm.entity.TableWithRelationToOne;
import pl.gombal.orm_benchmarks.io.util.DataBaseUtils;
import pl.gombal.orm_benchmarks.io.util.EntityFieldGeneratorUtils;
import pl.gombal.orm_benchmarks.task.ORMBenchmarkTasks;
import pl.gombal.orm_benchmarks.util.LogUtils;

public class SugarORMBenchmarkTask implements ORMBenchmarkTasks {

    public static final String TAG = SugarORMBenchmarkTask.class.getSimpleName();

    public static final String DB_NAME = "sugarorm-db";

    private Context context;

    private SchemaGenerator schemaGenerator;
    private SQLiteOpenHelper dbOpenHelper;
    private boolean initialized = false;

    @Override
    public String getName() {
        return "SugarORM";
    }

    public void init(Context context) {
        init(context, false, false);
    }

    @Override
    public void init(Context context, boolean copyDBFormAssets, boolean inMemoryDB) {
        if (copyDBFormAssets)
            DataBaseUtils.loadDataBaseFileFomAssets(context, DB_NAME);

        this.context = context;
        SugarContext.init(context.getApplicationContext());
        schemaGenerator = new SchemaGenerator(context);
        dbOpenHelper = new DataBaseOpenHelper(context, DB_NAME, 1, inMemoryDB);
        initialized = true;
    }

    @Override
    public boolean isInitialized() {
        return initialized;
    }

    @Override
    public long createDB() throws SQLException {
        if (!initialized)
            throw new IllegalStateException("Initialize first SugarORMBenchmarkTask by call init()!");

        Stopwatch stopwatch = Stopwatch.createStarted();
        schemaGenerator.createDatabase(dbOpenHelper.getWritableDatabase());
        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    @Override
    public long dropDB() throws SQLException {
        if (!initialized)
            throw new IllegalStateException("Initialize first SugarORMBenchmarkTask by call init()!");

        Stopwatch stopwatch = Stopwatch.createStarted();
        schemaGenerator.deleteTables(dbOpenHelper.getWritableDatabase());

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
            throw new IllegalStateException("Initialize first SugarORMBenchmarkTask by call init()!");

        Stopwatch stopwatch = Stopwatch.createUnstarted();

        EntityFieldGeneratorUtils generatorUtils = null;
        if (!update) {
            EntityFieldGeneratorUtils.clearAllInstances();
            generatorUtils = EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.SUGAR_ORM_ENTITY_FIELD_GENERATOR_ID, num);
        }

        switch (entityType) {
            case SINGLE_TAB:
                List<SingleTable> singleTableList = new ArrayList<>();
                if (!update) {
                    for (int i = 0; i < num; i++)
                        singleTableList.add(SingleTable.getNewEntityWithRandomData(generatorUtils));
                } else {
                    singleTableList = SugarORMBenchmarkTaskHelper.getSingleTableListToUpdate(num);
                    if (singleTableList.size() < num)
                        throw new ExceptionInInitializerError("Number entities to update is smaller than: " + num);
                }
                final List<SingleTable> finalSingleTableList = singleTableList;

                stopwatch.start();
                if (withTransaction) {
                    SugarTransactionHelper.doInTransaction(() -> {
                        for (SingleTable table : finalSingleTableList)
                            table.save();
                    });
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
                    bigSingleTableList = SugarORMBenchmarkTaskHelper.getBigSingleTableListToUpdate(num);
                    if (bigSingleTableList.size() < num)
                        throw new ExceptionInInitializerError("Number entities to update is smaller than: " + num);
                }
                final List<BigSingleTable> finalBigSingleTableList = bigSingleTableList;

                stopwatch.start();
                if (withTransaction) {
                    SugarTransactionHelper.doInTransaction(() -> {
                        for (BigSingleTable table : finalBigSingleTableList)
                            table.save();
                    });
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
                    multiTableList = SugarORMBenchmarkTaskHelper.getMultiTableListToUpdate(num);
                    if (multiTableList.size() < num)
                        throw new ExceptionInInitializerError("Number entities to update is smaller than: " + num);
                }
                final List<MultiTable_01> finalMultiTableList = multiTableList;

                stopwatch.start();
                if (withTransaction) {
                    SugarTransactionHelper.doInTransaction(() -> {
                        for (MultiTable_01 table01 : finalMultiTableList) {
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
                            EntityFieldGeneratorUtils.getInstance(EntityFieldGeneratorUtils.SUGAR_ORM_ENTITY_FIELD_GENERATOR_ID + 50, generatorUtils.getUniqueNumberRange() * 10);
                    for (int i = 0; i < num; i++) {
                        TableWithRelationToMany toMany = TableWithRelationToMany.getNewEntityWithRandomData(generatorUtils);
                        toManyList.add(toMany);
                        for (int j = 0; j < 10; j++) {
                            toOneList.add(TableWithRelationToOne.getNewEntityWithRandomData(toMany, generatorUtilsToOne));
                        }
                    }
                } else {
                    toManyList = SugarORMBenchmarkTaskHelper.getTableToManyListToUpdate(num);
                    toOneList = SugarORMBenchmarkTaskHelper.getTableToOneListToUpdate(toManyList);
                    if (toManyList.size() < num)
                        throw new ExceptionInInitializerError("Number entities to update is smaller than: " + num);
                }
                final List<TableWithRelationToMany> finalToManyList = toManyList;
                final List<TableWithRelationToOne> finalToOneList = toOneList;


                stopwatch.start();
                if (withTransaction) {
                    SugarTransactionHelper.doInTransaction(() -> {
                        for (TableWithRelationToMany table : finalToManyList)
                            table.save();
                        for (TableWithRelationToOne table : finalToOneList)
                            table.save();
                    });
                } else {
                    for (TableWithRelationToMany table : toManyList)
                        table.save();
                    for (TableWithRelationToOne table : toOneList)
                        table.save();
                }
                break;
        }

        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    @Override
    public long selectAll(EntityType entityType, SelectionType selectionType) throws SQLException {
        if (!initialized)
            throw new IllegalStateException("Initialize first SugarORMBenchmarkTask by call init()!");

        Stopwatch stopwatch = Stopwatch.createStarted();

        switch (entityType) {
            case SINGLE_TAB:
                switch (selectionType) {
                    case WITH_LAZY_INIT:
                        return -1;
                    case WITHOUT_LAZY_INIT:
                        Select.from(SingleTable.class).list();
                        break;
                    case COUNT_ONLY:
                        Select.from(SingleTable.class).count();
                        break;
                }
                break;

            case BIG_SINGLE_TAB:
                switch (selectionType) {
                    case WITH_LAZY_INIT:
                        return -1;
                    case WITHOUT_LAZY_INIT:
                        Select.from(BigSingleTable.class).list();
                        break;
                    case COUNT_ONLY:
                        Select.from(BigSingleTable.class).count();
                        break;
                }
                break;

            case MULTI_TAB_RELATION_TO_ONE:
                switch (selectionType) {
                    case WITH_LAZY_INIT:
                        return -1;
                    case WITHOUT_LAZY_INIT:
                        Select.from(MultiTable_01.class).list();
//                        MultiTable_01.listAll(MultiTable_01.class);
                        break;
                    case COUNT_ONLY:
                        Select.from(MultiTable_01.class).count();
//                        MultiTable_01.count(MultiTable_01.class);
                        break;
                }
                break;

            case SINGLE_TAB_RELATION_TO_MANY:
                switch (selectionType) {
                    case WITH_LAZY_INIT:
                        return -1;
                    case WITHOUT_LAZY_INIT:
                        List<TableWithRelationToMany> list = Select.from(TableWithRelationToMany.class).list();
                        for (TableWithRelationToMany toMany : list)
                            toMany.getTableWithRelationToOneList();
                        break;
                    case COUNT_ONLY:
                        Select.from(TableWithRelationToMany.class).count();
                        break;
                }
                break;
        }
        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    @Override
    public long searchIndexed(EntityType entityType, int value) throws SQLException {
        return -1;
    }

    @Override
    public long search(EntityType entityType, String value) throws SQLException {
        if (!initialized)
            throw new IllegalStateException("Initialize first SugarORMBenchmarkTask by call init()!");

        long size = 0;

        Stopwatch stopwatch = Stopwatch.createStarted();
        String arg = "%" + value + "%";
        switch (entityType) {
            case SINGLE_TAB:
                size = Select.from(SingleTable.class).where(Condition.prop("SAMPLE_STRING_COLL01").like(arg)).count();
                break;
            case BIG_SINGLE_TAB:
                size = Select.from(BigSingleTable.class).where(Condition.prop("SAMPLE_STRING_COLL01").like(arg)).count();
                break;
            case MULTI_TAB_RELATION_TO_ONE:
                size = Select.from(MultiTable_01.class).where(Condition.prop("SAMPLE_STRING_COLL01").like(arg)).count();
                break;
            case SINGLE_TAB_RELATION_TO_MANY:
                size = Select.from(TableWithRelationToMany.class).where(Condition.prop("SAMPLE_STRING_COLL01").like(arg)).count();
                break;
        }
        LogUtils.LOGD(TAG, "Found " + size + "rows.");
        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }
}