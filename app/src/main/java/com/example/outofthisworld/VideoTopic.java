package com.example.outofthisworld;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoTopic extends YouTubeBaseActivity {

    private static final String TAG = "VideoTopic";
    YouTubePlayerView video1;
    YouTubePlayer.OnInitializedListener ytListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videos_topic);
        Log.d(TAG, "onCreate: Begin");

        //resources
        video1 = (YouTubePlayerView)findViewById(R.id.video1);
        //change later
        Intent intent4 = getIntent();
        int videoID = intent4.getExtras().getInt("examplesMap");
        Log.d(TAG, "onCreate: intent data retrieved");

        //add in content file
        ContentDetail youtubeContent = ContentDatabase.getVideoById(videoID);
        final String video = youtubeContent.getYoutubeVideo();



        ytListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "Completed initialising");
                youTubePlayer.loadVideo(video);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "failed initialising");

            }

        };

        Log.d(TAG, "initialising");
        video1.initialize(YoutubeKey.getApiKey(), ytListener);

    }








}
