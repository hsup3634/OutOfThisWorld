package com.example.outofthisworld;

import java.util.ArrayList;

public class SolarResponse {


    //the Api stores the data in an array called bodies, so we want to store these results in an ArrayList which we can retrieve and use to populate the recycler view
    public void setBodies(ArrayList<SolarSystem> bodies) {
        this.bodies = bodies;
    }

    public ArrayList<SolarSystem> getBodies() {
        return bodies;
    }


    public ArrayList<SolarSystem> bodies;

}

