package com.example.outofthisworld;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeLanding extends AppCompatActivity {

    Button content;
    Button flashcards;
    Button videos;
    Button quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);

        content = findViewById(R.id.content);
        flashcards = findViewById(R.id.flashcards);
        videos = findViewById(R.id.videos);
        quiz = findViewById(R.id.quiz);

        Intent intent = getIntent();
        Intent homeIntent = getIntent();
        Intent exitIntent = getIntent();

        content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(HomeLanding.this, Content.class);
                startActivity(intent1);
            }
        });

        flashcards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(HomeLanding.this, FunFacts.class);
                startActivity(intent2);
            }
        });

        videos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(HomeLanding.this, Videos.class);
                startActivity(intent3);
            }
        });

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(HomeLanding.this, QuizStory.class);
                startActivity(intent4);
            }
        });
    }

}