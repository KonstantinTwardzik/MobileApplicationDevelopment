package com.example.starddialapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startDial(View v) {
        String emergency = "911";
        String uri = "tel:" + emergency.trim() ;
        Intent intent2 = new Intent(Intent.ACTION_DIAL);
        intent2.setData(Uri.parse(uri));
        startActivity(intent2);
    }
}
