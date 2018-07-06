package com.example.numpadtestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.customviewslibrary.NumPad;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tV = findViewById(R.id.tV);
        final NumPad numPad = findViewById(R.id.numPad);


//        Keine Ahnung warum NullPointerException - Stresst aber mega!!!

//        numPad.setOnNumClickListener(new NumPad.OnNumClickListener() {
//            @Override
//            public void onNumClick(View v, char num) {
//                tV.setText(num);
//            }
//        });
    }

}
