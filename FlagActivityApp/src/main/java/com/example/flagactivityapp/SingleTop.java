package com.example.flagactivityapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class SingleTop extends AppCompatActivity {

    private static int COUNT;
    private int instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_top);
        COUNT++;
        Log.i("SingleTopCreate", COUNT + "");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        COUNT--;
        Log.i("SingleTopDestroy", COUNT + "");
    }

    public void singleTop (View V) {
        Intent intent = new Intent(this, SingleTop.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    public void clearTop (View v) {
        Intent intent = new Intent(this, SingleTop.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
