package com.example.musicserviceapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class StartedService extends Service {
    private static int instanceCounter = 0;
    private int number;
    private ServiceThread thread;
    public StartedService()
    {
        instanceCounter++;
        number = instanceCounter;
    }
    public IBinder onBind(Intent intent)
    {
        return null; // => gestarteter Service
    }
    public void onCreate()
    {
        Log.d(this.getClass().getName(), "onCreate (" + number + " / " +
                android.os.Process.myPid() + "-" +
                Thread.currentThread().getName() + ")");
        thread = new ServiceThread();
        thread.start();
    }
    public int onStartCommand(Intent intent, int flags, int startid)
    {
        Log.d(this.getClass().getName(), "onStartCommand (" + number + " / " +
                android.os.Process.myPid() + "-" +
                Thread.currentThread().getName() + ")");
        return START_STICKY;
    }
    public void onDestroy()
    {
        Log.d(this.getClass().getName(), "onDestroy (" + number + " / " +
                android.os.Process.myPid() + "-" +
                Thread.currentThread().getName() + ")");
        thread.interrupt();
    }
}
