package com.example.statusquotesapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();

        // Get references to the buttons
        Button expandAllButton1 = findViewById(R.id.expandAllButton1);
        Button expandAllButton2 = findViewById(R.id.expandAllButton2);

        // Set click listeners for the buttons
        expandAllButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the first activity when the first button is pressed
                Intent intent = new Intent(MainActivity2.this, StatusImage.class);
                startActivity(intent);
            }
        });

        expandAllButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the second activity when the second button is pressed
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    // Add this method to handle the click event from the XML onClick attribute
    public void onExpandAllButtonClick(View view) {
        // Handle the click event if needed
        // This method will be called when either of the "Expand All" buttons is pressed
    }
}
