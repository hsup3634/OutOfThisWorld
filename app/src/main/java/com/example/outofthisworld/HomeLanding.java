package com.example.outofthisworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeLanding extends AppCompatActivity {

    Button content;
    Button funfacts;
    Button videos;
    Button quiz;
    Button apibutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);

        content = findViewById(R.id.content);

        funfacts = findViewById(R.id.funfacts);
        videos = findViewById(R.id.videos);
        quiz = findViewById(R.id.quiz);
        apibutton = findViewById(R.id.apibutton);

        Intent intent = getIntent();
        Intent homeIntent = getIntent();
        Intent exitIntent = getIntent();

        //setting all the intents for all the landing page buttons so they lead to the correct classes

        //Content button
        content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(HomeLanding.this, Content.class);
                startActivity(intent1);
            }
        });

        //FunFacts button
        funfacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(HomeLanding.this, FunFacts.class);
                startActivity(intent2);
            }
        });

        //Videos button
        videos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(HomeLanding.this, Videos.class);
                startActivity(intent3);
            }
        });

        //Quiz button
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(HomeLanding.this, QuizStory.class);
                startActivity(intent4);
            }
        });

        //Celestial Bodies button
        apibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentapi = new Intent(HomeLanding.this, SolarSystemLanding.class);
                startActivity(intentapi);
            }
        });
    }

}