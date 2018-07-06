package com.example.speakersystemapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import com.example.customviewslibrary.MasterToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButtons();
    }

    public void initButtons() {
        final MasterToggleButton all = findViewById(R.id.all);
        final MasterToggleButton rear = findViewById(R.id.rear);
        final MasterToggleButton front = findViewById(R.id.front);
        ToggleButton frontLeft = findViewById(R.id.frontLeft);
        ToggleButton rearLeft = findViewById(R.id.rearLeft);
        ToggleButton center = findViewById(R.id.center);
        ToggleButton frontRight = findViewById(R.id.frontRight);
        ToggleButton rearRight = findViewById(R.id.rearRight);
        ToggleButton subwoofer = findViewById(R.id.subwoofer);

        all.addSlave(frontLeft);
        all.addSlave(rearLeft);
        all.addSlave(center);
        all.addSlave(frontRight);
        all.addSlave(rearRight);
        all.addSlave(subwoofer);
        rear.addSlave(rearLeft);
        rear.addSlave(rearRight);
        front.addSlave(frontLeft);
        front.addSlave(frontRight);

        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                all.updateSlaves();
            }
        });

        rear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rear.updateSlaves();
            }
        });

        front.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                front.updateSlaves();
            }
        });


    }

}
