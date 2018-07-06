package com.example.customviewslibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ToggleButton;

import java.util.ArrayList;


public class MasterToggleButton extends ToggleButton {

    ArrayList<ToggleButton> tBList;
    boolean disableSlaves;

    public MasterToggleButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        parseAttributes(attrs);
        tBList = new ArrayList<>();
    }

    public MasterToggleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        parseAttributes(attrs);
        tBList = new ArrayList<>();
    }

    public MasterToggleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        parseAttributes(attrs);
        tBList = new ArrayList<>();
    }

    public MasterToggleButton(Context context) {
        super(context);
        tBList = new ArrayList<>();
    }

    private void parseAttributes (AttributeSet attrs) {
        TypedArray result = getContext().obtainStyledAttributes(attrs, R.styleable.disableSlaves);
        disableSlaves = result.getBoolean(R.styleable.disableSlaves_disableSlaves, disableSlaves);
    }

    public void addSlave(ToggleButton tB) {
        tBList.add(tB);
        if (disableSlaves) {
            tB.setClickable(false);
        }
    }

    public void updateSlaves() {
        boolean checked = this.isChecked();
        for (int i = 0; i < tBList.size(); i++) {
            tBList.get(i).setChecked(checked);
        }
    }

    public boolean getDisableSlaves() {
        return disableSlaves;
    }

    public void setDisableSlaves(boolean disableSlaves) {
        this.disableSlaves = disableSlaves;
    }
}

