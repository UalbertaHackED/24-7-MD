package com.example.a24_7_md;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewChestActivity extends AppCompatActivity implements View.OnClickListener{
    private Button Heart;
    private Button Lung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_chest);

        Heart  = findViewById(R.id.heart);
        Lung = findViewById(R.id.lung);

        Heart.setOnClickListener(this);
        Lung.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, DetailedViewActivity.class);
        ArrayList<String> list = new ArrayList<>();
        list.add("Chest");
        if (v == Heart){
            list.add("Heart");
        }
        else{
            list.add("Lung");
        }
        intent.putExtra("list", list);
        startActivity(intent);
    }



}
