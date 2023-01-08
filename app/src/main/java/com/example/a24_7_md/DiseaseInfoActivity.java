package com.example.a24_7_md;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.time.temporal.Temporal;
import java.util.ArrayList;

public class DiseaseInfoActivity extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_info);

        TextView diseaseNameText = findViewById(R.id.disease_name_text);
        TextView diseaseSymptomText = findViewById(R.id.disease_symptoms_text);
        TextView diseaseDescriptionText = findViewById(R.id.disease_info_text);
        TextView diseaseTreatmentText = findViewById(R.id.disease_treatments_text);
        TextView diseaseURLText = findViewById(R.id.disease_url_text);

        Intent receivedIntent = getIntent();
        Disease receivedDisease = (Disease) receivedIntent.getSerializableExtra("passedDisease");

        ArrayList<String> diseaseSymptoms = (ArrayList<String>) receivedDisease.getSymptoms();
        ArrayList<String> diseaseTreatments = (ArrayList<String>) receivedDisease.getTreatments();

        String symptomStr = "";
        String treatmentStr = "";

        for (int i = 0; i < diseaseSymptoms.size(); i++) {
            symptomStr += diseaseSymptoms.get(i) + "\n";
        }

        for (int i = 0; i < diseaseTreatments.size(); i++) {
            treatmentStr += diseaseTreatments.get(i) + "\n";
        }

        diseaseNameText.setText(receivedDisease.getName());
        diseaseDescriptionText.setText(receivedDisease.getDescription());
        diseaseSymptomText.setText(symptomStr);
        diseaseTreatmentText.setText(treatmentStr);
        diseaseURLText.setText(receivedDisease.getReference());

        diseaseURLText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(receivedDisease.getReference()));
                startActivity(i);
            }
        });

    }


}