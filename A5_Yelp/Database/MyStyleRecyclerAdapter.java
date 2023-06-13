package com.example.zhaojuntao_myyelp;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MyStyleRecyclerAdapter extends RecyclerView.Adapter<MyStyleRecyclerAdapter.MyViewHolder> {

    //data?
    ArrayList<Restaurant> data;
    ArrayList<Restaurant> favorites;
    Context context;
    Activity activity;
    Restaurant restaurant;
    SharedPreferences sf;
    final String FILE_NAME = "my_preference";
    final String RES_KEY = "favorites";

    YelpDatabaseHelper database;

    public MyStyleRecyclerAdapter(Context context, Activity activity, ArrayList<Restaurant> data){
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
        holder.tv_category.setText(Html.fromHtml("&bull; ")+restaurant.categories.get(0).title);
        holder.tv_address.setText(restaurant.location.address1+","+restaurant.location.city+","+restaurant.location.state);
        holder.rb_rating.setRating(restaurant.rating);
        Glide.with(context).load(restaurant.image_url).into(holder.iv_image);
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
    private void showConfirmationDialog(Restaurant restaurant) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Add to favorite?");
        builder.setMessage("Do you want to add this item to favorite?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //ADD to favorites by sharepreferences
                //addToFavorites(restaurant);

                //ADD to database
                addToFavoritesByDatebase(restaurant);
            }
        });

        builder.setNegativeButton("NO", null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }
    // Adding restaurant to favorites:
    private void addToFavorites(Restaurant restaurant) {
        // Get data from SharedPreferences
        SharedPreferences sharedPreferences = context.getSharedPreferences("MyPreferences", context.MODE_PRIVATE);
        String favoritesJson = sharedPreferences.getString("favorites", null);
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Restaurant>>() {}.getType();
        favorites = gson.fromJson(favoritesJson, type);

        // Check if the restaurant already exists in favorites
        if (favorites == null) {
            favorites = new ArrayList<>();
        } else if (favorites.contains(restaurant)) {
            // Restaurant already exists in favorites, so no need to add it again
            return;
        }

        // Add the restaurant to favorites
        favorites.add(restaurant);
        //favorites.clear();
        // Serialize favorites list to JSON
        favoritesJson = gson.toJson(favorites);

        // Store the updated favorites list in SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(RES_KEY, favoritesJson);
        editor.apply();
    }

    // Adding restaurant to favorites by database:
    private void addToFavoritesByDatebase(Restaurant restaurant) {

        //add data to the database, name is primary key to avoid duplicated
        ContentValues res_data = new ContentValues();
        res_data.put(Constants.COL_NAME, restaurant.name);
        res_data.put(Constants.COL_RATING, restaurant.rating);
        res_data.put(Constants.COL_CATEGORY, Html.fromHtml("&bull; ")+restaurant.categories.get(0).title);
        res_data.put(Constants.COL_PHONE, restaurant.phone);
        res_data.put(Constants.COL_ADDRESS, restaurant.location.address1+","+restaurant.location.city+","+restaurant.location.state);
        res_data.put(Constants.COL_PRICE, restaurant.price);
        res_data.put(Constants.COL_IMG_URL, restaurant.image_url);
        database.getWritableDatabase().insert(Constants.TABLE_NAME, null, res_data);

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