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

    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapofunderstanding);

        final ArrayList<conceptModel> conceptList = new ArrayList<>();
        final TextView xCoord = findViewById(R.id.xCoordOfTouch);
        final TextView yCoord = findViewById(R.id.yCoordOfTouch);
        final CoordinatorLayout coordinatorLayoutInMap = findViewById(R.id.coordinatorlayoutForMap);
        final RelativeLayout conceptInMapSinglePiece = findViewById(R.id.conceptInMap);
        final RelativeLayout sub = findViewById(R.id.sub);
        final ImageView image = findViewById(R.id.my_image_view);
        Button buttonOnImage = findViewById(R.id.buttonOnImage);
        final boolean[] isMapBtnPressed = {false};
        final ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
        final ArrayList<View> inflatedElements = new ArrayList<>();

        View.OnTouchListener touchListenerForCoords = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    xCoord.setText(String.valueOf(event.getX()) + " x");
                    yCoord.setText(String.valueOf(event.getY()) + " y");

                }
                return true;
            }
        };


        coordinatorLayoutInMap.setOnTouchListener(touchListenerForCoords);

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
                final View inflatedConcept = LayoutInflater.from(getApplicationContext()).inflate(R.layout.conceptinmap,viewGroup,false);
                addToExistingTouchListener(inflatedConcept,coordinatorLayoutInMap);
                inflatedConcept.setId(View.generateViewId());
                Log.d(TAG,"Generated View: " + inflatedConcept.getId());
                inflatedElements.add(inflatedConcept);
                viewGroup.addView(inflatedConcept);

                if (inflatedConcept instanceof ViewGroup) {
                    Log.d(TAG,"Generated View is part of viewgroup " + inflatedConcept.getId());
                    ViewGroup viewGroup = (ViewGroup) inflatedConcept;
                    Button buttonOfChildConcept = (Button) viewGroup.getChildAt(0);
                    buttonOfChildConcept.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Intent intent = new Intent(v.getContext(), ConceptDetails.class);
                            startActivity(intent);
                        }
                    });
                    for(int i = 0; i< viewGroup.getChildCount(); ++i) {
                        Log.d(TAG,"Started looking through the children of: " + inflatedConcept.getId());
                        View child = viewGroup.getChildAt(i);

                        // Edit the child
                    }
                }
            }
        });


    }

    private void addToExistingTouchListener(final View vToAssign, final CoordinatorLayout coordinatorLayoutInMap)
    {
        View.OnLongClickListener longClickListener = (new View.OnLongClickListener()
        {

            @Override
            public boolean onLongClick(final View vToPut)
            {
                Log.d(TAG,"longclick fired on View: "+vToPut.getId());
                View.OnTouchListener touchListener = new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Log.d(TAG,"touch fired on View: "+vToPut.getId()+" to replace on CoordinatorLayout: " +v.getId());
                            vToAssign.setX(event.getX());
                            vToAssign.setY(event.getY());
                            coordinatorLayoutInMap.setOnTouchListener(null);
                        }
                        return true;
                    }
                };
                coordinatorLayoutInMap.setOnTouchListener(touchListener);
                return true;
            }
        });
        vToAssign.setOnLongClickListener(longClickListener);

    }

}
