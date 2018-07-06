package com.example.todoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private String title, description;
    private long date;
    private int entries;
    private EditText dateET, titleET, descriptionET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dateET = findViewById(R.id.dateText);
        titleET = findViewById(R.id.titleText);
        descriptionET = findViewById(R.id.descriptionText);
    }

    private void updateStrings() {

        date = 0;
        title = titleET.getText().toString();
        description = descriptionET.getText().toString();
    }

    private void clearView() {
        dateET.setText("");
        titleET.setText("");
        descriptionET.setText("");
    }

    public void doSelect(View v) {
        SQLiteDatabase db = new DataBaseHelper(this).getReadableDatabase();

        Cursor result = db.query(DataBaseHelper.TABLE_NAME, null, null, null, null, null, DataBaseHelper.DATE_FIELD_NAME, null);

        if (result.moveToFirst()) {
            int dateIdx = result.getColumnIndex(DataBaseHelper.DATE_FIELD_NAME);
            int titleIdx = result.getColumnIndex(DataBaseHelper.TITLE_FIELD_NAME);
            int descriptionIdx = result.getColumnIndex(DataBaseHelper.DESCR_FIELD_NAME);
            do {
                date = result.getLong(dateIdx);
                title = result.getString(titleIdx);
                description = result.getString(descriptionIdx);
                //verarbeiten
                Log.d("doSelect", date + ", " + title + ", " + description);
            } while (result.moveToNext());
        }

        result.close();
        db.close();
    }

    public void doInsert (View v) {
        updateStrings();
        SQLiteDatabase db = new DataBaseHelper(this).getWritableDatabase();

        ContentValues cV = new ContentValues();
        if (date == 0) {
            cV.put(DataBaseHelper.DATE_FIELD_NAME, System.currentTimeMillis());
        } else {
            cV.put(DataBaseHelper.DATE_FIELD_NAME, (new Date(date)).toString());
        }
        cV.put(DataBaseHelper.TITLE_FIELD_NAME, title);
        cV.put(DataBaseHelper.DESCR_FIELD_NAME, description);

        db.insert(DataBaseHelper.TABLE_NAME, null, cV);

        db.close();
        clearView();
        showToast(0);
    }

    public void doDelete (View v) {
        SQLiteDatabase db = new DataBaseHelper(this).getReadableDatabase();

        entries = db.delete(DataBaseHelper.TABLE_NAME, DataBaseHelper.DATE_FIELD_NAME + " < date('now')", null);

        showToast(2);
        db.close();
    }

    public void doCount (View v) {
        SQLiteDatabase db = new DataBaseHelper(this).getReadableDatabase();

        Cursor result = db.query(DataBaseHelper.TABLE_NAME, null, null, null, null, null, DataBaseHelper.DATE_FIELD_NAME, null);
        entries = result.getCount();

        showToast(1);
        db.close();
    }

    public void doCountToday (View v) {
        SQLiteDatabase db = new DataBaseHelper(this).getReadableDatabase();

        Cursor result = db.query(DataBaseHelper.TABLE_NAME, null, null, null, null, null, DataBaseHelper.DATE_FIELD_NAME, null);

        if (result.moveToFirst()) {
            int dateIdx = result.getColumnIndex(DataBaseHelper.DATE_FIELD_NAME);
            entries = 0;
            do {
                long date = result.getLong(dateIdx);
                //todo Abfrage ist noch falsch
                if (date == System.currentTimeMillis()) {
                    entries++;
                }
            } while (result.moveToNext());
        }

        showToast(3);
        db.close();
    }

    private void showToast(int status) {
        Context context = getApplicationContext();
        CharSequence text = null;
        switch (status) {
            case 0:
                text = "Saved To-do";
                break;
            case 1:
                text = "There are " + entries + " To-do's";
                break;
            case 2:
                text = entries + " To-do's deleted";
            case 3:
                text = "There are " + entries + " To-do's today";
                break;
        }

        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    //Todo
    //Primary Key ID einbinden
    //Alle Einträge in Liste anzeigen
    //Datum richtig einbinden

}
