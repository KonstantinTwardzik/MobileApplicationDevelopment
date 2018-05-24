package com.example.musicserviceapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class PlayerService extends Service {
    private MediaPlayer player;

    public IBinder onBind(Intent intent) {
        return null; // => gestarteter Service
    }

    public void onCreate() {
        player = MediaPlayer.create(this, R.raw.bolerooffire);
        player.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (player.isPlaying()) {
            player.stop();
            onCreate();
            player.start();
        } else {
            player.start();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    public void onDestroy() {
        player.stop();
    }
}

