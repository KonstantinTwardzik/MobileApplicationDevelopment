package com.example.silencer;

import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AudioManager mAudioManager;
    private Button btn;
    private ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAudioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        btn = findViewById(R.id.btn);
        imgView = findViewById(R.id.imageView);
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                muteOrUnmute();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                muteOrUnmute();
            }
        });

        mute();
    }

    public void muteOrUnmute() {
        int maxVol = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_RING);
        if (mAudioManager.getStreamVolume(AudioManager.STREAM_RING) > 0) {
            mute();
        } else {
            unmute(maxVol);
        }
    }

    public void mute () {
        mAudioManager.setStreamVolume(AudioManager.STREAM_RING, AudioManager.ADJUST_MUTE, 0);
        btn.setText("UNMUTE");
        imgView.setImageResource(R.drawable.ic_volume_mute_black_24dp);
    }

    public void unmute (int maxVol) {
        mAudioManager.setStreamVolume(AudioManager.STREAM_RING, maxVol, 0);
        btn.setText("MUTE");
        imgView.setImageResource(R.drawable.ic_volume_up_black_24dp);
    }
}
