package com.example.a24_7_md;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewHeadActivity extends AppCompatActivity implements View.OnClickListener{
    private Button eye;
    private Button nose;
    private Button mouth;
    private Button ear;
    private Button brain;
    private ImageView headImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_head);

        eye  = findViewById(R.id.eye);
        ear = findViewById(R.id.ear);
        nose = findViewById(R.id.nose);
        mouth = findViewById(R.id.mouth);
        brain = findViewById(R.id.brain);
        headImage = findViewById(R.id.body_part);

        headImage.setVisibility(View.VISIBLE);
        eye.setOnClickListener(this);
        nose.setOnClickListener(this);
        mouth.setOnClickListener(this);
        ear.setOnClickListener(this);
        brain.setOnClickListener(this);



    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, DetailedViewActivity.class);
        ArrayList<String> list = new ArrayList<>();
        list.add("Head");
        if (v == eye){
            list.add("Eye");
        }
        else if (v == ear){
            list.add("Ear");
        }
        else if (v == mouth){
            list.add("Mouth");
        }
        else if (v == nose){
            list.add("Nose");
        }
        else{
            list.add("Brain");
        }
        intent.putExtra("list", list);
        startActivity(intent);
    }



}