package com.example.MuteApp;

import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private AudioManager mAudioManager;
    private Button btn;
    private ImageView imgView;
    private int curVol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initiation
        mAudioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        btn = findViewById(R.id.btn);
        imgView = findViewById(R.id.imageView);

        // Eventhandler button
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                muteOrUnmute();
            }
        });

        updateView();
    }

    // Decides if phone is currently muted or not and calls the corresponding (mute or unmute) method
    public void muteOrUnmute() {

        if (mAudioManager.getRingerMode() == AudioManager.RINGER_MODE_SILENT)
        {
            // java.lang.SecurityException: Not allowed to change Do Not Disturb state
        } else if (mAudioManager.getRingerMode() == AudioManager.RINGER_MODE_NORMAL) {
            curVol = mAudioManager.getStreamVolume(mAudioManager.getRingerMode());
            mute();
        } else {
            unmute(curVol);
        }
    }

    // Mutes the phone
    public void mute() {
        // 1 method: sets the StreamVolume to 0
        //mAudioManager.setStreamVolume(AudioManager.STREAM_RING, AudioManager.ADJUST_MUTE, 0);

        // 2. method: sets the RingerMode to vibrate
        mAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);

        updateView();
    }

    // Unmutes the phone
    public void unmute(int curVol) {

        // 1. method: sets the StreamVolume to curVol
        //mAudioManager.setStreamVolume(AudioManager.STREAM_RING, curVol, 0);

        // 2. method: sets the RingerMode to normal
        mAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);

        updateView();
    }

    // Sets the correct image and button text
    public void updateView() {
        if (mAudioManager.getRingerMode() == AudioManager.RINGER_MODE_NORMAL){
            btn.setText(R.string.mute);
            imgView.setImageResource(R.drawable.ic_volume_up_black_24dp);
        } else {
            btn.setText(R.string.unmute);
            imgView.setImageResource(R.drawable.ic_volume_mute_black_24dp);
        }
    }
}
