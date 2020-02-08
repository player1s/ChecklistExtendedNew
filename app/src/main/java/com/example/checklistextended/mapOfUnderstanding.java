package com.example.checklistextended;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.DisplayMetrics;
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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

public class mapOfUnderstanding extends AppCompatActivity {

    private static final String TAG = "mapofunderstanding";
    final ArrayList<conceptModel> conceptList = new ArrayList<>();
    final ArrayList<View> inflatedElements = new ArrayList<>();
    final FirebaseFirestore db = FirebaseFirestore.getInstance();
    final CollectionReference colRef = db.collection("users").document("gQprmC2uxhPBXfV8uMxa")
            .collection("MapOfUnderstanding");
    final int distanceForScroll = 400;

    final CollectionReference docRef = db.collection("users").document("gQprmC2uxhPBXfV8uMxa")
            .collection("MapOfUnderstanding");





    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapofunderstanding);
        final ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
        final CoordinatorLayout coordinatorLayoutInMap = findViewById(R.id.coordinatorlayoutForMap);

        final TextView xCoord = findViewById(R.id.xCoordOfTouch);
        final TextView yCoord = findViewById(R.id.yCoordOfTouch);
        final RelativeLayout conceptInMapSinglePiece = findViewById(R.id.conceptInMap);
        final RelativeLayout sub = findViewById(R.id.sub);
        final ImageView image = findViewById(R.id.my_image_view);
        Button buttonOnImage = findViewById(R.id.buttonOnImage);
        final boolean[] isMapBtnPressed = {false};

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final int height = displayMetrics.heightPixels;
        final int width = displayMetrics.widthPixels;
        final CoordsContainer screen = new CoordsContainer(400,400,400+width,400,400,400+height,400+width,400+height);

        regenerateViews(screen, viewGroup, coordinatorLayoutInMap);
        View.OnTouchListener touchListenerForCoords = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    int tappedCoordInMapx = (int) event.getX() + screen.getCtlx();
                    int tappedCoordInMapy = (int) event.getY() + screen.getCtly();
                    xCoord.setText(tappedCoordInMapx + " x");
                    yCoord.setText(tappedCoordInMapy + " y");

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
        final FloatingActionButton topScrollButtol = (FloatingActionButton) findViewById(R.id.fabScrollUpInMap);
        topScrollButtol.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                screen.setCtlx(screen.getCtlx());
                screen.setCtly(screen.getCtly()-distanceForScroll);
                screen.setCtrx(screen.getCtrx());
                screen.setCtry(screen.getCtry()-distanceForScroll);
                screen.setCblx(screen.getCblx());
                screen.setCbly(screen.getCbly()-distanceForScroll);
                screen.setCbrx(screen.getCbrx());
                screen.setCbry(screen.getCbry()-distanceForScroll);
                removeAllViews(viewGroup);
                regenerateViews(screen, viewGroup, coordinatorLayoutInMap);
            }
        });
        final FloatingActionButton rightScrollButtol = (FloatingActionButton) findViewById(R.id.fabScrollRightInMap);
        rightScrollButtol.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                screen.setCtlx(screen.getCtlx()+distanceForScroll);
                screen.setCtly(screen.getCtly());
                screen.setCtrx(screen.getCtrx()+distanceForScroll);
                screen.setCtry(screen.getCtry());
                screen.setCblx(screen.getCblx()+distanceForScroll);
                screen.setCbly(screen.getCbly());
                screen.setCbrx(screen.getCbrx()+distanceForScroll);
                screen.setCbry(screen.getCbry());
                removeAllViews(viewGroup);
                regenerateViews(screen, viewGroup, coordinatorLayoutInMap);
            }
        });
        final FloatingActionButton downScrollButtol = (FloatingActionButton) findViewById(R.id.fabScrollDownInMap);
        downScrollButtol.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                screen.setCtlx(screen.getCtlx());
                screen.setCtly(screen.getCtly()+distanceForScroll);
                screen.setCtrx(screen.getCtrx());
                screen.setCtry(screen.getCtry()+distanceForScroll);
                screen.setCblx(screen.getCblx());
                screen.setCbly(screen.getCbly()+distanceForScroll);
                screen.setCbrx(screen.getCbrx());
                screen.setCbry(screen.getCbry()+distanceForScroll);
                removeAllViews(viewGroup);
                regenerateViews(screen, viewGroup, coordinatorLayoutInMap);
            }
        });
        final FloatingActionButton leftScrollButtol = (FloatingActionButton) findViewById(R.id.fabScrollLeftInMap);
        leftScrollButtol.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                screen.setCtlx(screen.getCtlx()-distanceForScroll);
                screen.setCtly(screen.getCtly());
                screen.setCtrx(screen.getCtrx()-distanceForScroll);
                screen.setCtry(screen.getCtry());
                screen.setCblx(screen.getCblx()-distanceForScroll);
                screen.setCbly(screen.getCbly());
                screen.setCbrx(screen.getCbrx()-distanceForScroll);
                screen.setCbry(screen.getCbry());
                removeAllViews(viewGroup);
                regenerateViews(screen, viewGroup, coordinatorLayoutInMap);
            }
        });

        final FloatingActionButton fabInMap = (FloatingActionButton) findViewById(R.id.fabInMap);
        fabInMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final View inflatedConcept = LayoutInflater.from(getApplicationContext()).inflate(R.layout.conceptinmap,viewGroup,false);
                int generatedId = View.generateViewId();
                inflatedConcept.setId(generatedId);
                Log.d(TAG,"Generated View: " + inflatedConcept.getId());
                inflatedElements.add(inflatedConcept);
                final conceptModel conceptModel = new conceptModel();
                conceptModel.setId(generatedId);
                conceptModel.setFireBaseId(Integer.toString(generatedId));
                Map map = conceptModel.createMap();
                conceptList.add(conceptModel);
                db.collection("users").document("gQprmC2uxhPBXfV8uMxa")
                        .collection("MapOfUnderstanding").document(Integer.toString(conceptModel.getId()))
                        .set(map)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d(TAG, "DocumentSnapshot successfully written!");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error writing document", e);
                            }
                        });


                addToExistingTouchListener(inflatedConcept,coordinatorLayoutInMap);
                viewGroup.addView(inflatedConcept);


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
                    for(int i = 0; i< viewGroup.getChildCount(); ++i) {
                        Log.d(TAG,"Started looking through the children of: " + inflatedConcept.getId());
                        View child = viewGroup.getChildAt(i);

                        // Edit the child
                    }
                }
            }
        });


    }

    private void regenerateViews(final CoordsContainer screen, final ViewGroup viewGroup, final CoordinatorLayout coordinatorLayoutInMap)
    {
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

                        //check if the item is within the screen
                        if(conceptModel.getCoordx()>=screen.getCtlx() && conceptModel.getCoordy()>=screen.getCtly() &&
                                conceptModel.getCoordx()<=screen.getCtrx() && conceptModel.getCoordy()>=screen.getCtry() &&
                                conceptModel.getCoordx()>=screen.getCblx() && conceptModel.getCoordy()<=screen.getCbly() &&
                                conceptModel.getCoordx()<=screen.getCbrx() && conceptModel.getCoordy()<=screen.getCbry())
                        {
                            addToExistingTouchListener(inflatedConcept,coordinatorLayoutInMap);
                            inflatedConcept.setId(View.generateViewId());
                            Log.d(TAG,"Generated View: " + inflatedConcept.getId());
                            inflatedElements.add(inflatedConcept);
                            viewGroup.addView(inflatedConcept);
                            inflatedConcept.setX((long)document.get("coordx")- screen.getCtlx());
                            inflatedConcept.setY((long)document.get("coordy")- screen.getCtly());
                            Log.d(TAG,"ctlx: " + screen.getCtlx());
                            Log.d(TAG,"ctly: " + screen.getCtly());
                        }



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
    }

    private void removeAllViews(final ViewGroup viewGroup)
    {
        for(int i = 0; i < inflatedElements.size();i++)
        {
            Log.d(TAG, "startend removing: ");
            viewGroup.removeView(inflatedElements.get(i));
        }
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
                                    final DocumentReference docRef = colRef.document(conceptList.get(i).getFireBaseId());
                                    conceptList.get(i).setCoordx((long)event.getX());
                                    conceptList.get(i).setCoordy((long)event.getY());
                                    docRef.update("coordx",  conceptList.get(i).getCoordx());
                                    docRef.update("coordy",  conceptList.get(i).getCoordy());
                                    break;
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
