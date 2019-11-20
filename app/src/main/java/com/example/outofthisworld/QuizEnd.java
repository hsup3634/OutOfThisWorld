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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        resultBox = findViewById(R.id.resultBox);
        missionStatus = findViewById(R.id.missionStatus);
        shareResult = findViewById(R.id.sharebutton);

        ArrayList<Questions> correct = (ArrayList<Questions>)getIntent().getSerializableExtra("correct");
        ArrayList<Questions> incorrect = (ArrayList<Questions>)getIntent().getSerializableExtra("incorrect");

        float results[] = {correct.size(), incorrect.size()};
        String enter[] = {"Correct!", "Incorrect:("};

        int value = correct.size();
        double dubValue = Double.valueOf(value);
        double resultValue = (double) (dubValue / 24.0);

        showResults(correct, incorrect, resultValue);

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


    }

    public void showResults (ArrayList<Questions> correct, ArrayList<Questions> incorrect, double result) {
        String resultAnswer = correct.size() + " / 24.0";
        this.resultBox.setText(resultAnswer);

        String quizMark = grade(result);
        String mission = quizMark;
        missionStatus.setText(mission);



    }

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
    }


//REFERENCES
//share button code derived from: https://www.stechies.com/add-share-button-android-app/


