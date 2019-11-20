package com.example.outofthisworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class FunFacts extends AppCompatActivity {

    private Facts mFactBook = new Facts();
    private FactsColours mColorWheel = new FactsColours();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.facts);

        final TextView factLabel = (TextView) findViewById(R.id.factTextView);
        final Button showFactButton = (Button) findViewById(R.id.showFactButton);
        final ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.relativelayout);

        Intent intent2 = getIntent();

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fact = mFactBook.getFact();
                factLabel.setText(fact);

                int color = mColorWheel.getColor();
                constraintLayout.setBackgroundColor(color);
                showFactButton.setTextColor(color);
            }
        };
        showFactButton.setOnClickListener(listener);
    }
}
