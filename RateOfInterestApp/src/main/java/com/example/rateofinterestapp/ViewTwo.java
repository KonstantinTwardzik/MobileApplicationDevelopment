package com.example.rateofinterestapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ViewTwo extends AppCompatActivity {

    public static final String MESSAGE = "com.example.rateofinterestapp.MESSAGE";
    public static final String MESSAGE2 = "com.example.rateofinterestapp.MESSAGE2";
    public String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.MESSAGE);
    }

    protected void sendIntent(View v) {
        EditText eT = (EditText) findViewById(R.id.editText);
        String input = eT.getText().toString();
        Intent intent = new Intent(this, ViewThree.class);
        intent.putExtra(MESSAGE, message);
        intent.putExtra(MESSAGE2, input);
        startActivity(intent);
    }
}
