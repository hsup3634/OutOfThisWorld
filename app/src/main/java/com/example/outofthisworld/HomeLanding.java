package com.example.outofthisworld;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class HomeLanding extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);


        Intent intent = getIntent();


    }


    public void contentClick(View v) {
        View view = (View) findViewById(R.id.content);
        Context context = view.getContext();
        Intent intent1 = new Intent(context, Content.class);
        context.startActivity(intent1);

    }

    public void flashClick(View v) {
        View view = (View) findViewById(R.id.flashcards);
        Context context = view.getContext();
        Intent intent2 = new Intent(context, Flashcards.class);
        context.startActivity(intent2);

    }

    public void vidClick(View v) {
        View view = (View) findViewById(R.id.videos);
        Context context = view.getContext();
        Intent intent3 = new Intent(context, Videos.class);
        context.startActivity(intent3);

    }

    public void quizClick(View v) {
        View view = (View) findViewById(R.id.quiz);
        Context context = view.getContext();
        Intent intent4 = new Intent(context, Quiz.class);
        context.startActivity(intent4);

    }
}