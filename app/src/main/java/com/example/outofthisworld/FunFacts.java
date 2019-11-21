package com.example.outofthisworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class FunFacts extends AppCompatActivity {

    private Facts factsList = new Facts();
    private FactsColours factsColours = new FactsColours();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.facts);

        //retrieving UI element IDs
        final TextView factText = (TextView) findViewById(R.id.factTextView);
        final Button factButton = (Button) findViewById(R.id.showFactButton);
        final ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);

        //intent from HomeLanding page
        Intent intent2 = getIntent();

        //retrieves fact once clicked
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fact = factsList.getFact();
                factText.setText(fact);

                //changing colour once button is clicked as well
                int color = factsColours.getColor();
                constraintLayout.setBackgroundColor(color);
                factButton.setTextColor(color);
            }
        };
        factButton.setOnClickListener(listener);
    }
}

//reference: this code is derived from: https://github.com/treehouse/android-fun-facts-github/blob/master/app/src/main/java/com/teamtreehouse/funfacts/FunFactsActivity.java