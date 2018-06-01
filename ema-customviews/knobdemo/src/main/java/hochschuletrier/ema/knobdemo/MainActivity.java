package hochschuletrier.ema.knobdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import hochschuletrier.ema.customviews.Knob;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView display = (TextView) findViewById(R.id.display);

        final Knob knob = (Knob) findViewById(R.id.knob);
        knob.setOnValueChangedListener(new Knob.OnValueChangedListener() {
            @Override
            public void onValueChanged(View v, double value) {
                display.setText(String.format("%.0f %%", value * 100));
            }
        });

        display.setText(String.format("%.0f %%", knob.getValue() * 100));
    }
}
