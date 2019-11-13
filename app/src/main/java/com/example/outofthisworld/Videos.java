package com.example.outofthisworld;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Map;

public class Videos extends AppCompatActivity {
    private static final String TAG = "Videos";
    //add in recycler view declaration
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videos_page);
        Log.d(TAG, "onCreate: Starting");

        //findid of recyclerview

        recyclerView = findViewById(R.id.rv_topics);
//
//        ArrayList<ContentDetail> ytMap = new ArrayList<>();
//        for (Map.Entry<Integer, ContentDetail> e: ContentDatabase.youtubeVidMap.entrySet()) {
//            ytMap.add(e.getValue());
//        }
//
//        final ArrayAdapter<ContentDetail> ytAdapter = new ArrayAdapter<>(this, R.layout.videos_page, ytMap);
//        recyclerView.setAdapter(ytAdapter);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        YoutubeAdapter ytAdapter = new YoutubeAdapter();

        ytAdapter.setData(ContentDatabase.getAllMenuitems());
        recyclerView.setAdapter(ytAdapter);

        Intent intent3 = getIntent();

        //int topicID = intent3.getIntExtra("topicID", 0);

        //ContentDetail contentDetail = ContentDatabase.getTopicById(topicID);

    }

    public void vidTopicClick(View v) {
        View view = (View) findViewById(R.id.videoTitle);
        Context context = view.getContext();
        Intent intent4 = new Intent(context, VideoTopic.class);
        context.startActivity(intent4);

    }
}
