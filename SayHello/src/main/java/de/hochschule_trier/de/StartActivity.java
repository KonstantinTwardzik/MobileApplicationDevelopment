package de.hochschule_trier.de;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import java.util.Locale;

public class StartActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private TextToSpeech tts;
    private Button rdBtn;
    private EditText eTxt;
    private Switch swLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        tts = new TextToSpeech(this, this);
        rdBtn = findViewById(R.id.btnRead);
        eTxt = findViewById(R.id.editTextToSpeech);
        swLanguage = findViewById(R.id.swLanguage);
        rdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
        swLanguage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                changeLanguage(isChecked);
            }
        });
    }

    public void changeLanguage(boolean isChecked) {
        if (isChecked == true) {
            tts.setLanguage(Locale.GERMAN);
            swLanguage.setText("Deutsch");
        } else {
            tts.setLanguage(Locale.US);
            swLanguage.setText("English");
        }

    }

    @Override
    public void onInit(int status) {
        tts.setLanguage(Locale.US);
        tts.speak("Hello World! I am ready!", TextToSpeech.QUEUE_FLUSH, null, "Test");
    }

    public void speak() {
        if (eTxt.getText().toString().isEmpty() ) {
            speakText("Please enter a text");
        } else {
            speakText(eTxt.getText().toString());
        }
    }

    public void speakText (String text) {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "Test");
    }

}
