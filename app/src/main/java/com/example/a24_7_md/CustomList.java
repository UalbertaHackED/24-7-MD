package com.example.a24_7_md;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<Disease> {
    private ArrayList<Disease> diseaseArrayList;
    // on below line context holds the activity context
    private Context context;

    public CustomList(Context contextPara, ArrayList<Disease> diseases) {
        super(contextPara, 0, diseases);
        this.context = contextPara;
        this.diseaseArrayList = diseases;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // get the reference to the current convertView object
        View view = convertView;

        if (view == null) {
            // check if the convertView holds nothing, then inflate the content.xml
            view = LayoutInflater.from(context).inflate(R.layout.disease_name, parent, false);
        }

        Disease disease = diseaseArrayList.get(position);
        TextView diseaseName = view.findViewById(R.id.disease_name_display);
        diseaseName.setText(disease.getName());
        return view;
    }
}
