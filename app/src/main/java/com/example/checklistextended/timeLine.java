package com.example.checklistextended;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class timeLine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline);


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
    }

}