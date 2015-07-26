package pl.gombal.orm_benchmarks.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import pl.gombal.orm_benchmarks.R;
import pl.gombal.orm_benchmarks.task.BenchmarkServiceConnector;
import pl.gombal.orm_benchmarks.task.ORMBenchmarkService;


public class MainActivity extends Activity implements BenchmarkServiceConnector.BenchmarkServiceCallback {

    BenchmarkServiceConnector serviceConnection;

    private Button startButton;
    private ProgressBar serviceProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serviceConnection = BenchmarkServiceConnector.getInstance(this);

        startButton = (Button) findViewById(R.id.button);
        serviceProgress = (ProgressBar) findViewById(R.id.progressBar);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startORMService();
            }
        });

    }

    private void startORMService() {
        Intent serviceIntent = new Intent(this, ORMBenchmarkService.class);
        startService(serviceIntent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        serviceConnection.doBindService(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        serviceConnection.doUnbindService();
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

    @Override
    public void onBenchmarkServiceConnected() {

    }

    @Override
    public void onBenchmarkServiceDisconnected() {

    }

    @Override
    public void bindingServiceFailed() {

    }

    @Override
    public void onBenchmarkTaskStart() {
        startButton.setVisibility(View.GONE);
        serviceProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBenchmarkTaskStop() {
        startButton.setVisibility(View.VISIBLE);
        serviceProgress.setVisibility(View.GONE);
    }

    @Override
    public void onBenchmarkNotifyProgress() {

    }
}
