package com.example.outofthisworld;

import android.annotation.SuppressLint;
import android.graphics.Color;

import java.util.Random;

public class FactsColours {

    public String[] mColors = {
            "#99ccff", // light blue
            "#3366ff", // dark blue
            "#9933ff", // purple
            "#ff0000", // red
            "#ff00ff", //pink
            "#66ff66", //green


    };

    // Method (abilities: things the object can do)
    public int getColor() {
        String color = "";

        // Randomly select a fact
        Random randomGenerator = new Random(); // Construct a new Random number generator
        int randomNumber = randomGenerator.nextInt(mColors.length);

        color = mColors[randomNumber];
        @SuppressLint("Range") int colorAsInt = Color.parseColor(color);

        return colorAsInt;
    }
}
