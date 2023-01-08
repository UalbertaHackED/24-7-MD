package com.example.a24_7_md;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
        Intent intent = new Intent(this, DetailedView.class);
        intent.putExtra("collection", "Abdomen");
        if (v == Liver){
            intent.putExtra("document", "Liver");
        }
        else if (v == Kidney){
            intent.putExtra("document", "Kidney");
        }
        else if (v == Stomach){
            intent.putExtra("document", "Stomach");
        }
        else if (v == Spleen){
            intent.putExtra("document", "Spleen");
        }
        else if (v == Intestine){
            intent.putExtra("document", "Intestine");
        }

        startActivity(intent);


    }
}