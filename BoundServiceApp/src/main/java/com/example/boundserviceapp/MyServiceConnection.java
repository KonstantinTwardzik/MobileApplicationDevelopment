package com.example.boundserviceapp;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

public class MyServiceConnection implements ServiceConnection {
    private MainActivity activity;

    public MyServiceConnection(MainActivity activity) {
        this.activity = activity;
    }

    public void onServiceConnected(ComponentName name, IBinder binder) {
        CounterImpl c = (CounterImpl) binder;
        activity.setCounter(c);
    }

    public void onServiceDisconnected(ComponentName name) {
        activity.setCounter(null);
    }
}