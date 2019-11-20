package com.example.outofthisworld;

import android.annotation.SuppressLint;
import android.graphics.Color;

import java.util.Random;

public class FactsColours {

    public String[] mColors = {
            "#324856", // light blue
            "#4A746A", // dark blue
            "#D18237", // mauve
            "#D66C44", // red

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
