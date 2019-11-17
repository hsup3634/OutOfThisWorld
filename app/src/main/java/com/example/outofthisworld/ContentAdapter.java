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

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ContentViewHolder> {

    public ArrayList<ContentDetail> topicsToAdapt;

    public void setData(ArrayList<ContentDetail> topicsToAdapt) {

        this.topicsToAdapt = topicsToAdapt;

    }

    @NonNull
    @Override
    public ContentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.content_view_recyclerview, parent, false);

        // Then create an instance of your custom ViewHolder with the View you got from inflating
        // the layout.
        ContentViewHolder contentViewHolder = new ContentViewHolder(view);
        return contentViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContentViewHolder holder, int position) {
        final ContentDetail contentAtPosition = topicsToAdapt.get(position);

        holder.topicTextView.setText(contentAtPosition.getTitle());


        holder.topicTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

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


                // This constructor is used in onCreateViewHolder
                public ContentViewHolder(View v) {
                    super(v);  // runs the constructor for the ViewHolder superclass
                    view = v;
                    topicTextView = v.findViewById(R.id.topic_title1);
                }
            }
        }



