package edu.uco.mcamposcardoso.p2matheus_c;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ComputeActivity extends AppCompatActivity {

    double[] dblArrNumbers = new double[2];
    static final String strNUMBERS = "numbers";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compute);

        Button add = (Button) findViewById(R.id.btnAddComputeActivity);
        Button multiply = (Button) findViewById(R.id.btnMultiplyComputeActivity);

        final EditText edtTxtNumber1 = (EditText) findViewById(R.id.edtTxtNumber1ComputeActivity);
        final EditText edtTxtNumber2 = (EditText) findViewById(R.id.edtTxtNumber2ComputeActivity);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    dblArrNumbers[0] = Double.parseDouble(edtTxtNumber1.getText().toString());
                    dblArrNumbers[1] = Double.parseDouble(edtTxtNumber2.getText().toString());
                } catch(final NumberFormatException e){
                    Toast.makeText(ComputeActivity.this, "Insert Valid Numbers", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent i = new Intent(ComputeActivity.this, AddActivity.class);
                i.putExtra(strNUMBERS, dblArrNumbers);
                startActivityForResult(i, AddActivity.intADD_REQUEST);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    dblArrNumbers[0] = Double.parseDouble(edtTxtNumber1.getText().toString());
                    dblArrNumbers[1] = Double.parseDouble(edtTxtNumber2.getText().toString());
                } catch (final NumberFormatException e) {
                    Toast.makeText(ComputeActivity.this, "Insert Valid Numbers", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent i = new Intent(ComputeActivity.this, MultiplyActivity.class);
                i.putExtra(strNUMBERS, dblArrNumbers);
                startActivityForResult(i, MultiplyActivity.intMULTIPLY_REQUEST);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                TextView txtResult = (TextView) findViewById(R.id.txtResultComputeActivity);
                txtResult.setText(data.getStringExtra(AddActivity.strADD_RESULT));
            }
        }

        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                TextView txtResult = (TextView) findViewById(R.id.txtResultComputeActivity);
                txtResult.setText(data.getStringExtra(MultiplyActivity.strMULTIPLY_RESULT));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_compute, menu);
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
