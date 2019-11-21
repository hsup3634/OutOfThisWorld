package com.example.outofthisworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class QuizEnd extends AppCompatActivity {

    TextView resultBox;
    TextView missionStatus;
    Button shareResult;
    Button exitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        resultBox = findViewById(R.id.resultBox);
        missionStatus = findViewById(R.id.missionStatus);
        shareResult = findViewById(R.id.sharebutton);
        exitBtn = findViewById(R.id.exitBtn);

        //storing the correct and incorrect answers that the user did in two different arrayLists so they can be used to calculate whether the mission has be passed or failed
        ArrayList<Questions> correct = (ArrayList<Questions>) getIntent().getSerializableExtra("correct");
        ArrayList<Questions> incorrect = (ArrayList<Questions>) getIntent().getSerializableExtra("incorrect");


        float results[] = {correct.size(), incorrect.size()};
        String enter[] = {"Correct!", "Incorrect:("};

        int value = correct.size();
        double dubValue = Double.valueOf(value);
        double resultValue = (double) (dubValue / 24.0);

        showResults(correct, incorrect, resultValue);

        //share code button reference at end of code
        shareResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String body = "Your body here";
                String sub = "Your subject";
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, sub);
                shareIntent.putExtra(Intent.EXTRA_TEXT, body);
                startActivity(Intent.createChooser(shareIntent, "Share Using"));

            }
        });

        //onClick listener so once exit button is pressed, it leads user back to the landing page
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exitIntent = new Intent(QuizEnd.this, HomeLanding.class);
                startActivity(exitIntent);
            }
        });


    }


    //simple if statements - if the user has passed the quiz the mission is successful, but if they fail, the mission fails and the rocket crashes
    public String grade(double result) {
        double quizResult = (result * 100.0);
        String quizMark;

        if (quizResult < 50) {
            quizMark = "MISSION FAILED! THE ROCKET CRASHED";
        } else {
            quizMark = "MISSION SUCCESSFUL! THE ROCKET LANDED SAFELY ON MARS";
        }
        return quizMark;
    }

    //this method is to display the users result but retrieving the correct ArrayList
    public void showResults(ArrayList<Questions> correct, ArrayList<Questions> incorrect, double result) {
        //get size of the correct array and display it out of 24
        String resultAnswer = correct.size() + " / 24.0";
        this.resultBox.setText(resultAnswer);

        //this retrieves the pass/fail status and sets it as the text based on what the user got
        String quizMark = grade(result);
        String mission = quizMark;
        missionStatus.setText(mission);


    }


}


//REFERENCES
//share button code derived from: https://www.stechies.com/add-share-button-android-app/


