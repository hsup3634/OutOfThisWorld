package com.example.outofthisworld;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SolarSystem {

    //this contains the variable we want to retrieve from the API
    private String id;
    @SerializedName("englishName")
    private String englishName;
    private int massExponent;
    private int volExponent;
    private double gravity;
    private double escape;
    private double equaRadius;
    private String discoveredBy;
    private String discoveryDate;
    public int num_results;

    //constructor for the variables
    public SolarSystem() {
        this.id = id;
        this.englishName = englishName;
        this.massExponent = massExponent;
        this.volExponent = volExponent;
        this.gravity = gravity;
        this.equaRadius = equaRadius;
        this.discoveredBy = discoveredBy;
        this.discoveryDate = discoveryDate;
        this.escape = escape;

    }

    //getters and setters
    public double getEscape() {
        return escape;
    }

    public void setEscape(double escape) {
        this.escape = escape;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public int getMassExponent() {
        return massExponent;
    }

    public void setMassExponent(int massExponent) {
        this.massExponent = massExponent;
    }

    public int getVolExponent() {
        return volExponent;
    }

    public void setVolExponent(int volExponent) {
        this.volExponent = volExponent;
    }

    public double getGravity() {
        return gravity;
    }

    public void setGravity(double gravity) {
        this.gravity = gravity;
    }

    public double getEquaRadius() {
        return equaRadius;
    }

    public void setEquaRadius(int equaRadius) {
        this.equaRadius = equaRadius;
    }

    public String getDiscoveredBy() {
        return discoveredBy;
    }

    public void setDiscoveredBy(String discoveredBy) {
        this.discoveredBy = discoveredBy;
    }

    public String getDiscoveryDate() {
        return discoveryDate;
    }

    public void setDiscoveryDate(String discoveryDate) {
        this.discoveryDate = discoveryDate;
    }

    private ArrayList<SolarSystem> solarsystem;

    public ArrayList<SolarSystem> getSolarsystem() {
        return solarsystem;
    }
}
