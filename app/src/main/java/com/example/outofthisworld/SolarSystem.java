package com.example.outofthisworld;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SolarSystem {


    private int id;
    @SerializedName("englishName")
    private String englishName;
    private int massExponent;
    private int volExponent;
    private float gravity;
    private int equaRadius;
    private String discoveredBy;
    private String discoveryDate;
    public int num_results;


    public SolarSystem() {
        this.id = id;
        this.englishName = englishName;
        this.massExponent = massExponent;
        this.volExponent = volExponent;
        this.gravity = gravity;
        this.equaRadius = equaRadius;
        this.discoveredBy = discoveredBy;
        this.discoveryDate = discoveryDate;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public float getGravity() {
        return gravity;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    public int getEquaRadius() {
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

    public ArrayList<SolarSystem> getSolarsystem() {return solarsystem;}
}
