package com.example.outofthisworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import java.util.ArrayList;


import java.util.ArrayList;
import java.util.Arrays;

public class SolarSystemDetail extends AppCompatActivity {

    private TextView idTV;
    private TextView englishNameTV;
    private TextView massExponentTV;
    private TextView volExponentTV;
    private TextView gravityTV;
    private TextView equaRadiusTV;
    private TextView discoveredByTV;
    private TextView discoveryDateTV;
    ArrayList<SolarSystem> solarArray;
    private RecyclerView rv_solartopics;
    private View view;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.solarsystem_detail);


        rv_solartopics = findViewById(R.id.rv_solartopics);

        Intent intent2 = getIntent();


        final Intent intent = getIntent();
        //final SolarSystem solarSystem = new SolarSystem();

        //LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());

        final SolarSystemAdapter solarSystemAdapter = new SolarSystemAdapter();

        final RequestQueue requestQueue = Volley.newRequestQueue(SolarSystemDetail.this);
        final String url = "https://api.le-systeme-solaire.net/rest/bodies/lune";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                SolarSystem solarSystem = gson.fromJson(response, SolarSystem.class);
                final ArrayList<SolarSystem> solarSystemArrayList = new ArrayList<>(Arrays.asList(solarSystem));
                solarSystemAdapter.setData(solarSystemArrayList);
                System.out.println(solarSystem);

                rv_solartopics.setAdapter(solarSystemAdapter);

                //final Arraylist<SolarSystem> solarSystemArraylist = new ArrayList<>(solarSystem1);



            }
        };

        Response.ErrorListener solarSystemErrorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }

        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener, solarSystemErrorListener);

        requestQueue.add(stringRequest);

        //return view;

        int id = intent.getIntExtra("id", 0);
        String englishName = intent.getStringExtra("englishName");
        int massExponent = intent.getIntExtra("massExponent", 0);
        int volExponent = intent.getIntExtra("volExponent", 0);
        float gravity = intent.getFloatExtra("gravity", 0);
        int equaRadius = intent.getIntExtra("equaRadius", 0);
        String discoveredBy = intent.getStringExtra("discoveredBy");
        String discoveryDate = intent.getStringExtra("discoveredDate");


        //idTV = findViewById(R.id.solarId);
        englishNameTV = findViewById(R.id.solarEnglishName);
//            massExponentTV = findViewById(R.id.solarMassExponent);
//            volExponentTV = findViewById(R.id.solarVolExponent);
//            gravityTV = findViewById(R.id.solarGravity);
//            equaRadiusTV = findViewById(R.id.solarEquaRadius);
//            discoveredByTV = findViewById(R.id.solarDiscoveredBy);
//            discoveryDateTV = findViewById(R.id.solarDiscoveryDate);

        //idTV.setText(id);
        englishNameTV.setText(englishName);
//            massExponentTV.setText(massExponent);
//            volExponentTV.setText(volExponent);
//            gravityTV.setText((int) gravity);
//            equaRadiusTV.setText(equaRadius);
//            discoveredByTV.setText(discoveredBy);
//            discoveryDateTV.setText(discoveryDate);


    }


}



