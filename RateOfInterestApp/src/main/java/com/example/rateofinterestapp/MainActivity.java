package com.example.rateofinterestapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String MESSAGE = "com.example.rateofinterestapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void sendIntent(View v) {
        EditText eT = (EditText) findViewById(R.id.editText);
        String input = eT.getText().toString();
        Intent intent = new Intent(this, ViewTwo.class);
        intent.putExtra(MESSAGE, input);
        startActivity(intent);
    }
}
