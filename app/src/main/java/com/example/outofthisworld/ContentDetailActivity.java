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

        //setting the UI layout file
        setContentView(R.layout.content_detail);

        //intent from the topic to the detail view using topicID and the position defined in the Hashmap in the contentdatabase class
        Intent intent = getIntent();
        Intent t1 = getIntent();
        int topicID = intent.getIntExtra("topicID", 0);
        ContentDetail contentDetail = ContentDatabase.getTopicById(topicID);

        //finding the corresponding UI elements
        content_title_textview = findViewById(R.id.content_title);
        content_image_imageview = findViewById(R.id.content_image);
        content_text_textview = findViewById(R.id.content_text);

        //setting the text, image and content body using the getters defined in ContentDetail
        content_title_textview.setText(contentDetail.getTitle());
        content_image_imageview.setImageResource(contentDetail.getImageDrawableId());
        content_text_textview.setText(contentDetail.getText());

    }

}

//reference: this code is based on tutorial activities - the NYT time which are derived from: https://github.com/amisrs/NYT/blob/master/app/src/main/java/com/example/nyt/activities/ArticleDetailActivity.java
