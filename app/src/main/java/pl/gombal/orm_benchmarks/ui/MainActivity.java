package pl.gombal.orm_benchmarks.ui;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import pl.gombal.orm_benchmarks.R;
import pl.gombal.orm_benchmarks.io.ORMBenchmarkTasks;
import pl.gombal.orm_benchmarks.io.sqlite.DataBaseOpenHelper;
import pl.gombal.orm_benchmarks.io.sqlite.SQLiteBenchmarkTasks;
import pl.gombal.orm_benchmarks.util.LogUtils;


public class MainActivity extends Activity {

    DataBaseOpenHelper dataBaseOpenHelper;

//    MultiTable_10 multiTable_10;
//    MultiTable_09 multiTable_09;
//    MultiTable_08 multiTable_08;
//    MultiTable_07 multiTable_07;
//    MultiTable_06 multiTable_06;
//    MultiTable_05 multiTable_05;
//    MultiTable_04 multiTable_04;
//    MultiTable_03 multiTable_03;
//    MultiTable_02 multiTable_02;
//    MultiTable_01 multiTable_01;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        ((AppController) getApplication()).getDaoSession();



//        dataBaseOpenHelper = new DataBaseOpenHelper(this);
//        SQLiteDatabase db = dataBaseOpenHelper.getWritableDatabase();
//
//        db.execSQL("PRAGMA foreign_keys=ON;");
//        db.execSQL(new SingleTableDao().getCreateTableStatement(true));
//        db.execSQL(new SingleTableDao().getCreateIndexStatements(true)[0]);
//        db.execSQL(new BigSingleTableDao().getCreateTableStatement(true));
//        db.execSQL(new BigSingleTableDao().getCreateIndexStatements(true)[0]);
//        db.execSQL(new MultiTable_01Dao().getCreateTableStatement(true));
//        db.execSQL(new MultiTable_01Dao().getCreateIndexStatements(true)[0]);
//        db.execSQL(new MultiTable_02Dao().getCreateTableStatement(true));
//        db.execSQL(new MultiTable_02Dao().getCreateIndexStatements(true)[0]);
//        db.execSQL(new MultiTable_03Dao().getCreateTableStatement(true));
//        db.execSQL(new MultiTable_03Dao().getCreateIndexStatements(true)[0]);
//        db.execSQL(new MultiTable_04Dao().getCreateTableStatement(true));
//        db.execSQL(new MultiTable_04Dao().getCreateIndexStatements(true)[0]);
//        db.execSQL(new MultiTable_05Dao().getCreateTableStatement(true));
//        db.execSQL(new MultiTable_05Dao().getCreateIndexStatements(true)[0]);
//        db.execSQL(new MultiTable_06Dao().getCreateTableStatement(true));
//        db.execSQL(new MultiTable_06Dao().getCreateIndexStatements(true)[0]);
//        db.execSQL(new MultiTable_07Dao().getCreateTableStatement(true));
//        db.execSQL(new MultiTable_07Dao().getCreateIndexStatements(true)[0]);
//        db.execSQL(new MultiTable_08Dao().getCreateTableStatement(true));
//        db.execSQL(new MultiTable_08Dao().getCreateIndexStatements(true)[0]);
//        db.execSQL(new MultiTable_09Dao().getCreateTableStatement(true));
//        db.execSQL(new MultiTable_09Dao().getCreateIndexStatements(true)[0]);
//        db.execSQL(new MultiTable_10Dao().getCreateTableStatement(true));
//        db.execSQL(new MultiTable_10Dao().getCreateIndexStatements(true)[0]);
//        db.execSQL(new TableWithRelationToManyDao().getCreateTableStatement(true));
//        db.execSQL(new TableWithRelationToManyDao().getCreateIndexStatements(true)[0]);
//        db.execSQL(new TableWithRelationToOneDao().getCreateTableStatement(true));
//        db.execSQL(new TableWithRelationToOneDao().getCreateIndexStatements(true)[0]);
//
//        multiTable_10 = new MultiTable_10(1, "str","str","str","str","str","str","str","str","str","str", 2, 2, 3.5, 5.5, 9);
//        multiTable_09 = new MultiTable_09(1, "str","str","str","str","str","str","str","str","str","str", 2, 2, 3.5, 5.5, 9, multiTable_10);
//        multiTable_08 = new MultiTable_08(1, "str","str","str","str","str","str","str","str","str","str", 2, 2, 3.5, 5.5, 9, multiTable_09);
//        multiTable_07 = new MultiTable_07(1, "str","str","str","str","str","str","str","str","str","str", 2, 2, 3.5, 5.5, 9, multiTable_08);
//        multiTable_06 = new MultiTable_06(1, "str","str","str","str","str","str","str","str","str","str", 2, 2, 3.5, 5.5, 9, multiTable_07);
//        multiTable_05 = new MultiTable_05(1, "str","str","str","str","str","str","str","str","str","str", 2, 2, 3.5, 5.5, 9, multiTable_06);
//        multiTable_04 = new MultiTable_04(1, "str","str","str","str","str","str","str","str","str","str", 2, 2, 3.5, 5.5, 9, multiTable_05);
//        multiTable_03 = new MultiTable_03(1, "str","str","str","str","str","str","str","str","str","str", 2, 2, 3.5, 5.5, 9, multiTable_04);
//        multiTable_02 = new MultiTable_02(1, "str","str","str","str","str","str","str","str","str","str", 2, 2, 3.5, 5.5, 9, multiTable_03);
//        multiTable_01 = new MultiTable_01(1, "str","str","str","str","str","str","str","str","str","str", 2, 2, 3.5, 5.5, 9, multiTable_02);




//        ORMLiteDataBaseOpenHelper.init(this);
//        ConnectionSource connectionSource = ORMLiteDataBaseOpenHelper.getInstance().getConnectionSource();
//
//        try {
//            TableUtils.createTableIfNotExists(connectionSource, SingleTable.class);
//            TableUtils.createTableIfNotExists(connectionSource, BigSingleTable.class);
//            TableUtils.createTableIfNotExists(connectionSource, MultiTable_10.class);
//            TableUtils.createTableIfNotExists(connectionSource, MultiTable_09.class);
//            TableUtils.createTableIfNotExists(connectionSource, MultiTable_08.class);
//            TableUtils.createTableIfNotExists(connectionSource, MultiTable_07.class);
//            TableUtils.createTableIfNotExists(connectionSource, MultiTable_06.class);
//            TableUtils.createTableIfNotExists(connectionSource, MultiTable_05.class);
//            TableUtils.createTableIfNotExists(connectionSource, MultiTable_04.class);
//            TableUtils.createTableIfNotExists(connectionSource, MultiTable_03.class);
//            TableUtils.createTableIfNotExists(connectionSource, MultiTable_02.class);
//            TableUtils.createTableIfNotExists(connectionSource, MultiTable_01.class);
//            TableUtils.createTableIfNotExists(connectionSource, TableWithRelationToMany.class);
//            TableUtils.createTableIfNotExists(connectionSource, TableWithRelationToOne.class);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }






//        SingleTable singleTable = new SingleTable();
//
//        singleTable.setSampleStringColl01("123");
//        singleTable.setSampleStringColl02("123");
//        singleTable.setSampleStringColl03("123");
//        singleTable.setSampleStringColl04("123");
//        singleTable.setSampleStringColl05("123");
//        singleTable.setSampleStringColl06("123");
//        singleTable.setSampleStringColl07("123");
//        singleTable.setSampleStringColl08("123");
//        singleTable.setSampleStringColl09("123");
//        singleTable.setSampleStringColl10("123");
//
//        singleTable.save();


        deleteDatabase(SQLiteBenchmarkTasks.DB_NAME);
        new AsyncTask<Context, Void, Void>() {
            @Override
            protected Void doInBackground(Context... params) {

                SQLiteBenchmarkTasks benchmarkTasks = new SQLiteBenchmarkTasks();

                Context context = params[0];
                benchmarkTasks.init(context);

                long createTime = benchmarkTasks.createDB();
                LogUtils.LOGI("ORM BENCHMARKS", "createDB: " + createTime);

                LogUtils.LOGI("ORM BENCHMARKS", "insert to " + ORMBenchmarkTasks.EntityType.SINGLE_TAB + ": "
                        + benchmarkTasks.insert(ORMBenchmarkTasks.EntityType.SINGLE_TAB, 10, false));
                LogUtils.LOGI("ORM BENCHMARKS", "insert to " + ORMBenchmarkTasks.EntityType.BIG_SINGLE_TAB + ": "
                        + benchmarkTasks.insert(ORMBenchmarkTasks.EntityType.BIG_SINGLE_TAB, 10, false));
                LogUtils.LOGI("ORM BENCHMARKS", "insert to " + ORMBenchmarkTasks.EntityType.MULTI_TAB_RELATION_TO_ONE + ": "
                        + benchmarkTasks.insert(ORMBenchmarkTasks.EntityType.MULTI_TAB_RELATION_TO_ONE, 10, false));
                LogUtils.LOGI("ORM BENCHMARKS", "insert to " + ORMBenchmarkTasks.EntityType.SINGLE_TAB_RELATION_TO_MANY + ": "
                        + benchmarkTasks.insert(ORMBenchmarkTasks.EntityType.SINGLE_TAB_RELATION_TO_MANY, 10, false));

                LogUtils.LOGI("ORM BENCHMARKS", "update " + ORMBenchmarkTasks.EntityType.SINGLE_TAB + ": "
                        + benchmarkTasks.update(ORMBenchmarkTasks.EntityType.SINGLE_TAB, 10, false));
                LogUtils.LOGI("ORM BENCHMARKS", "update " + ORMBenchmarkTasks.EntityType.BIG_SINGLE_TAB + ": "
                        + benchmarkTasks.update(ORMBenchmarkTasks.EntityType.BIG_SINGLE_TAB, 10, false));
                LogUtils.LOGI("ORM BENCHMARKS", "update " + ORMBenchmarkTasks.EntityType.MULTI_TAB_RELATION_TO_ONE + ": "
                        + benchmarkTasks.update(ORMBenchmarkTasks.EntityType.MULTI_TAB_RELATION_TO_ONE, 10, false));
                LogUtils.LOGI("ORM BENCHMARKS", "update " + ORMBenchmarkTasks.EntityType.SINGLE_TAB_RELATION_TO_MANY + ": "
                        + benchmarkTasks.update(ORMBenchmarkTasks.EntityType.SINGLE_TAB_RELATION_TO_MANY, 10, false));

                LogUtils.LOGI("ORM BENCHMARKS", "selectAll " + ORMBenchmarkTasks.EntityType.SINGLE_TAB + ": "
                        + benchmarkTasks.selectAll(ORMBenchmarkTasks.EntityType.SINGLE_TAB, false));
                LogUtils.LOGI("ORM BENCHMARKS", "selectAll " + ORMBenchmarkTasks.EntityType.BIG_SINGLE_TAB + ": "
                        + benchmarkTasks.selectAll(ORMBenchmarkTasks.EntityType.BIG_SINGLE_TAB, false));
                LogUtils.LOGI("ORM BENCHMARKS", "selectAll " + ORMBenchmarkTasks.EntityType.MULTI_TAB_RELATION_TO_ONE + ": "
                        + benchmarkTasks.selectAll(ORMBenchmarkTasks.EntityType.MULTI_TAB_RELATION_TO_ONE, false));
                LogUtils.LOGI("ORM BENCHMARKS", "selectAll " + ORMBenchmarkTasks.EntityType.SINGLE_TAB_RELATION_TO_MANY + ": "
                        + benchmarkTasks.selectAll(ORMBenchmarkTasks.EntityType.SINGLE_TAB_RELATION_TO_MANY, false));

                LogUtils.LOGI("ORM BENCHMARKS", "searchIndex " + ORMBenchmarkTasks.EntityType.SINGLE_TAB + ": "
                        + benchmarkTasks.searchIndexed(ORMBenchmarkTasks.EntityType.SINGLE_TAB, 5));
                LogUtils.LOGI("ORM BENCHMARKS", "searchIndex " + ORMBenchmarkTasks.EntityType.BIG_SINGLE_TAB + ": "
                        + benchmarkTasks.searchIndexed(ORMBenchmarkTasks.EntityType.BIG_SINGLE_TAB, 5));
                LogUtils.LOGI("ORM BENCHMARKS", "searchIndex " + ORMBenchmarkTasks.EntityType.MULTI_TAB_RELATION_TO_ONE + ": "
                        + benchmarkTasks.searchIndexed(ORMBenchmarkTasks.EntityType.MULTI_TAB_RELATION_TO_ONE, 5));
                LogUtils.LOGI("ORM BENCHMARKS", "searchIndex " + ORMBenchmarkTasks.EntityType.SINGLE_TAB_RELATION_TO_MANY + ": "
                        + benchmarkTasks.searchIndexed(ORMBenchmarkTasks.EntityType.SINGLE_TAB_RELATION_TO_MANY, 5));

                LogUtils.LOGI("ORM BENCHMARKS", "search letter - a " + ORMBenchmarkTasks.EntityType.SINGLE_TAB + ": "
                        + benchmarkTasks.search(ORMBenchmarkTasks.EntityType.SINGLE_TAB, "a"));
                LogUtils.LOGI("ORM BENCHMARKS", "search letter - a " + ORMBenchmarkTasks.EntityType.BIG_SINGLE_TAB + ": "
                        + benchmarkTasks.search(ORMBenchmarkTasks.EntityType.BIG_SINGLE_TAB, "a"));
                LogUtils.LOGI("ORM BENCHMARKS", "search letter - a " + ORMBenchmarkTasks.EntityType.MULTI_TAB_RELATION_TO_ONE + ": "
                        + benchmarkTasks.search(ORMBenchmarkTasks.EntityType.MULTI_TAB_RELATION_TO_ONE, "a"));
                LogUtils.LOGI("ORM BENCHMARKS", "search letter - a " + ORMBenchmarkTasks.EntityType.SINGLE_TAB_RELATION_TO_MANY + ": "
                        + benchmarkTasks.search(ORMBenchmarkTasks.EntityType.SINGLE_TAB_RELATION_TO_MANY, "a"));

                long dropTime = benchmarkTasks.dropDB();
                LogUtils.LOGI("ORM BENCHMARKS", "dropDB: " + dropTime);

                return null;
            }
        }.execute(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
