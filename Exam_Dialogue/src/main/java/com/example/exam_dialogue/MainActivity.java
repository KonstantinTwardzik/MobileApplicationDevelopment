package com.example.exam_dialogue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button alertBtn, datePickerBtn, timePickerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initHandlers();
        initListeners();
    }

    private void initHandlers() {
        alertBtn = findViewById(R.id.alertBtn);
        datePickerBtn = findViewById(R.id.datePickerBtn);
        timePickerBtn = findViewById(R.id.timePickerBtn);
    }

    private void initListeners() {
        alertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog();
            }
        });
        datePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog();
            }
        });
        timePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog();
            }
        });
    }

    private void alertDialog() {
        MyAlertDialog mAD = new MyAlertDialog();
        mAD.show(getFragmentManager(), "Tag");
    }

    private void datePickerDialog() {
        MyDatePicker mDP = new MyDatePicker();
        mDP.show(getFragmentManager(), "Tag");
    }

    private void timePickerDialog() {
        MyTimePicker mTP = new MyTimePicker();
        mTP.show(getFragmentManager(), "Tag");
    }
}
