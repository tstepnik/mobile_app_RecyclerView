package com.example.multiobjectrecyclerview;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.multiobjectrecyclerview.adapter.ItemsAdapter;
import com.example.multiobjectrecyclerview.domain.ExtraHoliday;
import com.example.multiobjectrecyclerview.domain.Items;
import com.example.multiobjectrecyclerview.domain.Note;
import com.example.multiobjectrecyclerview.domain.OrganizerItem;

import java.util.ArrayList;

public class MultipleViewTypeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    ArrayList<Items> itemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("INFO","INSIDE ACTIVITY MAIN ON CREATE IN MULTIPLEVIEWTYPEACITVITY");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_view_type);
        initView();
        Log.i("INFO","AFTER INIT VIEW");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Multiple view type");
    }

    private void initView() {
        Log.i("INFO","INSIDE INITVIEW");
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        createList();
    }

    private void createList() {
        Log.i("INFO","INSIDE CREATELIST");
        // set adapter
        ItemsAdapter adapter = new ItemsAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i("INFO","INSIDE ON OPTION SELECTED");
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
