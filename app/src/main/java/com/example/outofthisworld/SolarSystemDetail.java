package com.example.outofthisworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class SolarSystemDetail extends AppCompatActivity {

    private TextView englishNameTV;
    private TextView escapeTV;
    private TextView gravityTV;
    private TextView equaRadiusTV;
    private TextView discoveredByTV;
    private TextView discoveryDateTV;
    ArrayList<SolarSystem> solarArray;
    private RecyclerView rv_solartopics;
    private View view;


    //this class is just a detailed view of each item from the recycler view
    //once the user clicks on the name, the detail view shows the escape velocity, surface gravity
    //equatorial radius, who it was discovered by, and date of discovery
    //note: the API does not have data for all the planets listed so some items may appear as blank
    //such as discovered by for moon, or 0.0 for gravity and escape of some celestial bodies
    //this is due to the API not having data, not because it is not being retrieved correctly
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.solarsystem_detail);


        rv_solartopics = findViewById(R.id.rv_solartopics);

        Intent intent2 = getIntent();


        final Intent intent = getIntent();


        String englishName = intent.getStringExtra("englishName");
        double escape = intent.getDoubleExtra("escape", 0);
        double gravity = intent.getDoubleExtra("gravity", 0);
        double equaRadius = intent.getDoubleExtra("equaRadius", 0);
        String discoveredBy = intent.getStringExtra("discoveredBy");
        String discoveryDate = intent.getStringExtra("discoveryDate");


        englishNameTV = findViewById(R.id.solarEnglishName);
        escapeTV = findViewById(R.id.solarMassExponent);
        gravityTV = findViewById(R.id.solarGravity);
        equaRadiusTV = findViewById(R.id.solarEquaRadius);
        discoveredByTV = findViewById(R.id.solarDiscoveredBy);
        discoveryDateTV = findViewById(R.id.solarDiscoveryDate);

        //setting the UI elements to hold the API data
        englishNameTV.setText(englishName);
        escapeTV.setText(String.valueOf(escape));
        gravityTV.setText(String.valueOf(gravity));
        equaRadiusTV.setText(String.valueOf(equaRadius));
        discoveredByTV.setText(discoveredBy);
        discoveryDateTV.setText(discoveryDate);


    }


}



