package com.example.boundserviceapp;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CounterImpl counter;
    private MyServiceConnection serConn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onDestroy() {
        super.onDestroy();
        if (counter != null) {
            handleUnbindService(null);
        }
    }

    public void handleBindService(View v) {
        if (serConn == null) {
            Intent newIntent = new Intent(this, BoundService.class);
            serConn = new MyServiceConnection(this);
            bindService(newIntent, serConn, Context.BIND_AUTO_CREATE);
        }
    }

    public void handleUnbindService(View v) {
        if (serConn != null) {
            unbindService(serConn);
            serConn = null;
            setCounter(null);
        }
    }

    public void handleIncrement(View view) {
        handle(1);
    }

    public void handleReset(View view) {
        handle(2);
    }

    private void handle(int function) {
        TextView tv = findViewById(R.id.textView2);
        if (counter != null) {
            int newValue;
            switch (function) {
                case 1:
                    newValue = counter.increment();
                    break;
                case 2:
                    newValue = counter.reset();
                    break;
                default:
                    return;
            }
            tv.setText("" + newValue);
        } else {
            tv.setText(R.string.msgNoOpPossible);
        }
    }

    public void setCounter(CounterImpl counter) {
        this.counter = counter;
        TextView tv = findViewById(R.id.textView1);
        if (counter != null) {
            tv.setText(R.string.msgBound);
        } else {
            tv.setText(R.string.msgUnbound);
        }
    }
}
