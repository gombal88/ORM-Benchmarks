package pl.gombal.orm_benchmarks.io.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.common.base.Stopwatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import pl.gombal.orm_benchmarks.io.ORMBenchmarkTasks;
import pl.gombal.orm_benchmarks.io.sqlite.entity.TableWithRelationToMany;
import pl.gombal.orm_benchmarks.io.sqlite.entity.TableWithRelationToOne;
import pl.gombal.orm_benchmarks.util.DataBaseUtils;
import pl.gombal.orm_benchmarks.util.EntityFieldGeneratorUtils;

public class SQLiteBenchmarkTasks implements ORMBenchmarkTasks {

    public static final String TAG = SQLiteBenchmarkTasks.class.getSimpleName();

    public static final String DB_NAME = "sqlite-db";

    private boolean initialized = false;

    private SQLiteOpenHelper dbOpenHelper;

    @Override
    public String getName() {
        return "SQLite RAW";
    }

    @Override
    public void init(Context context, boolean copyDBFormAssets, boolean inMemoryDB) {
        if (copyDBFormAssets)
            DataBaseUtils.loadDataBaseFileFomAssets(context, DB_NAME);

        dbOpenHelper = new DataBaseOpenHelper(context, inMemoryDB);
        initialized = true;
    }

    @Override
    public boolean isInitialized() {
        return initialized;
    }

    @Override
    public long createDB() {
        if (!initialized)
            throw new IllegalStateException("Initialize first SQLiteBenchmarkTasks by call init()!");
        Stopwatch stopwatch = Stopwatch.createStarted();

        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    @Override
    public long dropDB() {
        Stopwatch stopwatch = Stopwatch.createStarted();

        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    @Override
    public long insert(EntityType entityType, int num, boolean withTransaction) {
        return 0;
    }

    @Override
    public long update(EntityType entityType, int num, boolean withTransaction) {
        return 0;
    }

    @Override
    public long selectAll(EntityType entityType, boolean lazy) {
        return 0;
    }

    @Override
    public long searchIndexed(EntityType entityType, int value) {
        return 0;
    }

    @Override
    public long search(EntityType entityType, String value) {
        return 0;
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
        relationToMany.setTableWithRelationToOneList(getNewTableWithRelationToOneList(relationToMany, 10));

        return relationToMany;
    }

    private List<TableWithRelationToOne> getNewTableWithRelationToOneList(TableWithRelationToMany parent, int count) {

        List<TableWithRelationToOne> tableWithRelationToOneList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            TableWithRelationToOne relationToOne = new TableWithRelationToOne();
            relationToOne.setTableWithRelationToMany(parent);
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
            relationToOne.setSampleIntCollIndexed(parent.getSampleIntCollIndexed());

            tableWithRelationToOneList.add(relationToOne);
        }

        return tableWithRelationToOneList;
    }
}
