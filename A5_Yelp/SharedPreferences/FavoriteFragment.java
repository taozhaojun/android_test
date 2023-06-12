package com.example.zhaojuntao_myyelp;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavoriteFragment extends Fragment {
    View view;
    ArrayList<Restaurant> favorites;
    RecyclerView rv_list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_favorite, container, false);
        //create link
        rv_list = view.findViewById(R.id.rv_list);

        //get data from sharedpreference
        //SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("MyPreferences", getContext().MODE_PRIVATE);
        String favoritesJson = sharedPreferences.getString("favorites", null);
        Log.e("Favorites JSON", favoritesJson);
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Restaurant>>() {}.getType();
        favorites = gson.fromJson(favoritesJson, type);


        FavoriteRecyclerAdapter myStyleRecyclerAdapter = new FavoriteRecyclerAdapter(getContext(), getActivity(),favorites);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rv_list.setAdapter(myStyleRecyclerAdapter);
        rv_list.setLayoutManager(manager);
        return view;

    }
}