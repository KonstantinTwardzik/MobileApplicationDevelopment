package com.example.musicserviceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startPlayerService(View v) {
        startService(new Intent(this, PlayerService.class));
    }

    public void stopPlayerService(View v) {
        stopService(new Intent(this, PlayerService.class));
    }
}
