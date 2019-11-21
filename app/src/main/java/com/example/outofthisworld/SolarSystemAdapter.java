package com.example.outofthisworld;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class SolarSystemAdapter extends RecyclerView.Adapter<SolarSystemAdapter.SolarSystemViewHolder> {

    //arraylist that holds the data we want to adapt
    private ArrayList<SolarSystem> solarSystemToAdapt;
    private RecyclerView recycler;

    //setter to give data to the adapter
    public void setData(ArrayList<SolarSystem> solarSystemToAdapt) {
        this.solarSystemToAdapt = solarSystemToAdapt;

    }

    @NonNull
    @Override
    public SolarSystemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.solar_view_recyclerview, parent, false);

        SolarSystemViewHolder solarSystemViewHolder = new SolarSystemViewHolder(view);
        return solarSystemViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull SolarSystemViewHolder holder, int position) {
        final SolarSystem solarSystemAtPosition = solarSystemToAdapt.get(position);

        //setting the name of the item in the recycler view to hold the name of the celestial body
        holder.solarEnglishName.setText(solarSystemAtPosition.getEnglishName());


        //on click listener so when the name is clicked, it leads to the detailed view
        holder.solarEnglishName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                Intent intent = new Intent(context, SolarSystemDetail.class);
                //the items are linked through their IDs - to ensure the menu items and detailed views match up
                intent.putExtra("id", solarSystemAtPosition.getId());
                intent.putExtra("englishName", solarSystemAtPosition.getEnglishName());
                intent.putExtra("massExponent", solarSystemAtPosition.getMassExponent());
                intent.putExtra("escape", solarSystemAtPosition.getEscape());
                intent.putExtra("volExponent", solarSystemAtPosition.getVolExponent());
                intent.putExtra("gravity", solarSystemAtPosition.getGravity());
                intent.putExtra("equaRadius", solarSystemAtPosition.getEquaRadius());
                intent.putExtra("discoveredBy", solarSystemAtPosition.getDiscoveredBy());
                intent.putExtra("discoveryDate", solarSystemAtPosition.getDiscoveryDate());


                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return solarSystemToAdapt.size();
    }


    public static class SolarSystemViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView solarEnglishName;

        public SolarSystemViewHolder(View v) {
            super(v);
            view = v;
            solarEnglishName = v.findViewById(R.id.topic_title2);
        }

    }


}

//reference: this code is based on tutorial content and the NYT adapter: https://github.com/amisrs/NYT/blob/master/app/src/main/java/com/example/nyt/ArticleAdapter.java
//the key change to the code is that our class is not a fragment, but an activity

