package com.example.checklistextended;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ConceptDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concept_details);
        conceptModel info = (conceptModel) getIntent().getSerializableExtra("baseInfo");

        EditText name = findViewById(R.id.editNameInDetails);
        EditText definition = findViewById(R.id.editDefinitionInDetails);
        EditText glossary= findViewById(R.id.editGlossaryInDetails);
        EditText thingsitsbuiltof= findViewById(R.id.editThingsItIsBuiltFromInDetails);
        EditText plans= findViewById(R.id.editPlansInDetails);
        EditText uses = findViewById(R.id.editUsesInDetails);
        EditText purpose = findViewById(R.id.editPurposeInDetails);

        name.setText(info.getName());
        definition.setText(info.getDefinition());
        glossary.setText(info.getGlossary());
        thingsitsbuiltof.setText(info.getThingsItsBuiltOf());
        plans.setText(info.getPlans());
        uses.setText(info.getUses());
        purpose.setText(info.getPurpose());

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

            }
        });
    }
}
