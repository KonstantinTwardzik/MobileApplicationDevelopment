package com.example.ShoppingListApp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoComplete1, autoComplete2, autoComplete3, autoComplete4, autoComplete5;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        autoComplete1 = findViewById(R.id.autoCompleteTextView1);
        autoComplete2 = findViewById(R.id.autoCompleteTextView2);
        autoComplete3 = findViewById(R.id.autoCompleteTextView3);
        autoComplete4 = findViewById(R.id.autoCompleteTextView4);
        autoComplete5 = findViewById(R.id.autoCompleteTextView5);

        String[] items = getResources().getStringArray(R.array.itemList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);

        autoComplete1.setAdapter(adapter);
        autoComplete2.setAdapter(adapter);
        autoComplete3.setAdapter(adapter);
        autoComplete4.setAdapter(adapter);
        autoComplete5.setAdapter(adapter);

        // Prints content into a toas
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence toastMsg = checkContent();

                if (toastMsg.toString().isEmpty()) {
                    toastMsg = "Liste ist leer!";
                }
                Toast toast = Toast.makeText(context, toastMsg, Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }

    // Checks if there is Content and organizes it for the toast
    private String checkContent () {
        String toastMsg = "";
        if (!autoComplete1.getText().toString().isEmpty()) {
            toastMsg = autoComplete1.getText().toString();
        }
        if (!autoComplete2.getText().toString().isEmpty()) {
            if (!toastMsg.toString().isEmpty()) {
                toastMsg = toastMsg + ", " + autoComplete2.getText().toString();
            } else {
                toastMsg = autoComplete2.getText().toString();
            }
        }
        if (!autoComplete3.getText().toString().isEmpty()) {
            if (!toastMsg.toString().isEmpty()) {
                toastMsg = toastMsg + ", " + autoComplete3.getText().toString();
            } else {
                toastMsg = autoComplete3.getText().toString();
            }
        }
        if (!autoComplete4.getText().toString().isEmpty()) {
            if (!toastMsg.toString().isEmpty()) {
                toastMsg = toastMsg + ", " + autoComplete4.getText().toString();
            } else {
                toastMsg = autoComplete4.getText().toString();
            }
        }
        if (!autoComplete5.getText().toString().isEmpty()) {
            if (!toastMsg.toString().isEmpty()) {
                toastMsg = toastMsg + ", " + autoComplete5.getText().toString();
            } else {
                toastMsg = autoComplete5.getText().toString();
            }
        }
        return toastMsg;
    }
}
