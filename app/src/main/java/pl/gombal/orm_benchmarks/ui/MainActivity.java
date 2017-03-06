package pl.gombal.orm_benchmarks.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;

import pl.gombal.orm_benchmarks.R;
import pl.gombal.orm_benchmarks.task.BenchmarkServiceConnector;
import pl.gombal.orm_benchmarks.task.ORMBenchmarkService;
import pl.gombal.orm_benchmarks.task.ServiceMessage;


public class MainActivity extends Activity implements BenchmarkServiceConnector.BenchmarkServiceCallback {

    BenchmarkServiceConnector serviceConnection;

    private Spinner ormSpinner, selectionTypeSpinner;
    private EditText rowCountSpinner;
    private CheckBox transactionCheckbox;
    private Button startButton;
    private ProgressBar serviceProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serviceConnection = BenchmarkServiceConnector.getInstance(this);

        findViews();

        ArrayAdapter<CharSequence> ormAdapter = ArrayAdapter.createFromResource(this, R.array.orm_array, android.R.layout.simple_spinner_item);
        ormAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ormSpinner.setAdapter(ormAdapter);

        ArrayAdapter<CharSequence> selectionTypeAdapter = ArrayAdapter.createFromResource(this, R.array.selection_type_array, android.R.layout.simple_spinner_item);
        selectionTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectionTypeSpinner.setAdapter(selectionTypeAdapter);

        startButton.setOnClickListener(v -> startORMService());

    }

    private void findViews() {
        ormSpinner = (Spinner) findViewById(R.id.orm);
        rowCountSpinner = (EditText) findViewById(R.id.row_count);
        selectionTypeSpinner = (Spinner) findViewById(R.id.selection_type);
        transactionCheckbox = (CheckBox) findViewById(R.id.transaction);

        startButton = (Button) findViewById(R.id.button);

        serviceProgress = (ProgressBar) findViewById(R.id.progressBar);
    }

    private void startORMService() {
        String intentAction;
        switch (((String) ormSpinner.getSelectedItem())) {
            case "Raw SQL":
                intentAction = ServiceMessage.IntentFilers.START_BENCHMARK_SQLITE;
                break;
            case "GreenDao":
                intentAction = ServiceMessage.IntentFilers.START_BENCHMARK_GREENDAO;
                break;
            case "ORMLite":
                intentAction = ServiceMessage.IntentFilers.START_BENCHMARK_ORMLITE;
                break;
            case "ActiveAndroid":
                intentAction = ServiceMessage.IntentFilers.START_BENCHMARK_ACTIVE_ANDROID;
                break;
            case "SugarORM":
                intentAction = ServiceMessage.IntentFilers.START_BENCHMARK_SUGAR_ORM;
                break;
            default:
                intentAction = "";
        }

        String number = rowCountSpinner.getText().toString();
        int rowCount = Integer.valueOf(number.isEmpty() ? "0" : number);
        int selectionType = selectionTypeSpinner.getSelectedItemPosition();
        int transaction = transactionCheckbox.isChecked() ? 1 : 0;

        Intent serviceIntent = new Intent(this, ORMBenchmarkService.class);
        serviceIntent.setAction(intentAction);
        serviceIntent.putExtra(ServiceMessage.IntentExtrasKeys.ROW_COUNT, rowCount);
        serviceIntent.putExtra(ServiceMessage.IntentExtrasKeys.SELECTION_TYPE, selectionType);
        serviceIntent.putExtra(ServiceMessage.IntentExtrasKeys.WITH_TRANSACTION, transaction);
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
