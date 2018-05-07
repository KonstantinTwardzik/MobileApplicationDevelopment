package com.example.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView weight, size, calculation;
    double w, s, result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = (TextView) findViewById(R.id.weight);
        size = (TextView) findViewById(R.id.size);
        calculation = (TextView) findViewById(R.id.calculation);
    }

    protected void changeWeight(View v) {
        Intent intent = new Intent(this, EnterData.class);
        intent.putExtra("intCode", 0);
        startActivityForResult(intent, 0);
    }

    protected void changeSize(View v) {
        Intent intent = new Intent(this, EnterData.class);
        intent.putExtra("intCode", 1);
        startActivityForResult(intent, 1);
    }

    protected void onActivityResult(int requestCode, int resultcode, Intent intent) {
        String message;
        if (resultcode == RESULT_OK && requestCode == 0) {
            message = intent.getStringExtra("data");
            w = Double.parseDouble(message);
            weight.setText(message + " " + getString(R.string.kg));

        } else if (resultcode == RESULT_OK && requestCode == 1) {
            message = intent.getStringExtra("data");
            s = Double.parseDouble(message);
            size.setText(message + " " + getString(R.string.cm));
        }
        calculate();
    }

    protected void calculate() {
        if (!weight.getText().equals(getString(R.string.noWeight)) && !size.getText().equals(getString(R.string.noSize))) {
            s /= 100;
            result = w / (s*s);
            calculation.setText(getString(R.string.bmiCalculation) + " " + (int) result);
        }
    }
}
