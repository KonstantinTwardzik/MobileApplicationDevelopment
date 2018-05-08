package com.example.recursiononeapp;

import android.content.ComponentName;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Intent intent;
    private static int counter = 0;
    private int instanceNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter++;
        instanceNumber = counter;
        Log.i("RecursionOneApp", counter + "");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        counter--;
        Log.i("RecursionOneApp", counter + "");
    }

    public void startActivityOne(View v) {
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void startActivityTwo(View v) {
        intent = new Intent();
        intent.setAction("com.recursiontwoapp.DO_SOMETHING");
        startActivity(intent);
    }
}