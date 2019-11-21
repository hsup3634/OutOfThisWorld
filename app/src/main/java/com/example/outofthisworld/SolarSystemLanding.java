package com.example.outofthisworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SolarSystemLanding extends AppCompatActivity {



    private TextView englishNameTV;
    private TextView massExponentTV;
    private TextView volExponentTV;
    private TextView gravityTV;
    private TextView equaRadiusTV;
    private TextView discoveredByTV;
    private TextView discoveryDateTV;
    ArrayList<SolarSystem> solarArray;
    private RecyclerView rv_solartopics;
    private RecyclerView.LayoutManager layoutManager;
    private View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.solar_view);

        rv_solartopics = findViewById(R.id.rv_solartopics);
        layoutManager = new LinearLayoutManager(this);
        rv_solartopics.setLayoutManager(layoutManager);

        Intent intent2 = getIntent();
        Intent intentapi = getIntent();


        final Intent intent = getIntent();
        //final SolarSystem solarSystem = new SolarSystem();

        //LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());

        final SolarSystemAdapter solarSystemAdapter = new SolarSystemAdapter();

        final RequestQueue requestQueue = Volley.newRequestQueue(SolarSystemLanding.this);
        final String url = "https://api.le-systeme-solaire.net/rest/bodies/";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                SolarResponse solarResponse = gson.fromJson(response, SolarResponse.class);
                ArrayList<SolarSystem> solarSystem = solarResponse.getBodies();
                solarSystemAdapter.setData(solarSystem);
//                solarSystemAdapter.setData(solarSystemArrayList);
//                System.out.println(solarSystem);

                rv_solartopics.setAdapter(solarSystemAdapter);
                requestQueue.stop();

                //final Arraylist<SolarSystem> solarSystemArraylist = new ArrayList<>(solarSystem1);



            }
        };

        Response.ErrorListener solarSystemErrorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Error");
            }

        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener, solarSystemErrorListener);

        requestQueue.add(stringRequest);

        //return view;
    }

}
