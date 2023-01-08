package com.example.a24_7_md;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private Switch genderSwitch;

    private Button headButton;
    private Button neckButton;
    private Button handButton;
    private Button armButton;
    private Button legButton;
    private Button kneeButton;
    private Button footButton;
    private Button chestButton;
    private Button abdomenButton;
    private Button reproductiveButton;
    private ImageView maleWholeBody;
    private ImageView femaleWholeBody;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing the switch and buttons
        genderSwitch = findViewById(R.id.gender_switch);
        headButton = findViewById(R.id.head_button);
        neckButton = findViewById(R.id.neck_button);
        handButton = findViewById(R.id.head_button);
        armButton = findViewById(R.id.arm_button);
        legButton = findViewById(R.id.leg_button);
        kneeButton = findViewById(R.id.knee_button);
        footButton = findViewById(R.id.foot_button);
        chestButton = findViewById(R.id.chest_button);
        abdomenButton = findViewById(R.id.abdomen_button);
        reproductiveButton = findViewById(R.id.reproductive_button);
        maleWholeBody = findViewById(R.id.male_whole);
        femaleWholeBody = findViewById(R.id.female_whole);

        // switch effect, with different gender picture showing
        // false = male ; true = female
        // initially, the default mode will be male
        genderSwitch.setChecked(false);
        maleWholeBody.setVisibility(View.VISIBLE);
        genderSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean switchState = genderSwitch.isChecked();
                if(switchState){
                    maleWholeBody.setVisibility(View.GONE);
                    femaleWholeBody.setVisibility(View.VISIBLE);
                } else {
                    maleWholeBody.setVisibility(View.VISIBLE);
                    femaleWholeBody.setVisibility(View.GONE);
                }
            }
        });

        // passing data directly to show top common disease activity
        // collection name (other)  & document name (neck, foot, hand, arm, knee, leg)
        neckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailedViewActivity.class);
//                String[] list = new String[2];
                ArrayList<String> list = new ArrayList<>();
                list.add("Others");
                list.add("Neck");
                intent.putExtra("list", list);
                startActivity(intent);
            }
        });

        footButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailedViewActivity.class);
                ArrayList<String> list = new ArrayList<String>();
                list.add("Others");
                list.add("Feet");
                intent.putExtra("list", list);
                startActivity(intent);
            }
        });

        handButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailedViewActivity.class);
                ArrayList<String> list = new ArrayList<String>();
                list.add("Others");
                list.add("Hand");
                intent.putExtra("list", list);
                startActivity(intent);
            }
        });

        armButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailedViewActivity.class);
                ArrayList<String> list = new ArrayList<String>();
                list.add("Others");
                list.add("Arm");
                intent.putExtra("list", list);
                startActivity(intent);
            }
        });

        kneeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailedViewActivity.class);
                ArrayList<String> list = new ArrayList<String>();
                list.add("Others");
                list.add("Knee");
                intent.putExtra("list", list);
                startActivity(intent);
            }
        });

        legButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailedViewActivity.class);
                ArrayList<String> list = new ArrayList<String>();
                list.add("Others");
                list.add("leg");
                intent.putExtra("list", list);
                startActivity(intent);
            }
        });

        // passing data to show more clickable node for user to choose
        // Abdomen, Chest, Head, reproductive

        abdomenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewAbdomen.class);
                startActivity(intent);
            }
        });

        chestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewChestActivity.class);
                startActivity(intent);
            }
        });

        headButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewHeadActivity.class);
                startActivity(intent);
            }
        });

        reproductiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean genderIdentifier = genderSwitch.isChecked();
                Intent intent;
                if(genderIdentifier) {
                    intent = new Intent(MainActivity.this, ViewReproductiveFemale.class);
                } else{
                    intent = new Intent(MainActivity.this, ViewReproductiveMale.class);
                }
                startActivity(intent);
            }
        });


    }

}




