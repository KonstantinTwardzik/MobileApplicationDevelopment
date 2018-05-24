package com.example.slowactionapp;

import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class Request implements Runnable {
    private EditText input;
    private TextView output;
    private String message, threadNo;

    public Request(EditText input, String message, String threadNo) {
        this.input = input;
        this.message = message;
        this.threadNo = threadNo;
    }

    public Request(TextView output, String message, String threadNo) {
        this.output = output;
        this.message = message;
    }

    public void run() {
        Log.i("Request", "Run executed: " + threadNo);
        if (input != null) {
            input.setText(message);
        } else if (output != null) {
            output.setText(message);
        }
    }
}
