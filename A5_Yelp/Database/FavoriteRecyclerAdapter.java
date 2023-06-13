package com.example.zhaojuntao_myyelp;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FavoriteRecyclerAdapter extends RecyclerView.Adapter<FavoriteRecyclerAdapter.MyViewHolder> {

    //data?
    ArrayList<RestaurantDBObject> data;
    Context context;
    Activity activity;
    RestaurantDBObject restaurant;
    YelpDatabaseHelper database;


    public FavoriteRecyclerAdapter(Context context, Activity activity, ArrayList<RestaurantDBObject> data){
        this.context = context;
        this.data = data;
        this.activity = activity;
        database = new YelpDatabaseHelper(context, Constants.DB_NAME, null, 1);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        restaurant = data.get(position);
        holder.tv_title.setText(restaurant.name);
        holder.tv_phone.setText(restaurant.phone);
        holder.tv_price.setText(restaurant.price);
        holder.tv_category.setText(restaurant.category);
        holder.tv_address.setText(restaurant.address);
        holder.rb_rating.setRating(restaurant.rating);
        Glide.with(context).load(restaurant.img_url).into(holder.iv_image);
//      holder.iv_poster.setImageResource(photo.imgId);
        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context.getApplicationContext(), "item"+data.get(position).name, Toast.LENGTH_LONG).show();
                showConfirmationDialog(data.get(holder.getAdapterPosition()));
            }
        });
    }
    // Confirmation dialog creation:
    private void showConfirmationDialog(RestaurantDBObject restaurant) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Delete from favorite?");
        builder.setMessage("Do you want to delete this item from favorite?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //ADD to favorites by sharepreferences
                //addToFavorites(restaurant);

                //ADD to database
                deleteFromFavoritesByDatebase(restaurant);
            }
        });

        builder.setNegativeButton("NO", null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void deleteFromFavoritesByDatebase(RestaurantDBObject restaurant) {

        //detele data from database
        database.getWritableDatabase().delete(Constants.TABLE_NAME, Constants.COL_NAME+"= ?", new String[]{restaurant.name});
        // Refresh data in the RecyclerView
        if (context instanceof FragmentActivity) {
            FragmentActivity activity = (FragmentActivity) context;
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.fl_main, new FavoriteFragment()).commit();
        }
    }
    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title, tv_price, tv_category, tv_phone,tv_address;
        ImageView iv_image;
        RatingBar rb_rating;
        CardView card_view;

        public MyViewHolder(@NonNull View itemLayout) {
            super(itemLayout);
            tv_title = itemLayout.findViewById(R.id.tv_title);
            tv_price = itemLayout.findViewById(R.id.tv_price);
            rb_rating = itemLayout.findViewById(R.id.rb_rating);
            tv_category = itemLayout.findViewById(R.id.tv_category);
            tv_phone = itemLayout.findViewById(R.id.tv_phone);
            tv_address = itemLayout.findViewById(R.id.tv_address);
            iv_image = itemLayout.findViewById(R.id.iv_image);
            card_view = itemLayout.findViewById(R.id.card_view);


        }
    }

}