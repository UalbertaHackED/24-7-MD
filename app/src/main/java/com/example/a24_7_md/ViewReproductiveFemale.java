package com.example.a24_7_md;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ViewReproductiveFemale extends AppCompatActivity {

    private Button ovaryButton;
    private Button cervixButton;
    private Button uterusButton;
    private Button vaginaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_re_productive_female);

        ovaryButton = findViewById(R.id.ovary_button);
        cervixButton = findViewById(R.id.Cervix_button);
        uterusButton = findViewById(R.id.Uterus_button);
        vaginaButton = findViewById(R.id.Vagina_button);

        ovaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(this, DetailedViewActivity.class);
                ArrayList<String> list = new ArrayList<String>();
                list.add("Female reproductive");
                list.add("Ovary");
                intent.putExtra("list", list);
                startActivity(intent);
            }
        });

        cervixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(this, DetailedViewActivity.class);
                ArrayList<String> list = new ArrayList<String>();
                list.add("Female reproductive");
                list.add("Cervix");
                intent.putExtra("list", list);
                startActivity(intent);
            }
        });

        uterusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(this, DetailedViewActivity.class);
                ArrayList<String> list = new ArrayList<String>();
                list.add("Female reproductive");
                list.add("Uterus");
                intent.putExtra("list", list);
                startActivity(intent);
            }
        });

        vaginaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(this, DetailedViewActivity.class);
                ArrayList<String> list = new ArrayList<String>();
                list.add("Female reproductive");
                list.add("Vagina");
                intent.putExtra("list", list);
                startActivity(intent);
            }
        });
    }
}