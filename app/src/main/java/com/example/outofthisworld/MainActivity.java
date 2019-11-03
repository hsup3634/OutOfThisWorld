package com.example.outofthisworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void homeClick (View v) {
        View view = (View) findViewById(R.id.home);
        Context context = view.getContext();
        Intent intent = new Intent(context, HomeLanding.class);
        context.startActivity(intent);




    }
}
