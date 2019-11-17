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

public class YoutubeAdapter extends RecyclerView.Adapter<YoutubeAdapter.YtViewHolder> {
    // class variable that holds the data that we want to adapt
    public ArrayList<ContentDetail> topicsToAdapt;

    public void setData(ArrayList<ContentDetail> topicsToAdapt) {
        // This is basically a Setter that we use to give data to the adapter
        this.topicsToAdapt = topicsToAdapt;

    }

    @NonNull
    @Override
    public YtViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.content_view_recyclerview, parent, false);

        // Then create an instance of your custom ViewHolder with the View you got from inflating
        // the layout.
        YtViewHolder ytViewHolder = new YtViewHolder(view);
        return ytViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull YtViewHolder holder, int position) {
        final ContentDetail contentAtPosition = topicsToAdapt.get(position);

        holder.topicTextView.setText(contentAtPosition.getTitle());


        holder.topicTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                Intent intent = new Intent(context, VideoTopic.class);
                intent.putExtra("TopicID", contentAtPosition.getTopicID());
                context.startActivity(intent);
            }
        });

    }



    // ViewHolder represents one item, but doesn't have data when it's first constructed.
    // We assign the data in onBindViewHolder.

    @Override
    public int getItemCount() {
        return topicsToAdapt.size();
    }

    public static class YtViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView topicTextView;


        // This constructor is used in onCreateViewHolder
        public YtViewHolder(View v) {
            super(v);  // runs the constructor for the ViewHolder superclass
            view = v;
            topicTextView = v.findViewById(R.id.topic_title1);
        }
    }
}



