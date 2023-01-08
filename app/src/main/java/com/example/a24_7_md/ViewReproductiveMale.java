package com.example.a24_7_md;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ViewReproductiveMale extends AppCompatActivity {

    private Button penisButton;
    private Button testicleButton;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reproductive_male);

        penisButton = findViewById(R.id.penis_button);
        testicleButton = findViewById(R.id.testicle_button);

        penisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DetailedViewActivity.class);
                ArrayList<String> list = new ArrayList<String>();
                list.add("MaleReproductive");
                list.add("Penis");
                intent.putExtra("list", list);
                startActivity(intent);

            }
        });

        testicleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DetailedViewActivity.class);
                ArrayList<String> list = new ArrayList<String>();
                list.add("MaleReproductive");
                list.add("Testicle");
                intent.putExtra("list", list);
                startActivity(intent);
            }
        });

    }
}