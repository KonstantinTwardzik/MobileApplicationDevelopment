package com.example.boundserviceapp;

import android.os.Binder;

public class CounterImpl extends Binder {
    private int counter;

    public int increment() {
        counter++;
        return counter;
    }

    public int reset() {
        counter = 0;
        return counter;
    }
}