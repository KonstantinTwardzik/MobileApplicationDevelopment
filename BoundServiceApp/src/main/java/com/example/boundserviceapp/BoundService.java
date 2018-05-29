package com.example.boundserviceapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class BoundService extends Service {
    private static int instanceCounter = 0;
    private int number;

    public BoundService() {
        instanceCounter++;
        number = instanceCounter;
    }

    public void onCreate() {
        Log.d(this.getClass().getName(), "onCreate");
    }

    public IBinder onBind(Intent intent) {
        Log.d(this.getClass().getName(), "onBind");
        return new CounterImpl(); // => gebundener Service
    }

    public void onDestroy() {
        Log.d(this.getClass().getName(), "onDestroy");
    }
}