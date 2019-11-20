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

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Button startGame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_view);

        startGame = findViewById(R.id.startGameButton);

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

        contentAdapter.setData(ContentDatabase.getAllMenuitems());
        recyclerView.setAdapter(contentAdapter);

        Intent intent1 = getIntent();

        //code to flash game button for UI
        Button gameButton = findViewById(R.id.startGameButton);
        Animation buttonFlash = new AlphaAnimation(0.0f, 1.0f);
        buttonFlash.setDuration(200);
        buttonFlash.setStartOffset(5);
        buttonFlash.setRepeatMode(Animation.ABSOLUTE);
        buttonFlash.setRepeatCount(10);
        gameButton.startAnimation(buttonFlash);


    }
}
