package com.example.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button b1, b2;
    TextView tV, onclickTV, onCheckedChangeTV;
    Switch swt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Aufgabe1();
        Aufgabe3();
    }

    public void Aufgabe1() {
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        tV = findViewById(R.id.textView1);

        View.OnClickListener Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tV.setText(((Button) v).getText());
            }
        };

        b1.setOnClickListener(Listener);
        b2.setOnClickListener(Listener);
    }

    public void Aufgabe3() {
        swt = findViewById(R.id.switch2);
        onclickTV = findViewById(R.id.textViewOnClick);
        onCheckedChangeTV = findViewById(R.id.textViewOnCheckedChange);

        swt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (onCheckedChangeTV.getText().equals("Aus")) {
                    onCheckedChangeTV.setText("Ein");
                } else {
                    onCheckedChangeTV.setText("Aus");
                }
            }
        });

        swt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onclickTV.getText().equals("Aus")) {
                    onclickTV.setText("Ein");
                } else {
                    onclickTV.setText("Aus");
                }
            }
        });

    }

}
