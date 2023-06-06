package com.ben.recyclercardexample;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BenStyleRecyclerAdapter extends RecyclerView.Adapter<BenStyleRecyclerAdapter.BenViewHolder> {

    //data?
    ArrayList<Movie> data;

    public BenStyleRecyclerAdapter(ArrayList<Movie> data){
        this.data = data;
    }

    @NonNull
    @Override
    public BenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new BenViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BenViewHolder holder, int position) {
        Movie movie= data.get(position);
        holder.tv_name.setText(movie.name);
        holder.tv_dec.setText(movie.dec);
        holder.tv_year.setText(String.valueOf(movie.year));
        holder.tv_rating.setText(movie.rating);
        holder.iv_poster.setImageResource(movie.imgId);

//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class BenViewHolder extends RecyclerView.ViewHolder{
        TextView tv_name, tv_year, tv_rating, tv_dec;
        ImageView iv_poster;

        CardView cardView;

        public BenViewHolder(@NonNull View itemLayout) {
            super(itemLayout);
            cardView = itemLayout.findViewById(R.id.card_view);
            tv_name = itemLayout.findViewById(R.id.tv_name);
            tv_year = itemLayout.findViewById(R.id.tv_year);
            tv_rating = itemLayout.findViewById(R.id.tv_rating);
            tv_dec = itemLayout.findViewById(R.id.tv_des);
            iv_poster = itemLayout.findViewById(R.id.imageView);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cardView.setBackgroundColor(Color.YELLOW);
                }
            });
        }
    }
}
