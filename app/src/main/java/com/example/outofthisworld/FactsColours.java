package com.example.outofthisworld;

import android.annotation.SuppressLint;
import android.graphics.Color;

import java.util.Random;

public class FactsColours {

    public String[] colorsList = {
            //array of all the colour codes that the constraint layout will change to when the new fact button is pressed
            "#99ccff",
            "#3366ff",
            "#ff0000",
            "#ff00ff",
            "#66ff66",


    };

    //getter for colour
    public int getColor() {
        String color = "";

        //once again randomly selecting a fact
        Random randomGenerator = new Random(); // Construct a new Random number generator
        int randomNumber = randomGenerator.nextInt(colorsList.length);

        color = colorsList[randomNumber];
        @SuppressLint("Range") int colorAsInt = Color.parseColor(color);

        return colorAsInt;
    }
}

//this code is derived from: https://github.com/treehouse/android-fun-facts-github/blob/master/app/src/main/java/com/teamtreehouse/funfacts/ColorWheel.java
