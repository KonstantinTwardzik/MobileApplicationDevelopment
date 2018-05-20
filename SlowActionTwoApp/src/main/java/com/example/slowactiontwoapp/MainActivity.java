package com.example.slowactiontwoapp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clicked(View v){
        Log.i("slowactioninfo", "SlowAction2 clicked wurde von "+ Thread.currentThread().getName()+" aufgerufen" );
        EditText input = (EditText) findViewById(R.id.input);
        String s = input.getText().toString();
        TextView output = (TextView) findViewById(R.id.output);

        try
        {
            long total = Long.parseLong(s);
            if(total < 0)
            {
                throw new NumberFormatException();
            }
            String format = getString(R.string.successMessage);
            MyHandler handler = new MyHandler(input, output, format);
            Thread t = new LongRunningThread(total, handler);
            t.start();
        }
        catch(Exception e)
        {
            String message = getString(R.string.failureMessage) + " " + e.getMessage();
            output.setText(message);
        }
    }
}
