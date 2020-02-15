package com.example.checklistextended;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Transaction;

public class ConceptDetails extends AppCompatActivity {

    private static final String TAG = "conceptdetails";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concept_details);
        final conceptModel info = (conceptModel) getIntent().getSerializableExtra("baseInfo");



        EditText name = findViewById(R.id.editNameInDetails);
        EditText definition = findViewById(R.id.editDefinitionInDetails);
        EditText glossary= findViewById(R.id.editGlossaryInDetails);
        EditText thingsitsbuiltof= findViewById(R.id.editThingsItIsBuiltFromInDetails);
        EditText plans= findViewById(R.id.editPlansInDetails);
        EditText uses = findViewById(R.id.editUsesInDetails);
        EditText purpose = findViewById(R.id.editPurposeInDetails);

        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        final DocumentReference docRef = db.collection("users").document("gQprmC2uxhPBXfV8uMxa")
                .collection("MapOfUnderstanding").document(info.getFireBaseId());

        name.setText(info.getName());
        definition.setText(info.getDefinition());
        glossary.setText(info.getGlossary());
        thingsitsbuiltof.setText(info.getThingsItsBuiltOf());
        plans.setText(info.getPlans());
        uses.setText(info.getUses());
        purpose.setText(info.getPurpose());

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                info.setName(s.toString());
            }
        });
        definition.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                info.setDefinition(s.toString());
            }
        });
        glossary.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                info.setGlossary(s.toString());
            }
        });
        thingsitsbuiltof.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                info.setThingsItsBuiltOf(s.toString());
            }
        });
        plans.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                info.setPlans(s.toString());
            }
        });
        uses.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                info.setUses(s.toString());
            }
        });
        purpose.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                info.setPurpose(s.toString());
            }
        });

        //set up the buttons on the toolbar
        Button btnTimeLineInMap = (Button) findViewById(R.id.btnTimeLineInDetails);
        btnTimeLineInMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), timeLine.class);
                startActivity(intent);
            }
        });

        //set up the buttons on the toolbar
        Button btnTodosInMap = (Button) findViewById(R.id.btnTodosInDetails);
        btnTodosInMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        //set up the buttons on the toolbar
        Button btnMapInMap = (Button) findViewById(R.id.btnMapInDetails);
        btnMapInMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), mapOfUnderstanding.class);
                startActivity(intent);
            }
        });

        //set up the buttons on the toolbar
        Button btnWeekInMap = (Button) findViewById(R.id.btnWeekInDetails);
        btnWeekInMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), weekPlan.class);
                startActivity(intent);
            }
        });

        final FloatingActionButton fabInMap = (FloatingActionButton) findViewById(R.id.fabInDetails);
        fabInMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                docRef.update("name", info.getName());
                docRef.update("definition", info.getDefinition());
                docRef.update("glossary", info.getGlossary());
                docRef.update("thingsitsbuiltof", info.getThingsItsBuiltOf());
                docRef.update("plans", info.getPlans());
                docRef.update("uses", info.getUses());
                docRef.update("purpose", info.getPurpose());
                Log.d(TAG,"Updated items on doc with id: " + info.getFireBaseId());

                Intent intent = new Intent(v.getContext(), mapOfUnderstanding.class);
                startActivity(intent);
            }
        });

        final FloatingActionButton fabInMapRemove = (FloatingActionButton) findViewById(R.id.fabInDetailsRemove);
        fabInMapRemove.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                db.collection("users").document("gQprmC2uxhPBXfV8uMxa")
                        .collection("MapOfUnderstanding").document(info.getFireBaseId())
                        .delete()
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d(TAG, "DocumentSnapshot successfully deleted!");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error deleting document", e);
                            }
                        });

                Log.d(TAG,"removed items on doc with id: " + info.getFireBaseId());
                Intent intent = new Intent(v.getContext(), mapOfUnderstanding.class);
                startActivity(intent);
            }
        });
    }
}
