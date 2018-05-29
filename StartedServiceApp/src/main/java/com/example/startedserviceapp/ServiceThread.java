package com.example.startedserviceapp;

import android.util.Log;

public class ServiceThread extends Thread {

    int iterations;

    public ServiceThread (int iterations) {
        this.iterations = iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    public void run() {
        int i = 0;
        try {
            while (i < iterations) {
                i++;
                Log.d(this.getClass().getName(), "service with thread " + android.os.Process.myPid() + "-" + Thread.currentThread().getName() + ", iteration no. " + i);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
        }
    }
}
