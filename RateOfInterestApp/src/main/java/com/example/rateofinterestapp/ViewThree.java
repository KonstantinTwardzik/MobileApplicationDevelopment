package com.example.rateofinterestapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class ViewThree extends AppCompatActivity {

    public static final String MESSAGE3 = "com.example.rateofinterestapp.MESSAGE3";
    String message1, message2, result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        Intent intent = getIntent();
        message1 = intent.getStringExtra(ViewTwo.MESSAGE);
        message2 = intent.getStringExtra(ViewTwo.MESSAGE2);
    }

    protected void sendIntent(View v) {
        calculate();
        Intent intent = new Intent(this, ViewFour.class);
        intent.putExtra(MESSAGE3, result);
        startActivity(intent);
    }

    protected void calculate() {
        EditText eT = (EditText) findViewById(R.id.editText);
        String input = eT.getText().toString();

        double R, k, p, t;
        k = Double.parseDouble(message1);
        p = Double.parseDouble(message2);
        t = Double.parseDouble(input);

        R = ((k*p)/100)*t;
        result = "" + R;
    }
}
