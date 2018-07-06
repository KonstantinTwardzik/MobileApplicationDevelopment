package com.example.customviewslibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

public class NumPad extends GridLayout {

    public interface OnNumClickListener {
        void onNumClick(View v, char num);
    }

    private OnNumClickListener oNCL = null;

    public void setOnNumClickListener(OnNumClickListener oNCL2) {
        this.oNCL = oNCL2;
    }

    public void setValue(View v) {
        Button btn = (Button) v;
        oNCL.onNumClick(btn, btn.getText().charAt(0));
    }

    public NumPad(Context context) {
        super(context);
        setup();
    }

    public NumPad(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public NumPad(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    public NumPad(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setup();
    }

    private void setup() {
        inflate(getContext(), R.layout.view_numpad, this);
        final Button zero = findViewById(R.id.zero);
        final Button dot = findViewById(R.id.dot);
        final Button one = findViewById(R.id.one);
        final Button two = findViewById(R.id.two);
        final Button three = findViewById(R.id.three);
        final Button four = findViewById(R.id.four);
        final Button five = findViewById(R.id.five);
        final Button six = findViewById(R.id.six);
        final Button seven = findViewById(R.id.seven);
        final Button eight = findViewById(R.id.eight);
        final Button nine = findViewById(R.id.nine);

        zero.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setValue(zero);
            }
        });
        dot.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setValue(dot);
            }
        });
        one.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setValue(one);
            }
        });
        two.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setValue(two);
            }
        });
        three.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setValue(three);
            }
        });
        four.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setValue(four);
            }
        });
        five.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setValue(five);
            }
        });
        six.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setValue(six);
            }
        });
        seven.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setValue(seven);
            }
        });
        eight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setValue(eight);
            }
        });
        nine.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setValue(nine);
            }
        });

        oNCL = new OnNumClickListener() {
            @Override
            public void onNumClick(View v, char num) {
                Log.d("NumPad", "onNumClick: " + num);
            }
        };

    }

}
