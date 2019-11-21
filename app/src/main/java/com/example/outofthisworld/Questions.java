package com.example.outofthisworld;

import java.io.Serializable;

public class Questions implements Serializable {


    private int id;
    private String ans;
    private String inc1;
    private String inc2;


    //constructor for the questions - each question has an id for question number, a correct answer followed by two incorrect answers
    public Questions(int id, String ans, String inc1, String inc2) {
        this.id = id;
        this.ans = ans;
        this.inc1 = inc1;
        this.inc2 = inc2;

    }

    //getters
    public int getId() {
        return id;
    }

    public String getAns() {
        return ans;
    }

    public String getInc1() {
        return inc1;
    }

    public String getInc2() {
        return inc2;
    }


}


