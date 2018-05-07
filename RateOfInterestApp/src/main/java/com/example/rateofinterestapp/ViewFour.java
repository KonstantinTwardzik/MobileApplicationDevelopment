package com.example.rateofinterestapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ViewFour extends AppCompatActivity {

    public static final String MESSAGE = "com.example.rateofinterestapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        Intent intent = getIntent();
        String message = intent.getStringExtra(ViewThree.MESSAGE3);
        TextView tV = (TextView) findViewById(R.id.result_value);
        tV.setText(message);
    }
}
