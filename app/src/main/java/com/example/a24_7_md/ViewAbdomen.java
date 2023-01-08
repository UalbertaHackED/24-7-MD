package com.example.a24_7_md;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ViewAbdomen extends AppCompatActivity implements View.OnClickListener{
    private Button Liver;
    private Button Kidney;
    private Button Spleen;
    private Button Stomach;
    private Button Intestine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_abdomen);

        Liver = findViewById(R.id.liver);
        Kidney = findViewById(R.id.kidney);
        Spleen = findViewById(R.id.spleen);
        Stomach = findViewById(R.id.stomach);
        Intestine = findViewById(R.id.intestine);

        Liver.setOnClickListener(this);
        Kidney.setOnClickListener(this);
        Spleen.setOnClickListener(this);
        Stomach.setOnClickListener(this);
        Intestine.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, DetailedViewActivity.class);
        ArrayList<String> list = new ArrayList<>();
        list.add("Abdomen");
        if (v == Liver){
            list.add("Liver");
        }
        else if (v == Kidney) {
            list.add("Kidney");
        }
        else if (v == Stomach) {
            list.add("Stomach");
        }
        else if (v == Spleen){
            list.add("Spleen");
        }
        else if (v == Intestine){
            list.add("Intestine");
        }
        intent.putExtra("list", list);
        startActivity(intent);
    }
}