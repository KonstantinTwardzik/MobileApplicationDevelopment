package com.example.exam_adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner typesSpinner;
    Spinner secondSpinner;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initHandlers();
        initListeners();
        setSecondSpinner(0);
    }

    private void initHandlers () {
        typesSpinner = findViewById(R.id.spinner);
        secondSpinner = findViewById(R.id.spinner2);
        imageView = findViewById(R.id.imageView);
    }

    private void initListeners () {
        typesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setSecondSpinner(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void fillFormulaOneSpinner () {
        ArrayAdapter<String> formulaOneSpinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        formulaOneSpinnerAdapter.add("Ferrari");
        formulaOneSpinnerAdapter.add("Mercedes");
        formulaOneSpinnerAdapter.add("Red Bull Racing");
        formulaOneSpinnerAdapter.add("Renault");
        formulaOneSpinnerAdapter.add("Haas");
        formulaOneSpinnerAdapter.add("McLaren");
        formulaOneSpinnerAdapter.add("Force India");
        formulaOneSpinnerAdapter.add("Toro Rosso");
        formulaOneSpinnerAdapter.add("Sauber");
        formulaOneSpinnerAdapter.add("williams");
        secondSpinner.setAdapter(formulaOneSpinnerAdapter);
        secondSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setFormulaOneImage(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void fillLeMansSpinner () {
        ArrayAdapter<String> formulaOneSpinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        formulaOneSpinnerAdapter.add("Rebellion Racing");
        formulaOneSpinnerAdapter.add("ByKolles");
        formulaOneSpinnerAdapter.add("CEFC TRSM Racing");
        formulaOneSpinnerAdapter.add("Toyota Gazoo Racing");
        formulaOneSpinnerAdapter.add("Dragon Speed Inc.");
        formulaOneSpinnerAdapter.add("SMP Racing");
        secondSpinner.setAdapter(formulaOneSpinnerAdapter);
        secondSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setLeMansImage(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void setSecondSpinner(int selected) {
            if (selected == 0) {
                fillFormulaOneSpinner();
            } else {
                fillLeMansSpinner();
            }
    }

    private void setFormulaOneImage(int selected) {
        switch (selected) {
            case 0:
                imageView.setImageResource(R.drawable.ferrari);
                break;
            case 1:
                imageView.setImageResource(R.drawable.mercedes);
                break;
            case 2:
                imageView.setImageResource(R.drawable.red_bull_racing);
                break;
            case 3:
                imageView.setImageResource(R.drawable.renault);
                break;
            case 4:
                imageView.setImageResource(R.drawable.haas);
                break;
            case 5:
                imageView.setImageResource(R.drawable.mclaren);
                break;
            case 6:
                imageView.setImageResource(R.drawable.force_india);
                break;
            case 7:
                imageView.setImageResource(R.drawable.torro_rosso);
                break;
            case 8:
                imageView.setImageResource(R.drawable.sauber);
                break;
            case 9:
                imageView.setImageResource(R.drawable.williams);
                break;
        }
    }

    private void setLeMansImage(int selected) {
        switch (selected) {
            case 0:
                imageView.setImageResource(R.drawable.rebellion_racing);
                break;
            case 1:
                imageView.setImageResource(R.drawable.bykolles);
                break;
            case 2:
                imageView.setImageResource(R.drawable.cefc_trsm_racing);
                break;
            case 3:
                imageView.setImageResource(R.drawable.toyota_gazoo_racing);
                break;
            case 4:
                imageView.setImageResource(R.drawable.dragon_speed_inc);
                break;
            case 5:
                imageView.setImageResource(R.drawable.smp_racing);
                break;
        }
    }
}
