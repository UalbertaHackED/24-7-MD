package com.example.a24_7_md;

import java.io.Serializable;
import java.util.ArrayList;

public class Disease implements Serializable {
    private String name;
    private String description;
    private ArrayList<String> symptoms = new ArrayList<>();
    private ArrayList<String> treatments = new ArrayList<>();
    private String reference = new String();

    public Disease(String name, String description, ArrayList<String> symptoms, ArrayList<String> treatments, String reference) {
        this.name = name;
        this.description = description;
        this.symptoms = symptoms;
        this.treatments = treatments;
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(ArrayList<String> symptoms) {
        this.symptoms = symptoms;
    }

    public void addSymptom(String symptom) {
        symptoms.add(symptom);
    }

    public ArrayList<String> getTreatments() {
        return treatments;
    }

    public void setTreatments(ArrayList<String> treatments) {
        this.treatments = treatments;
    }

    public  void addTreatment(String treatment) {
        treatments.add(treatment);
    }

    public String getReference() {
        return reference;
    }

    public void setReferences(String references) {
        this.reference = references;
    }
}