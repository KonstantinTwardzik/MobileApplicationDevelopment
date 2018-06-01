package hochschuletrier.ema.listselectiondemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import hochschuletrier.ema.customviews.ListSelectionView;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((ListSelectionView) findViewById(R.id.listSelectionView)).setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{"ARD", "ZDF", "SWR", "arte", "3sat"}));
    }

    public void resetSelection(View v) {
        ((ListSelectionView) findViewById(R.id.listSelectionView)).resetSelection();
    }

    public void showSelection(View v) {
        Object[] selection = ((ListSelectionView) findViewById(R.id.listSelectionView)).getSelection();
        StringBuffer toastText = new StringBuffer();
        for (int i = 0; i < selection.length; i++) {
            toastText.append(selection[i].toString() + "\n");
        }
        Toast.makeText(this, toastText.toString(), Toast.LENGTH_SHORT).show();
    }
}
