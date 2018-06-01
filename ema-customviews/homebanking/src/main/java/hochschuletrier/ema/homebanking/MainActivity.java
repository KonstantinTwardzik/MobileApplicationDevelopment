package hochschuletrier.ema.homebanking;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Variante 1 (Spinner):
        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                new String[]{"EUR (€)", "GBP (£)", "BGN (лв)", "DKK (dkr.)", "LVL (Ls)", "LTL (Lt)", "PLN (zł)", "RON (RON)", "SEK (Skr)", "CZK (Kč)", "HUF (Ft)"});
		((Spinner)findViewById(R.id.currencySpinner)).setAdapter(adapter);*/

        // Variante 2 (EUCurrencySpinner mit Getter/Setter):
        //((EUCurrencySpinner)findViewById(R.id.currencySpinner)).setIncludeUSD(true);
    }
}