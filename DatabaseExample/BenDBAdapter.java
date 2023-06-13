package com.ben.databaseexamplemon;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BenDBAdapter extends RecyclerView.Adapter<BenDBAdapter.BenViewHolder> {

    //data?
    ArrayList<PhotoDBObject> data;
    Context context;

    PhotoDatabase database;

    public BenDBAdapter(Context context, ArrayList<PhotoDBObject> data){
        this.context = context;
        this.data = data;
        database = new PhotoDatabase(context, Constants.DB_NAME, null, 1);
    }

    @NonNull
    @Override
    public BenDBAdapter.BenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new BenDBAdapter.BenViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BenDBAdapter.BenViewHolder holder, int position) {
        PhotoDBObject photo= data.get(position);
        holder.tv_name.setText(photo.name);
        holder.tv_dec.setText(photo.des);
        holder.tv_year.setText(String.valueOf(2023));
        holder.tv_rating.setText("10/10");
        Glide.with(context).load(photo.img_url).into(holder.iv_poster);
//        holder.iv_poster.setImageResource(photo.imgId);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog alertDialog = new AlertDialog.Builder(context)
                        .setTitle("Do you want to add this picture?")
                        .setPositiveButton("Yes Please", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //data to the database
                                ContentValues photoData = new ContentValues();
                                photoData.put(Constants.COL_NAME, photo.name);
                                photoData.put(Constants.COL_DES, photo.des);
                                photoData.put(Constants.COL_IMG_URL, photo.img_url);
                                database.getWritableDatabase().insert(Constants.TABLE_NAME, null, photoData);

                            }
                        }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //do nothing

                            }
                        }).create();

                alertDialog.show();

            }
        });
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
        }
    }
}

