package com.example.outofthisworld;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Content extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_view);

        recyclerView = findViewById(R.id.rv_topics);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ContentAdapter contentAdapter = new ContentAdapter();

        contentAdapter.setData(ContentDatabase.getAllMenuitems());
        recyclerView.setAdapter(contentAdapter);

        Intent intent1 = getIntent();
    }
}
