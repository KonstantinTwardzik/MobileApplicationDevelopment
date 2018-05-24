package com.example.slowactionapp;

import android.os.Handler;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;


public class LongRunningThreadHandler extends Thread {
    private long total;
    private EditText input;
    private TextView output;
    private String format;
    private Handler handler;
    private boolean isInterrupted;

    public LongRunningThreadHandler(long total, EditText input, TextView output, Handler handler, String format) {
        this.total = total;
        this.input = input;
        this.output = output;
        this.handler = handler;
        this.format = format;
    }

    public void run() {
        Log.i("ThreadHandler", "Run executed: " + this.currentThread().getName());
        long rest = total;
        while (rest > 0) {
            long thisTime = Math.min(rest, 1000L);
            try {
                Thread.sleep(thisTime);
            } catch (Exception e) {
            }
            rest -= thisTime;
            Request request = new Request(input, rest + "", this.currentThread().getName());
            handler.post(request);
            if(isInterrupted) {
                return;
            }
        }

        String message = String.format(format, total);
        Request request = new Request(output, message, this.currentThread().getName());
        handler.post(request);

    }

    @Override
    public void interrupt() {
        super.interrupt();
        isInterrupted = true;
    }
}

