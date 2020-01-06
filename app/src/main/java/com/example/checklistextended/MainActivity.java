package com.example.checklistextended;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity implements mouRWAdapter.ItemClickListener {

    mouRWAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // data to populate the RecyclerView with
        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Horse");
        animalNames.add("Cow");
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvAnimals);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new mouRWAdapter(this, animalNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);




        //set up the buttons on the toolbar
        Button btnTimeLineInTodos = (Button) findViewById(R.id.btnTimeLineInTodos);
        btnTimeLineInTodos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), timeLine.class);
                startActivity(intent);
            }
        });

        //set up the buttons on the toolbar
        Button btnTodosInTodos = (Button) findViewById(R.id.btnTodosInTodos);
        btnTodosInTodos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        //set up the buttons on the toolbar
        Button btnMapInTodos = (Button) findViewById(R.id.btnMapInTodos);
        btnMapInTodos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), mapOfUnderstanding.class);
                startActivity(intent);
            }
        });

        //set up the buttons on the toolbar
        Button btnWeekInTodos = (Button) findViewById(R.id.btnWeekInTodos);
        btnWeekInTodos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), weekPlan.class);
                startActivity(intent);
            }
        });
        final FloatingActionButton fabInTodos = (FloatingActionButton) findViewById(R.id.fabInTodos);
        fabInTodos.setOnClickListener(new View.OnClickListener() {
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