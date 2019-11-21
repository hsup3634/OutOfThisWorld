package com.example.outofthisworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuizStory extends AppCompatActivity {

    private TextView storyText;
    private Button startQuiz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_story);

        //setting the text button to the story of the mission
        storyText = findViewById(R.id.storyText);
        storyText.setText("You are the pilot of the Andromeda 14 Command Module. Earth's resources have been nearly depleted and the planet is being destroyed by global warming and natural disasters. The only hope is to find other planets to inhabit - and your mission is to successfully land on Mars and set up base for a new life. If you pass the quiz, you will successfully land on Mars and humanity will be saved. Fail - and your spaceship will crash and all hope will be lost ");

        Intent intent4 = getIntent();

        startQuiz = findViewById(R.id.startQuiz);

        //if the user clicks on the start mission button, it starts the quiz
        startQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startQuizIntent = new Intent(QuizStory.this, QuizInitialiser.class);
                startActivity(startQuizIntent);
            }
        });


    }

}