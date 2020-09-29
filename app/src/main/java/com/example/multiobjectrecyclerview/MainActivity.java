package com.example.multiobjectrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btnMultipleView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        btnMultipleView.setOnClickListener(this);
    }


    public void onClick(View view) {
        Log.i("INFO","INSIDE ACTIVITY MAIN ON CLICK");
        switch (view.getId()) {
            case R.id.btnMultipleView:
                Log.i("INFO","INSIDE ACTIVITY MAIN ON CLICK");
                startActivity(new Intent(MainActivity.this, MultipleViewTypeActivity.class));
                break;
        }
        Log.i("INFO","INSIDE ACTIVITY MAIN ON CLICK");

    }

    private void initView() {

        btnMultipleView = (Button) findViewById(R.id.btnMultipleView);
    }

}