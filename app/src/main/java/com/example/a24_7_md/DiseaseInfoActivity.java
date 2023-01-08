package com.example.a24_7_md;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;
import java.time.temporal.Temporal;

public class DiseaseInfoActivity extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_info);

        TextView diseaseNameText = findViewById(R.id.disease_name_text);
        TextView diseaseDescriptionText = findViewById(R.id.disease_brief_description_text);
        TextView diseaseSymptom1Text = findViewById(R.id.disease_symptom1_text);
        TextView diseaseSymptom2Text = findViewById(R.id.disease_symptom2_text);
        TextView diseaseSymptom3Text = findViewById(R.id.disease_symptom3_text);
        TextView diseaseTreatment1Text = findViewById(R.id.disease_treatment1_text);
        TextView diseaseTreatment2Text = findViewById(R.id.disease_treatment2_text);
        TextView diseaseTreatment3Text = findViewById(R.id.disease_treatment3_text);



        Intent receivedIntent = getIntent();
        Disease receivedDisease = (Disease) receivedIntent.getSerializableExtra("passedDisease");

        diseaseNameText.setText(receivedDisease.getName());
        diseaseDescriptionText.setText(receivedDisease.getDescription());

        if (receivedDisease.getSymptoms().get(0) != null) {
            diseaseSymptom1Text.setText(receivedDisease.getSymptoms().get(0));
        }
        if (receivedDisease.getSymptoms().get(1) != null) {
            diseaseSymptom2Text.setText(receivedDisease.getSymptoms().get(1));
        }
        if (receivedDisease.getSymptoms().get(2) != null) {
            diseaseSymptom3Text.setText(receivedDisease.getSymptoms().get(2));
        }
        if (receivedDisease.getTreatments().get(0) != null) {
            diseaseTreatment1Text.setText(receivedDisease.getTreatments().get(0));
        }
        if (receivedDisease.getTreatments().get(1) != null) {
            diseaseTreatment2Text.setText(receivedDisease.getTreatments().get(1));
        }
        if (receivedDisease.getTreatments().get(2) != null) {
            diseaseTreatment3Text.setText(receivedDisease.getTreatments().get(2));
        }
    }


}