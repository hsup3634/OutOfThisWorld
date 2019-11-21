package com.example.outofthisworld;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class VideoTopic extends YouTubeBaseActivity {


    //UI elements declaration
    YouTubePlayerView video1;
    YouTubePlayer.OnInitializedListener ytListener;
    private TextView vidTitle;
    private TextView vidDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setting layout file
        setContentView(R.layout.videos_topic);


        //resources
        video1 = (YouTubePlayerView) findViewById(R.id.video1);
        vidTitle = findViewById(R.id.vidTitle);
        vidDesc = findViewById(R.id.vidDesc);

        //intent from adapter to get the topic id and show the corresponding video
        Intent intent4 = getIntent();
        int topicid = intent4.getIntExtra("TopicID", 0);


        //uses hashmap info from the content database and populates the respective UI elements
        ContentDetail youtubeContent = ContentDatabase.getVideoById(topicid);
        final String video = youtubeContent.getYoutubeVideo();
        final String vidtitle = youtubeContent.getYtTitle();
        final String viddesc = youtubeContent.getYtDescription();


        ytListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            //if initialisation is successful load the youtube video, and set the texts based off the youtubemap hashmap
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(video);
                vidTitle.setText(vidtitle);
                vidDesc.setText(viddesc);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {


            }

        };

        //retrieves API key from the youtubekey file
        video1.initialize(YoutubeKey.getApiKey(), ytListener);

    }


}


//References: https://www.youtube.com/watch?v=bSMZknDI6bg
//https://spin.atomicobject.com/2019/06/24/embedding-youtube-videos-in-android-applications/
//API reference: https://developers.google.com/youtube/android/player

