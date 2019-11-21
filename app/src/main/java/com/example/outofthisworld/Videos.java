package com.example.outofthisworld;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class Videos extends AppCompatActivity {
    //recycler view declaration
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videos_page);


        recyclerView = findViewById(R.id.rv_topics);


        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //creating instance of the yt adapter
        YoutubeAdapter ytAdapter = new YoutubeAdapter();

        //using setter to retrieve all the topic names
        ytAdapter.setData(ContentDatabase.getAllMenuitems());
        //displaying topic names in the recycler view - works the same as the contentadapter and content class
        recyclerView.setAdapter(ytAdapter);

        Intent intent3 = getIntent();


    }

    //once a topic is clicked, it takes the user to the detailed view (youtubeTopic) class to display the video
    public void vidTopicClick(View v) {
        View view = (View) findViewById(R.id.videoTitle);
        Context context = view.getContext();
        Intent intent4 = new Intent(context, VideoTopic.class);
        context.startActivity(intent4);

    }
}
