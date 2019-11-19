package com.example.outofthisworld;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ContentDetailActivity extends AppCompatActivity {

    private TextView content_title_textview;
    private ImageView content_image_imageview;
    private TextView content_text_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_detail);

        Intent intent = getIntent();
        Intent t1 = getIntent();
        int topicID = intent.getIntExtra("topicID", 0);
        ContentDetail contentDetail = ContentDatabase.getTopicById(topicID);

        content_title_textview = findViewById(R.id.content_title);
        content_image_imageview = findViewById(R.id.content_image);
        content_text_textview = findViewById(R.id.content_text);

        content_title_textview.setText(contentDetail.getTitle());
        content_image_imageview.setImageResource(contentDetail.getImageDrawableId());
        content_text_textview.setText(contentDetail.getText());

    }

}

