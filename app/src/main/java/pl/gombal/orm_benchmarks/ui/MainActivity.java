package pl.gombal.orm_benchmarks.ui;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.sql.SQLException;

import pl.gombal.orm_benchmarks.R;
import pl.gombal.orm_benchmarks.io.ORMBenchmarkTasks;
import pl.gombal.orm_benchmarks.io.ormlite.ORMLiteBenchmarkTasks;
import pl.gombal.orm_benchmarks.io.sqlite.SQLiteBenchmarkTasks;
import pl.gombal.orm_benchmarks.util.LogUtils;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        deleteDatabase(SQLiteBenchmarkTasks.DB_NAME);
        new AsyncTask<Context, Void, Void>() {
            @Override
            protected Void doInBackground(Context... params) {

                ORMBenchmarkTasks benchmarkTasks = new ORMLiteBenchmarkTasks();

                Context context = params[0];
                benchmarkTasks.init(context, false, false);

                try {
                    LogUtils.LOGI("ORM BENCHMARKS", "createDB: " + benchmarkTasks.createDB());

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

//                    LogUtils.LOGI("ORM BENCHMARKS", "dropDB: " + benchmarkTasks.dropDB());

                } catch (SQLException e) {
                    e.printStackTrace();
                }
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
