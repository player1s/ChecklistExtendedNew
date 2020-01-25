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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class mapOfUnderstanding extends AppCompatActivity {

    private static final String TAG = "mapofunderstanding";
    final ArrayList<conceptModel> conceptList = new ArrayList<>();
    final ArrayList<View> inflatedElements = new ArrayList<>();
    final FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapofunderstanding);


        final TextView xCoord = findViewById(R.id.xCoordOfTouch);
        final TextView yCoord = findViewById(R.id.yCoordOfTouch);
        final CoordinatorLayout coordinatorLayoutInMap = findViewById(R.id.coordinatorlayoutForMap);
        final RelativeLayout conceptInMapSinglePiece = findViewById(R.id.conceptInMap);
        final RelativeLayout sub = findViewById(R.id.sub);
        final ImageView image = findViewById(R.id.my_image_view);
        Button buttonOnImage = findViewById(R.id.buttonOnImage);
        final boolean[] isMapBtnPressed = {false};
        final ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference docRef = db.collection("users").document("gQprmC2uxhPBXfV8uMxa")
                .collection("MapOfUnderstanding");

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

        docRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                final conceptModel conceptModel = new conceptModel();
                                conceptModel.setName((String)document.get("name"));
                                conceptModel.setDefinition((String)document.get("definition"));
                                conceptModel.setGlossary((String)document.get("glossary"));
                                conceptModel.setThingsItsBuiltOf((String)document.get("thingsitsbuiltof"));
                                conceptModel.setPlans((String)document.get("plans"));
                                conceptModel.setUses((String)document.get("uses"));
                                conceptModel.setPurpose((String)document.get("purpose"));
                                conceptModel.setCoordx((long)document.get("coordx"));
                                conceptModel.setCoordy((long)document.get("coordy"));
                                conceptModel.setFireBaseId(document.getId());
                                conceptList.add(conceptModel);

                                final View inflatedConcept = LayoutInflater.from(getApplicationContext()).inflate(R.layout.conceptinmap,viewGroup,false);
                                addToExistingTouchListener(inflatedConcept,coordinatorLayoutInMap);
                                inflatedConcept.setId(View.generateViewId());
                                Log.d(TAG,"Generated View: " + inflatedConcept.getId());
                                inflatedElements.add(inflatedConcept);
                                viewGroup.addView(inflatedConcept);
                                inflatedConcept.setX((long)document.get("coordx"));
                                inflatedConcept.setY((long)document.get("coordy"));

                                if (inflatedConcept instanceof ViewGroup) {
                                    Log.d(TAG,"Generated View is part of viewgroup " + inflatedConcept.getId());
                                    ViewGroup viewGroup = (ViewGroup) inflatedConcept;
                                    Button buttonOfChildConcept = (Button) viewGroup.getChildAt(0);
                                    buttonOfChildConcept.setOnClickListener(new View.OnClickListener() {
                                        public void onClick(View v) {
                                            Intent intent = new Intent(v.getContext(), ConceptDetails.class);
                                            intent.putExtra("baseInfo", conceptModel);
                                            startActivity(intent);
                                        }
                                    });
                                    TextView textOnConcept = (TextView) viewGroup.getChildAt(2);
                                    textOnConcept.setText((String)document.get("name"));
                                }

                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
/*
        for (int i = 0; i<conceptList.size();i++)
        {
            Log.d(TAG, "element: "+ i + conceptList.get(i).getName() + conceptList.get(i).getDefinition() + conceptList.get(i).getGlossary() + conceptList.get(i).getThingsItsBuiltOf()
                    + conceptList.get(i).getPlans() + conceptList.get(i).getUses() + conceptList.get(i).getPurpose() + conceptList.get(i).getCoordx() + conceptList.get(i).getCoordy());
        }

 */
/*
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.get("CoordY"));
                        conceptModel conceptModel = new conceptModel();
                        conceptModel.setName((String)document.get("name"));
                        conceptList.add(conceptModel);

                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
*/
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
                final conceptModel conceptModel = new conceptModel();
                conceptList.add(conceptModel);
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
                            for(int i = 0; i<inflatedElements.size();i++)
                            {
                                if(inflatedElements.get(i).getId() == vToAssign.getId())
                                {
                                    final DocumentReference docRef = db.collection("users").document("gQprmC2uxhPBXfV8uMxa")
                                            .collection("MapOfUnderstanding").document(conceptList.get(i).getFireBaseId());
                                    conceptList.get(i).setCoordx((long)event.getX());
                                    conceptList.get(i).setCoordy((long)event.getY());
                                    docRef.update("coordx",  conceptList.get(i).getCoordx());
                                    docRef.update("coordy",  conceptList.get(i).getCoordy());
                                }
                            }
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
