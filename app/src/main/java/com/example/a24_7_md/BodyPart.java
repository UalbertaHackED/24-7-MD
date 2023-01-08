package com.example.a24_7_md;

import java.util.ArrayList;

public class BodyPart {
    private String name;
    private ArrayList<Disease> diseases;

    public BodyPart(String name, ArrayList<Disease> diseases) {
        this.name = name;
        this.diseases = diseases;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Disease> getDiseases() {
        return diseases;
    }
}
