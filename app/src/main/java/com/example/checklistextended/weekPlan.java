package com.example.checklistextended;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class weekPlan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weekplan);


        //set up the buttons on the toolbar
        Button btnTimeLineInWeek = (Button) findViewById(R.id.btnTimeLineInWeek);
        btnTimeLineInWeek.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), timeLine.class);
                startActivity(intent);
            }
        });

        //set up the buttons on the toolbar
        Button btnTodosInWeek = (Button) findViewById(R.id.btnTodosInWeek);
        btnTodosInWeek.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        //set up the buttons on the toolbar
        Button btnMapInWeek = (Button) findViewById(R.id.btnMapInWeek);
        btnMapInWeek.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), mapOfUnderstanding.class);
                startActivity(intent);
            }
        });

        //set up the buttons on the toolbar
        Button btnWeekInWeek = (Button) findViewById(R.id.btnWeekInWeek);
        btnWeekInWeek.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
    }

}
