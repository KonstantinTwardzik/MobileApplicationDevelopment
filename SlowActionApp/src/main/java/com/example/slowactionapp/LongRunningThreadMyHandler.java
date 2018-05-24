package com.example.slowactionapp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class LongRunningThreadMyHandler extends Thread {

    private long total;
    private Handler handler;
    private boolean isInterrupted;

    public LongRunningThreadMyHandler(long total, Handler handler) {
        this.total = total;
        this.handler = handler;
    }

    public void run() {
        Log.i("ThreadMyHandler", "Run executed: " + this.currentThread().getName());
        long rest = total;
        while (rest > 0) {
            long thisTime = Math.min(rest, 1000L);
            try {
                Thread.sleep(thisTime);
            } catch (Exception e) {
            }
            rest -= thisTime;
            Message message = handler.obtainMessage(); // oder new Message();
            Bundle bundle = new Bundle();
            bundle.putLong("left", rest);
            message.setData(bundle);
            handler.sendMessage(message);
            if (isInterrupted) {
                return;
            }
        }
        Message message = handler.obtainMessage(); // oder new Message();
        Bundle bundle = new Bundle();
        bundle.putLong("left", rest);
        bundle.putLong("total", total);
        message.setData(bundle);
        handler.sendMessage(message);
    }

    @Override
    public void interrupt() {
        super.interrupt();
        isInterrupted = true;
    }
}
