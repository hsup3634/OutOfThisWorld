package com.example.outofthisworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
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
import java.util.List;

public class SolarSystemLanding extends AppCompatActivity {

    ArrayList<SolarSystem> solarArray;
    private RecyclerView rv_solartopics;
    private RecyclerView.LayoutManager layoutManager;
    private View view;

    private EditText searchBodiesText;
    private TextView setBodiesText;
    private ImageButton searchButton;
    private String userInput;
    private List<SolarSystem> bodies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.solar_view);


        rv_solartopics = findViewById(R.id.rv_solartopics);
        rv_solartopics.setVisibility(View.VISIBLE);
        searchButton= findViewById(R.id.searchButton);

        searchBodiesText = findViewById(R.id.bodiesSearch);
        searchBodiesText.setVisibility(View.VISIBLE);
        setBodiesText=findViewById(R.id.setSearch);
        setBodiesText.setVisibility(View.INVISIBLE);

        layoutManager = new LinearLayoutManager(this);
        rv_solartopics.setLayoutManager(layoutManager);

        Intent intent2 = getIntent();
        Intent intentapi = getIntent();


        final Intent intent = getIntent();

        final SolarSystemAdapter solarSystemAdapter = new SolarSystemAdapter();

        final RequestQueue requestQueue = Volley.newRequestQueue(SolarSystemLanding.this);
        final String url = "https://api.le-systeme-solaire.net/rest/bodies/";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                SolarResponse solarResponse = gson.fromJson(response, SolarResponse.class);
                final ArrayList<SolarSystem> solarSystem = solarResponse.getBodies();
                solarSystemAdapter.setData(solarSystem);
                rv_solartopics.setAdapter(solarSystemAdapter);

                searchButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userInput = searchBodiesText.getText().toString();
                        setBodiesText.setText(userInput);
                        String input = setBodiesText.getText().toString();
                        String userInput = input.toLowerCase();
                        ArrayList<SolarSystem>newBodies=new ArrayList<>();
                        for(SolarSystem englishName: solarSystem) {
                            if(englishName.getEnglishName().toLowerCase().contains(userInput)) {
                                newBodies.add(englishName);
                            }
                        }
                        solarSystemAdapter.setData(newBodies);
                        rv_solartopics.setAdapter(solarSystemAdapter);
                        rv_solartopics.setVisibility(view.VISIBLE);
                    }
                                                });

                requestQueue.stop();




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
