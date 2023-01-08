package com.example.a24_7_md;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ViewHeadActivity extends AppCompatActivity implements View.OnClickListener{
    private Button eye;
    private Button nose;
    private Button mouth;
    private Button ear;
    private Button brain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_head);

        eye  = findViewById(R.id.eye);
        ear = findViewById(R.id.ear);
        nose = findViewById(R.id.nose);
        mouth = findViewById(R.id.mouth);
        brain = findViewById(R.id.brain);

        eye.setOnClickListener(this);
        nose.setOnClickListener(this);
        mouth.setOnClickListener(this);
        ear.setOnClickListener(this);
        brain.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, DetailedViewActivity.class);
        intent.putExtra("collection", "Head");
        if (v == eye){
            intent.putExtra("document", "Eye");
        }
        else if (v == ear){
            intent.putExtra("document", "Ear");
        }
        else if (v == mouth){
            intent.putExtra("document", "Mouth");
        }
        else if (v == nose){
            intent.putExtra("document", "Nose");
        }
        else{
            intent.putExtra("document", "Brain");
        }
        startActivity(intent);
    }



}