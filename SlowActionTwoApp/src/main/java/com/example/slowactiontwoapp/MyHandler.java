package com.example.slowactiontwoapp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class MyHandler extends Handler {
    private EditText input;
    private TextView output;
    private String format;
    public MyHandler(EditText input, TextView output, String format)
    {
        this.input = input;
        this.output = output;
        this.format = format;
    }
    public void handleMessage(Message message)
    {
        Log.i("slowactioninfo", "MyHandler handleMessage() wurde von "+ Thread.currentThread().getName()+" aufgerufen" );
        super.handleMessage(message);
        Bundle bundle = message.getData();
        long left = bundle.getLong("left", -1);
        long total = bundle.getLong("total", -1);
        if(left >= 0)
        {
            input.setText("" + left);
        }
        if(total >= 0)
        {
            String s = String.format(format, total);
            output.setText(s);
        }
    }
}
