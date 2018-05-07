package com.example.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EnterData extends AppCompatActivity {

    TextView tV;
    EditText eT;
    Button btn;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enterdata);
        intent = getIntent();
        int code = intent.getIntExtra("intCode", 0);
        tV = (TextView) findViewById(R.id.statusText);
        btn = (Button) findViewById(R.id.continueButton);
        eT = (EditText) findViewById(R.id.editText);

        if (code == 0) {
            tV.setText(getText(R.string.enterWeight));
        } else {
            tV.setText(getText(R.string.enterSize));
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = eT.getText().toString();
                intent.putExtra("data", input);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
