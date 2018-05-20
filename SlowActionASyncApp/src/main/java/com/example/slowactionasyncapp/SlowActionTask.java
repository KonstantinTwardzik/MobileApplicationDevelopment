package com.example.slowactionasyncapp;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class SlowActionTask extends AsyncTask<Long, String, String> {
    private EditText input;
    private TextView output;
    private String format;

    public SlowActionTask(EditText input, TextView output, String format)
    {
        this.input = input;
        this.output = output;
        this.format = format;
    }
    protected String doInBackground(Long... total)
    {
        Log.i("slowactioninfo", "SlowAction Task doInBackground() wurde von "+ Thread.currentThread().getName()+" aufgerufen" );
        long rest = total[total.length-1];
        while(rest > 0)
        {
            long thisTime = Math.min(rest, 1000L);
            try
            {
                Thread.sleep(thisTime);
            }
            catch(Exception e)
            {
            }
            rest -= thisTime;
            publishProgress("" + rest);
        }
        String message = String.format(format, total[total.length - 1]);
        return message;
    }
    protected void onProgressUpdate(String... message)
    {
        Log.i("slowactioninfo", "SlowAction Task onProgressUpdate() wurde von "+ Thread.currentThread().getName()+" aufgerufen" );
        input.setText(message[message.length-1]);
    }
    protected void onPostExecute(String result)
    {
        Log.i("slowactioninfo", "SlowAction Task onPostExecute() wurde von "+ Thread.currentThread().getName()+" aufgerufen" );
        output.setText(result);
    }
}
