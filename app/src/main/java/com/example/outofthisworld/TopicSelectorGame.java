package com.example.outofthisworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class TopicSelectorGame extends AppCompatActivity {


    //declarations
    public static final Random randomTopic = new Random();
    private View game;
    private ImageView telescope;
    private int previousAngle = -1;


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
        Toast.makeText(this, "Touch the telescope to help you decide which topic to learn first!. Once it lands on a topic, go back and select it", Toast.LENGTH_LONG).show();


        ContentAdapter contentAdapter = new ContentAdapter();

    }

    //the telescope is an image view that is animated to rotate once it is clicked
    private void spinTheTelescope() {
        int angle = randomTopic.nextInt(3600 - 360) + 360;
        float pivotX = telescope.getWidth() / 2;
        float pivotY = telescope.getHeight() / 2;

        final Animation rotateTelescope = new RotateAnimation(previousAngle == -1 ? 0 : previousAngle, angle, pivotX, pivotY);
        previousAngle = angle;
        rotateTelescope.setDuration(2500);
        rotateTelescope.setFillAfter(true);

        telescope.startAnimation(rotateTelescope);
    }


}


//References:
//https://www.youtube.com/watch?v=c2gL2DcnWbI
// https://www.ssaurel.com/blog/learn-to-create-the-game-spin-the-bottle-on-android/