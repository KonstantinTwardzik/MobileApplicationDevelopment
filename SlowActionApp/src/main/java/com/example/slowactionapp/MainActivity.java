package com.example.slowactionapp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText input;
    TextView output;
    String s;
    Long total;
    String format, message;
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Main", "Created");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText) findViewById(R.id.input);
        output = (TextView) findViewById(R.id.output);
        format = getString(R.string.SuccessMessage);
    }

    @Override
    protected void onResume() {
        Log.i("Main", "Resumed");
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        Log.i("Main", "Destroyed");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.i("Main", "Paused");
        thread.interrupt();
        super.onPause();
    }

    public void getTime() {
        s = input.getText().toString();
    }

    public void parseTime() {
        total = Long.parseLong(s);
        if (total < 0) {
            throw new NumberFormatException();
        }
    }

    public void showError(Exception e) {
        message = getString(R.string.FailureMessage) + " " + e.getMessage();
        output.setText(message);
    }

    public void post(View v) {
        Log.i("Main", "Post Clicked");
        getTime();
        try {
            parseTime();
            Handler handler = new Handler();
            thread = new LongRunningThreadHandler(total, input, output, handler, format);
            thread.start();
        } catch (Exception e) {
            showError(e);
        }
    }

    public void sendmessage(View v) {
        Log.i("Main", "SendMessage Clicked");
        getTime();
        try {
            parseTime();
            MyHandler myHandler = new MyHandler(input, output, format);
            thread = new LongRunningThreadMyHandler(total, myHandler);
            thread.start();
        } catch (Exception e) {
            showError(e);
        }
    }

    public void asynctask(View v) {
        Log.i("Main", "ASyncTask Clicked");
        getTime();
        try {
            parseTime();
            new SlowActionTask(input, output, format).execute(total);
        } catch (Exception e) {
            showError(e);
        }
    }
}

