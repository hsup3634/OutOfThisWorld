package com.example.outofthisworld;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class VideoTopic extends YouTubeBaseActivity {

    private static final String TAG = "VideoTopic";
    YouTubePlayerView video1;
    YouTubePlayer.OnInitializedListener ytListener;
    private TextView vidTitle;
    private TextView vidDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videos_topic);
        Log.d(TAG, "onCreate: Begin");

        //resources
        video1 = (YouTubePlayerView) findViewById(R.id.video1);
        vidTitle = findViewById(R.id.vidTitle);
        vidDesc = findViewById(R.id.vidDesc);

        //change later
        Intent intent4 = getIntent();
        int videoid = intent4.getExtras().getInt("examplesMap");
        int topicid = intent4.getIntExtra("TopicID", 0);
        Log.d(TAG, "onCreate: intent data retrieved");

        //add in content file
        ContentDetail youtubeContent = ContentDatabase.getVideoById(topicid);
        final String video = youtubeContent.getYoutubeVideo();
        final String vidtitle = youtubeContent.getYtTitle();
        final String viddesc = youtubeContent.getYtDescription();






        ytListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "Completed initialising");
                youTubePlayer.loadVideo(video);
                vidTitle.setText(vidtitle);
                vidDesc.setText(viddesc);
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
