package com.example.exam_sharedpreferences;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

public class MyListActivity extends ListActivity {

    private ArrayList<String> listItems;
    private ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        initHandlers();
        initAdapter();
    }

    private void initHandlers () {
        listItems = new ArrayList<String>();
    }

    private void initAdapter () {
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        setListAdapter(adapter);
    }

    public void addElement (View v) {
        adapter.add("ListItem");
    }

    public void removeElement (View v) {

    }
}
