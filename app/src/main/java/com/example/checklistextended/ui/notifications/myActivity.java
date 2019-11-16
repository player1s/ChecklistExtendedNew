package com.example.checklistextended.ui.notifications;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.checklistextended.R;
import com.example.checklistextended.ui.teszt.buttonteszt;

public class myActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_notifications);

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(myActivity.this, buttonteszt.class);
                startActivity(intent);
            }
        });
    }
}