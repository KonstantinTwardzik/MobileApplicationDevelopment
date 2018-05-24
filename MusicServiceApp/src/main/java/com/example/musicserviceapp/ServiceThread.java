package com.example.musicserviceapp;

import android.util.Log;

public class ServiceThread extends Thread {
    public void run() {
        int i = 0;
        try {
            while (!isInterrupted()) {
                i++;
                Log.d(this.getClass().getName(), "service with thread " + android.os.Process.myPid() + "-" + Thread.currentThread().getName() + ", iteration no. " + i);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
        }
    }
}
