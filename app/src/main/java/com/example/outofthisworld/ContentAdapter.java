package com.example.outofthisworld;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//stating that the adapter adapts to the custom ViewHolder - the ContentViewHolder
public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ContentViewHolder> {

    //this variable is an ArrayList that holds the data that we want to adapt
    public ArrayList<ContentDetail> topicsToAdapt;


    //setter to give data to the adapter
    public void setData(ArrayList<ContentDetail> topicsToAdapt) {

        this.topicsToAdapt = topicsToAdapt;

    }

    @NonNull
    @Override
    public ContentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    //creating a view from the layout file setting it so the recycler view can be inflated to hold the topic names
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.content_view_recyclerview, parent, false);

        //creating instance of ContentViewHolder
        ContentViewHolder contentViewHolder = new ContentViewHolder(view);
        return contentViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContentViewHolder holder, int position) {
        final ContentDetail contentAtPosition = topicsToAdapt.get(position);

        //setting text of the topic title UI element to get the title name from our fake database
        holder.topicTextView.setText(contentAtPosition.getTitle());


        holder.topicTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                //intent that leads user to the detail view once they click on the title name
                Intent intent = new Intent(context, ContentDetailActivity.class);
                intent.putExtra("topicID", contentAtPosition.getTopicID());
                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return topicsToAdapt.size();
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView topicTextView;


        //this constructor is used in the onCreateViewHolder
        public ContentViewHolder(View v) {
            super(v);
            view = v;
            //this references the UI element
            topicTextView = v.findViewById(R.id.topic_title1);
        }
    }
}


//this adapter class code has been derived from the code learnt in INFS3634 which is also based off the tutorial NYT app: https://github.com/amisrs/NYT/blob/master/app/src/main/java/com/example/nyt/ArticleAdapter.java
