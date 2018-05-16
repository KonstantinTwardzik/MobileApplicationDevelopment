package com.example.memorygameapp;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int counter = 0;
    private int instanceNumber, prevNumber, randomNumber;
    private TextView numberView, resultView;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter++;
        instanceNumber = counter;
        numberView = findViewById(R.id.numberView);
        resultView = findViewById(R.id.statusText);
        setRandomNumber();
        if (instanceNumber > 1) {
            initLogic();
        }
    }

    protected void initLogic() {
        intent = getIntent();
        prevNumber = intent.getIntExtra("number", 0);
    }

    protected void setRandomNumber() {
        randomNumber = (int) ((Math.random()) * 9 + 1);
        numberView.setText("" + randomNumber);

    }

    protected void getDeeper(View v) {
        intent = new Intent(this, MainActivity.class);
        intent.putExtra("number", randomNumber);
        startActivityForResult(intent, 0);

    }

    protected void getHigher(View v) {
        if (instanceNumber > 1) {
            Button b = (Button) v;

            if (b.getText().toString().equals(prevNumber + "")) {
                intent.putExtra("correct", true);
                setResult(RESULT_OK, intent);
                finish();
            } else {
                intent.putExtra("correct", false);
                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }

    protected void onActivityResult(int requestCode, int resultcode, Intent intent) {
        if (intent.getBooleanExtra("correct", false)) {
            resultView.setText("Correct!");
        } else {
            resultView.setText("Incorrect!");
        }
    }

}
