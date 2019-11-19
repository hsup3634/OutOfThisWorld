package com.example.outofthisworld;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuizStory extends AppCompatActivity {

    private TextView storyText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_story);

        storyText = findViewById(R.id.storyText);
        storyText.setText("You are the pilot of the Andromeda 14 Command Module. Earth's resources have been nearly depleted and the planet is being destroyed by global warming and natural disasters. The only hope is to find other planets to inhabit - and your mission is to successfully land on Mars and set up base for a new life. If you pass the quiz, you will successfully land on Mars and humanity will be saved. Fail - and your spaceship will crash and all hope will be lost ");

        Intent intent4 = getIntent();
    }

}