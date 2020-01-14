package com.example.checklistextended;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class mapOfUnderstanding extends AppCompatActivity {

    //---------------------------START: DRAGGING THINGS----------------------
    ImageView ivShadow;
    String msg;
    private CoordinatorLayout.LayoutParams layoutParams;
    //---------------------------END: DRAGGING THINGS----------------------

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapofunderstanding);

        final TextView xCoord = findViewById(R.id.xCoordOfTouch);
        final TextView yCoord = findViewById(R.id.yCoordOfTouch);
        final TextView xCoord2 = findViewById(R.id.xCoordOfTouch2);
        final TextView yCoord2 = findViewById(R.id.yCoordOfTouch2);
        final CoordinatorLayout coordinatorLayoutInMap = findViewById(R.id.coordinatorlayoutForMap);
        final RelativeLayout conceptInMapSinglePiece = findViewById(R.id.conceptInMap);
        final RelativeLayout sub = findViewById(R.id.sub);
        final ImageView image = findViewById(R.id.my_image_view);
        Button buttonOnImage = findViewById(R.id.buttonOnImage);
        final boolean[] isMapBtnPressed = {false};
        final ViewGroup viewGroup = (ViewGroup) findViewById(R.id.coordinatorlayoutForMap);
        final ArrayList<View> inflatedElements = new ArrayList<>();


        coordinatorLayoutInMap.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    xCoord.setText(String.valueOf(event.getX()) + " x");
                    yCoord.setText(String.valueOf(event.getY()) + " y");
                    if(isMapBtnPressed[0]) {
                        conceptInMapSinglePiece.setX(event.getX());
                        conceptInMapSinglePiece.setY(event.getY());
                        isMapBtnPressed[0] = false;
                    }
                }
                return true;
            }
        });

        buttonOnImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isMapBtnPressed[0] = true;
            }
        });

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
                final View inflatedConcept = LayoutInflater.from(getApplicationContext()).inflate(R.layout.conceptinmap,null, false);
                inflatedConcept.setId(View.generateViewId());
                inflatedElements.add(inflatedConcept);
                viewGroup.addView(inflatedConcept);
                inflatedConcept.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            xCoord2.setText(String.valueOf(event.getX()) + " x");
                            yCoord2.setText(String.valueOf(event.getY()) + " y");
                                v.setX(event.getX());
                                v.setY(event.getY());
                                isMapBtnPressed[0] = false;

                        }
                        return true;
                    }
                });
            }
        });


    }

}
