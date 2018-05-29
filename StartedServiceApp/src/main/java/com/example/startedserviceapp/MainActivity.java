package com.example.startedserviceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText iterations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iterations = findViewById(R.id.iterationsET);
    }

    public void startServiceWithThread(View v) {
        Log.d(this.getClass().getName(), "starting service (" + android.os.Process.myPid() + "-" + Thread.currentThread().getName() + ")");
        int iterationsInt = Integer.parseInt(iterations.getText().toString());
        Intent intent = new Intent(this, StartedService.class);
        intent.putExtra("iterations", iterationsInt);
        startService(intent);
    }
}
