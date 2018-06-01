package com.example.customviewslibrary;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ToggleButton;

import java.util.ArrayList;


public class MasterToggleButton extends ToggleButton {

    ArrayList<ToggleButton> tBList;
    boolean disableSlaves;

    public MasterToggleButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        tBList = new ArrayList<>();
    }

    public MasterToggleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        tBList = new ArrayList<>();
    }

    public MasterToggleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        tBList = new ArrayList<>();
    }

    public MasterToggleButton(Context context) {
        super(context);
        tBList = new ArrayList<>();
    }

    public void addSlave(ToggleButton tB) {
        tBList.add(tB);
    }

    public void updateSlaves() {
        boolean checked = this.isChecked();
        for (int i = 0; i < tBList.size(); i++) {
            if (!disableSlaves) {
                tBList.get(i).setChecked(checked);
            }
        }
    }

    public boolean isDisableSlaves() {
        return disableSlaves;
    }

    public void setDisableSlaves(boolean disableSlaves) {
        this.disableSlaves = disableSlaves;
    }
}

