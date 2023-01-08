package com.example.a24_7_md;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
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
import java.util.Map;

public class DetailedViewActivity extends AppCompatActivity implements Serializable {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    ArrayList<Disease> diseases = new ArrayList<>();
    int iconCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_view);

        TextView bodyPartName = findViewById(R.id.body_part_name_text);
        TextView commonDisease1NameTextView = findViewById(R.id.common_disease1_text);
        TextView commonDisease2NameTextView = findViewById(R.id.common_disease2_text);
        TextView commonDisease3NameTextView = findViewById(R.id.common_disease3_text);
        TextView commonDisease4NameTextView = findViewById(R.id.common_disease4_text);
        TextView commonDisease5NameTextView = findViewById(R.id.common_disease5_text);
        ImageView bodyPartImageView = findViewById(R.id.detailed_body_part_image);

        Intent intent = getIntent();
        List<String> dbStr = intent.getStringArrayListExtra("list");

        db.collection(dbStr.get(0)).document(dbStr.get(1)).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String bodyNameStr = (String) documentSnapshot.get("name");
                bodyPartName.setText(bodyNameStr);
                String myImageDrawableName = bodyNameStr + ".jpg";
                int resID = getResources().getIdentifier(myImageDrawableName , "drawable", getPackageName());
                bodyPartImageView.setImageResource(resID);
            }
        });

        db.collection(dbStr.get(0)).document(dbStr.get(1)).collection("diseases").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (DocumentSnapshot doc : queryDocumentSnapshots.getDocuments()) {
                    String diseaseName = doc.getId();
                    String diseaseDescription = (String) doc.get("description");
                    String diseaseURL = (String) doc.get("reference");
                    List<String> diseaseSymptoms = (List<String>) doc.get("symptoms");
                    List<String> diseaseTreatments = (List<String>) doc.get("treatment");
                    Disease disease = new Disease(diseaseName, diseaseDescription, (ArrayList<String>) diseaseSymptoms, (ArrayList<String>) diseaseTreatments, diseaseURL);

                    diseases.add(disease);
                }
            }
        });

        if (diseases.get(0) != null) {
            commonDisease1NameTextView.setText(diseases.get(0).getName());
        }
        if (diseases.get(1) != null) {
            commonDisease2NameTextView.setText(diseases.get(1).getName());
        }
        if (diseases.get(2) != null) {
            commonDisease3NameTextView.setText(diseases.get(2).getName());
        }
        if (diseases.get(3) != null) {
            commonDisease4NameTextView.setText(diseases.get(3).getName());
        }
        if (diseases.get(4) != null) {
            commonDisease5NameTextView.setText(diseases.get(4).getName());
        }

        commonDisease1NameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(getApplicationContext(), DiseaseInfoActivity.class);
                Disease passedDisease = diseases.get(0);
                newIntent.putExtra("passedDisease", (Serializable) passedDisease);
            }
        });


        commonDisease2NameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(getApplicationContext(), DiseaseInfoActivity.class);
                Disease passedDisease = diseases.get(1);
                newIntent.putExtra("passedDisease", (Serializable) passedDisease);
            }
        });

        commonDisease3NameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(getApplicationContext(), DiseaseInfoActivity.class);
                Disease passedDisease = diseases.get(2);
                newIntent.putExtra("passedDisease", (Serializable) passedDisease);
            }
        });

        commonDisease4NameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(getApplicationContext(), DiseaseInfoActivity.class);
                Disease passedDisease = diseases.get(3);
                newIntent.putExtra("passedDisease", (Serializable) passedDisease);
            }
        });

        commonDisease5NameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(getApplicationContext(), DiseaseInfoActivity.class);
                Disease passedDisease = diseases.get(4);
                newIntent.putExtra("passedDisease", (Serializable) passedDisease);
            }
        });


    }
}