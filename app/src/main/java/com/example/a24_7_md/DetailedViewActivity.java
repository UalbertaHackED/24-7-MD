package com.example.a24_7_md;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class DetailedViewActivity extends AppCompatActivity implements Serializable {
    public FirebaseFirestore db = FirebaseFirestore.getInstance();
    public ArrayList<Disease> diseases = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_view);

        TextView bodyPartName = findViewById(R.id.body_part_name_text);
        ImageView bodyPartImageView = findViewById(R.id.detailed_body_part_image);
        ListView diseaseList = findViewById(R.id.disease_listview);
        ArrayAdapter<Disease> diseaseArrayAdapter = new CustomList(this, diseases);
        diseaseList.setAdapter(diseaseArrayAdapter);

        Intent intent = getIntent();
        ArrayList<String> dbStr = intent.getStringArrayListExtra("list");
        Log.d(TAG, "onCreate: " + dbStr);
        bodyPartName.setText(dbStr.get(1));
        String myImageDrawableName = dbStr.get(1).toLowerCase();
        int resID = getResources().getIdentifier(myImageDrawableName , "drawable", getPackageName());
        bodyPartImageView.setImageResource(resID);
        db
                .collection(dbStr.get(0))
                .document(dbStr.get(1))
                .collection("diseases")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot doc: task.getResult()) {
                                if (doc.exists()) {
                                    String diseaseName = doc.getString("name");
                                    String diseaseDescription = doc.getString("description");
                                    String diseaseURL = doc.getString("reference");
                                    List<String> diseaseSymptoms = (List<String>) doc.get("symptoms");
                                    List<String> diseaseTreatments = (List<String>) doc.get("treatments");
                                    Disease newDisease = new Disease(diseaseName, diseaseDescription, diseaseSymptoms, diseaseTreatments, diseaseURL);
                                    diseaseArrayAdapter.add(newDisease);
                                }
                            }
                            diseaseArrayAdapter.notifyDataSetChanged();
                            Log.d(TAG, "onComplete: " + diseases.size());
                        }
                    }
                });

        diseaseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object clickedDiseaseItem = diseaseList.getItemAtPosition(position);
                Disease clickedDisease = (Disease) clickedDiseaseItem;
                Intent passedIntent = new Intent(getApplicationContext(), DiseaseInfoActivity.class);
                passedIntent.putExtra("passedDisease", clickedDisease);
                startActivity(passedIntent);
            }
        });
    }
}