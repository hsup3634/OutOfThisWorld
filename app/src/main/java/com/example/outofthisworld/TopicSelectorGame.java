package com.example.outofthisworld;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class TopicSelectorGame extends AppCompatActivity {


    //declerations
    public static final Random randomTopic = new Random();
    private View game;
    private ImageView telescope;
    private int previousAngle = -1;
    private TextView topic1;
    private TextView topic2;
    private TextView topic3;
    private TextView topic4;
    private TextView topic5;
    private TextView topic6;


    //code to spin the telescope
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spin_the_telescope);
        Intent gameIntent = getIntent();
        game = findViewById(R.id.gamebackground);
        telescope = findViewById(R.id.telescope);

        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinTheTelescope();
            }
        });
        Toast.makeText(this, "Touch the telescope to help you decide which topic to learn first!", Toast.LENGTH_SHORT).show();

//
//        topic1 = findViewById(R.id.topic);
//        topic2 = findViewById(R.id.topic2Text);
//        topic3 = findViewById(R.id.topic3Text);
//        topic4 = findViewById(R.id.topic4Text);
//        topic5 = findViewById(R.id.topic5Text);
//        topic6 = findViewById(R.id.topic6Text);


        ContentAdapter contentAdapter = new ContentAdapter();


//todo fix adapter stuff here so it links to the correct topic - may have to create a new adapter
//        topic1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent t1 = new Intent(TopicSelectorGame.this, ContentDetailActivity.class);
//                startActivity(t1);
//            }
//        });

    }

    private void spinTheTelescope() {
        int angle = randomTopic.nextInt(3600-360) + 360;
        float pivotX= telescope.getWidth()/2;
        float pivotY= telescope.getHeight()/2;

        final Animation rotateTelescope = new RotateAnimation(previousAngle == -1 ? 0 : previousAngle, angle, pivotX, pivotY);
        previousAngle = angle;
        rotateTelescope.setDuration(2500);
        rotateTelescope.setFillAfter(true);

        telescope.startAnimation(rotateTelescope);
    }


}



//Referencing:
//https://www.youtube.com/watch?v=c2gL2DcnWbI
// https://www.ssaurel.com/blog/learn-to-create-the-game-spin-the-bottle-on-android/