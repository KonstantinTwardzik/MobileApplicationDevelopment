package com.example.flagactivityapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class StackTop extends AppCompatActivity {

    private static int COUNT;
    private int instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clear_top);
        COUNT++;
        instance = COUNT;
        Log.i("StackTopCreate", instance + "");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        COUNT--;
        instance = COUNT;
        Log.i("StackTopDestroy", instance + "");
    }

    public void stackTop(View v) {
        Intent intent = new Intent(this, StackTop.class);
        startActivity(intent);
    }

    public void clearTop(View V) {
        Intent intent = new Intent(this, ClearTop.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
