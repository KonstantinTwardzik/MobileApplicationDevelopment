package com.example.startedserviceapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class StartedService extends Service {
    private static int instanceCounter = 0;
    private int number, iterations, iterationsChecker;
    private ServiceThread thread;
    private Intent intent;
    private boolean stopThread;

    public StartedService() {
        instanceCounter++;
        number = instanceCounter;
    }

    public IBinder onBind(Intent intent) {
        return null; // => gestarteter Service
    }

    public void onCreate() {
        Log.d(this.getClass().getName(), "onCreate (" + number + " / " + android.os.Process.myPid() + "-" + Thread.currentThread().getName() + ")");

    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        iterationsChecker = intent.getExtras().getInt("iterations");
        if (iterationsChecker <= iterations) {
            stopThread = true;
        }
        iterations = iterationsChecker;

        if (thread != null) {
            Log.d(this.getClass().getName(), "onStartCommand update Service(" + number + " / " + android.os.Process.myPid() + "-" + Thread.currentThread().getName() + ")");
            thread.setIterations(iterations);
        } else {
            Log.d(this.getClass().getName(), "onStartCommand start Service(" + number + " / " + android.os.Process.myPid() + "-" + Thread.currentThread().getName() + ")");
            startService();
        }
        if (stopThread) {
            stopSelf();
        }
        //return START_STICKY;
        //return START_REDELIVER_INTENT;
        return START_NOT_STICKY;
    }

    public void startService() {
        thread = new ServiceThread(iterations);
        thread.start();
    }

    public void onDestroy() {
        Log.d(this.getClass().getName(), "onDestroy (" + number + " / " + android.os.Process.myPid() + "-" + Thread.currentThread().getName() + ")");
        thread.interrupt();
    }

}
