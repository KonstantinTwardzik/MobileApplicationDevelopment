package com.example.exam_controls;

import android.content.Context;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private ToggleButton toggleButton;
    private Switch switch1;
    private CheckBox checkBox;
    private RadioGroup radioGroup;
    private RadioButton checkedRadioButton;
    private ImageButton imageButton;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getReferences();
        initHandling();
    }

    private void getReferences () {
        button = findViewById(R.id.button);
        toggleButton = findViewById(R.id.toggleButton);
        switch1 = findViewById(R.id.switch1);
        checkBox = findViewById(R.id.checkBox);
        radioGroup = findViewById(R.id.radioGroup);
        imageButton = findViewById(R.id.imageButton);
        editText = findViewById(R.id.editText);
    }

    private void initHandling () {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handle(0);
            }
        });
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    handle(1);
                } else {
                    handle(2);
                }
            }
        });
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    handle(3);
                } else {
                    handle(4);
                }
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    handle(5);
                } else {
                    handle(6);
                }
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                checkedRadioButton = (RadioButton)findViewById(checkedId);
                boolean isChecked = checkedRadioButton.isChecked();
                if (isChecked) {
                    handle(7);
                } else {
                    handle(8);
                }

            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handle(9);
            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                handle(10);
            }
        });
    }

    private void handle(int handleNo) {
        Context context = getApplicationContext();
        CharSequence text = "";
        int duration = Toast.LENGTH_LONG;

        switch (handleNo) {
            case 0:
                text = "Button clicked";
                break;
            case 1:
                text = "ToggleButton On";
                break;
            case 2:
                text = "ToggleButton Off";
                break;
            case 3:
                text = "Switch On";
                break;
            case 4:
                text = "Switch Off";
                break;
            case 5:
                text = "Checkbox On";
                break;
            case 6:
                text = "Checkbox Off";
                break;
            case 7:
                text = checkedRadioButton.getText().toString() + " is selected";
                break;
            case 8:
                text = "no RadioButton is selected";
                break;
            case 9:
                text = "ImageButton clicked";
                break;
            case 10:
                text = "Text changed";
                break;
        }

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
