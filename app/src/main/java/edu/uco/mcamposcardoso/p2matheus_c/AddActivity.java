package edu.uco.mcamposcardoso.p2matheus_c;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity {

    double dblResult;
    static final int intADD_REQUEST = 1;
    static final String strADD_RESULT = "result_add";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Bundle extras = getIntent().getExtras();
        final double[] numbers = extras.getDoubleArray("numbers");

        TextView txtNumber1 = (TextView) findViewById(R.id.txtNumber1AddActivity);
        TextView txtNumber2 = (TextView) findViewById(R.id.txtNumber2AddActivity);
        final TextView txtResult = (TextView) findViewById(R.id.txtResultAddActivity);
        txtNumber1.setText(Double.toString(numbers[0]));
        txtNumber2.setText(Double.toString(numbers[1]));

        Button btnAdd = (Button) findViewById(R.id.btnAddAddActivity);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dblResult = numbers[0] + numbers[1];
                txtResult.setText(Double.toString(dblResult));
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra(strADD_RESULT, Double.toString(dblResult));
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add, menu);
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
