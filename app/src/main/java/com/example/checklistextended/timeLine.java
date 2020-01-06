package com.example.checklistextended;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class timeLine extends AppCompatActivity implements mouRWAdapter.ItemClickListener{

    mouRWAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline);


        // data to populate the RecyclerView with
        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Horse");
        animalNames.add("Cow");
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvAnimalsInTimeline);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new mouRWAdapter(this, animalNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        //set up the buttons on the toolbar
        Button btnTimeLineInTimeLine = (Button) findViewById(R.id.btnTimeLineInTimeLine);
        btnTimeLineInTimeLine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        //set up the buttons on the toolbar
        Button btnTodosInTimeLine = (Button) findViewById(R.id.btnTodosInTimeLine);
        btnTodosInTimeLine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        //set up the buttons on the toolbar
        Button btnMapInTimeLine = (Button) findViewById(R.id.btnMapInTimeLine);
        btnMapInTimeLine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), mapOfUnderstanding.class);
                startActivity(intent);
            }
        });

        //set up the buttons on the toolbar
        Button btnWeekInTimeLine = (Button) findViewById(R.id.btnWeekInTimeLine);
        btnWeekInTimeLine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), weekPlan.class);
                startActivity(intent);
            }
        });

        final FloatingActionButton fabInTimeline = (FloatingActionButton) findViewById(R.id.fabInTimeline);
        fabInTimeline.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getAdapter().newAddeddata("doesntmatter");
            }
        });
    }
    public mouRWAdapter getAdapter(){
        return adapter;
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}