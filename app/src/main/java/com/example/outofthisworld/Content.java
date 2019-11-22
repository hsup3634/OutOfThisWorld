package com.example.outofthisworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Content extends AppCompatActivity {

    //declaring the UI elements
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Button startGame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setting the layout xml file - content_view
        setContentView(R.layout.content_view);

        //instantiating the Button and directing it to the corresponding UI element
        startGame = findViewById(R.id.startGameButton);

        //this intent leads to the TopicSelectorGame class once the button is startGame button is clicked/pressed
        startGame.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Intent gameIntent = new Intent(Content.this, TopicSelectorGame.class);
                                             startActivity(gameIntent);
                                         }
                                     }
        );


        recyclerView = findViewById(R.id.rv_topics);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        ContentAdapter contentAdapter = new ContentAdapter();

        //getting the topics from the ContentDatabase and populating the recycler view with these items
        contentAdapter.setData(ContentDatabase.getAllMenuitems());
        recyclerView.setAdapter(contentAdapter);

        Intent intent1 = getIntent();

        //code to flash game button for UI
        //this code is derived from:https://stackoverflow.com/questions/9294112/how-to-make-the-textview-blinking?fbclid=IwAR2VttNDC6SVU-EbesS2mwT3jvMa0EYXj274zlpACNZffi8j1a_edTgLANI
        Button gameButton = findViewById(R.id.startGameButton);
        Animation buttonFlash = new AlphaAnimation(0.0f, 1.0f);
        buttonFlash.setDuration(200);
        buttonFlash.setStartOffset(5);
        buttonFlash.setRepeatMode(Animation.ABSOLUTE);
        buttonFlash.setRepeatCount(4);
        gameButton.startAnimation(buttonFlash);


    }
}

