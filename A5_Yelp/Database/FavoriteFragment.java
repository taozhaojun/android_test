package com.example.zhaojuntao_myyelp;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FavoriteFragment extends Fragment {
    View view;
    ArrayList<RestaurantDBObject> favorites;
    RecyclerView rv_list;
    YelpDatabaseHelper database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_favorite, container, false);
        //create link
        rv_list = view.findViewById(R.id.rv_list);
        database = new YelpDatabaseHelper(getContext(), Constants.DB_NAME, null, 1);

        /*
        //get data from sharedpreference
        //SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("MyPreferences", getContext().MODE_PRIVATE);
        String favoritesJson = sharedPreferences.getString("favorites", null);
        Log.e("Favorites JSON", favoritesJson);
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Restaurant>>() {}.getType();
        favorites = gson.fromJson(favoritesJson, type);
        */

        //get data from database
        favorites = getDataFromDB();

        FavoriteRecyclerAdapter myStyleRecyclerAdapter = new FavoriteRecyclerAdapter(getContext(), getActivity(),favorites);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rv_list.setAdapter(myStyleRecyclerAdapter);
        rv_list.setLayoutManager(manager);
        return view;

    }
    private ArrayList<RestaurantDBObject> getDataFromDB(){
        // we show photos from database
        Cursor cursor = database.getReadableDatabase().query(
                Constants.TABLE_NAME, null,
                null, null, null, null, null
        );

//                    ArrayList<PhotoResponse> data = new ArrayList<>();
        favorites = new ArrayList<RestaurantDBObject>();

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow(Constants.COL_NAME)); // name
            Float rating = cursor.getFloat(cursor.getColumnIndexOrThrow(Constants.COL_RATING)); // rating
            String category = cursor.getString(cursor.getColumnIndexOrThrow(Constants.COL_CATEGORY)); // category
            String phone = cursor.getString(cursor.getColumnIndexOrThrow(Constants.COL_PHONE)); // category
            String address = cursor.getString(cursor.getColumnIndexOrThrow(Constants.COL_ADDRESS)); // category
            String price = cursor.getString(cursor.getColumnIndexOrThrow(Constants.COL_PRICE)); // category
            String img_url = cursor.getString(cursor.getColumnIndexOrThrow(Constants.COL_IMG_URL)); // url

            favorites.add(new RestaurantDBObject(name, rating,category,phone,address,price,img_url));
            cursor.moveToNext();
        }
        return favorites;
    }

}