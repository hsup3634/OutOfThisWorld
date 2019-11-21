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

//this class is very similar to the content adapter class - same principles used to populate recycler view with the topic names

public class YoutubeAdapter extends RecyclerView.Adapter<YoutubeAdapter.YtViewHolder> {
    // Arraylist of data that we want to adapt
    public ArrayList<ContentDetail> topicsToAdapt;

    public void setData(ArrayList<ContentDetail> topicsToAdapt) {
        //Setter that we use to give data to the adapter
        this.topicsToAdapt = topicsToAdapt;

    }

    @NonNull
    @Override
    public YtViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.content_view_recyclerview, parent, false);


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


    @Override
    public int getItemCount() {
        return topicsToAdapt.size();
    }

    public static class YtViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView topicTextView;


        public YtViewHolder(View v) {
            super(v);
            view = v;
            topicTextView = v.findViewById(R.id.topic_title1);
        }
    }
}

//References: https://github.com/amisrs/NYT/blob/master/app/src/main/java/com/example/nyt/ArticleAdapter.java
