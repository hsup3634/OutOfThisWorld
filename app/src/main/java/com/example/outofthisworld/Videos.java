package com.example.outofthisworld;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Videos extends AppCompatActivity {
    private static final String TAG = "Videos";
    //add in recycler view declaration

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videos_page);
        Log.d(TAG, "onCreate: Starting");

        //findid of recyclerview

        Intent intent3 = getIntent();
    }

    public void vidTopicClick(View v) {
        View view = (View) findViewById(R.id.videoTitle);
        Context context = view.getContext();
        Intent intent4 = new Intent(context, VideoTopic.class);
        context.startActivity(intent4);

    }
}
