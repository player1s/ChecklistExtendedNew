package com.example.checklistextended;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class mapOfUnderstanding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapofunderstanding);

        Canvas canvas = new Canvas();

        final CoordinatorLayout coordinatorLayoutInMap = (CoordinatorLayout) findViewById(R.id.coordinatorlayoutForMap);

        //set up the buttons on the toolbar
        Button btnTimeLineInMap = (Button) findViewById(R.id.btnTimeLineInMap);
        btnTimeLineInMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), timeLine.class);
                startActivity(intent);
            }
        });

        //set up the buttons on the toolbar
        Button btnTodosInMap = (Button) findViewById(R.id.btnTodosInMap);
        btnTodosInMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        //set up the buttons on the toolbar
        Button btnMapInMap = (Button) findViewById(R.id.btnMapInMap);
        btnMapInMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        //set up the buttons on the toolbar
        Button btnWeekInMap = (Button) findViewById(R.id.btnWeekInMap);
        btnWeekInMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), weekPlan.class);
                startActivity(intent);
            }
        });

        final FloatingActionButton fabInMap = (FloatingActionButton) findViewById(R.id.fabInMap);
        fabInMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MyDrawable rectangle = new MyDrawable();


                ImageView image = findViewById(R.id.my_image_view);
                image.setImageDrawable(rectangle);



                ImageView iv = new ImageView(getApplicationContext());

                // Set an image for ImageView
                iv.setImageDrawable(getDrawable(R.drawable.concept));

                // Create layout parameters for ImageView
                CoordinatorLayout.LayoutParams lp = new CoordinatorLayout.LayoutParams(CoordinatorLayout.LayoutParams.WRAP_CONTENT, CoordinatorLayout.LayoutParams.WRAP_CONTENT);

                // Add rule to layout parameters
                // Add the ImageView below to Button
                lp.setMargins(450,450,50,50);

                // Add layout parameters to ImageView
                iv.setLayoutParams(lp);

                // Finally, add the ImageView to layout
                coordinatorLayoutInMap.addView(iv);
            }
        });



    }

}
