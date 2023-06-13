package com.example.zhaojuntao_myyelp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends Fragment {
    ArrayList<Restaurant> data;
    View view;
    SearchView searchView;
    Spinner sp_sort;
    RecyclerView rv_list;

    // Custom Comparator to compare Restaurant objects based on their ratings
    Comparator<Restaurant> ratingComparator = new Comparator<Restaurant>() {
        @Override
        public int compare(Restaurant restaurant1, Restaurant restaurant2) {
            Float rating1 = restaurant1.rating;
            Float rating2 = restaurant2.rating;
            // Handle null ratings by placing them at the bottom
            if (rating1 == null && rating2 == null) {
                return 0;
            } else if (rating1 == null) {
                return 1;
            } else if (rating2 == null) {
                return -1;
            }

            // Compare the ratings in descending order
            return Float.compare(rating2, rating1);
        }
    };

    // Custom Comparator to compare Restaurant objects based on their price
    Comparator<Restaurant> priceComparator = new Comparator<Restaurant>() {
        @Override
        public int compare(Restaurant restaurant1, Restaurant restaurant2) {
            String price1 = restaurant1.price;
            String price2 = restaurant2.price;

            // Handle unavailable price information by placing them at the top
            if (price1 == null && price2 == null) {
                return 0;
            } else if (price1 == null) {
                return -1;
            } else if (price2 == null) {
                return 1;
            }
            int price1_length = price1.length();
            int price2_length = price2.length();
            // Compare the prices in ascending order
            return Integer.compare(price1_length, price2_length);
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_main, container, false);
        //create link
        searchView = view.findViewById(R.id.searchView);
        sp_sort = view.findViewById(R.id.sp_sort);
        rv_list = view.findViewById(R.id.rv_list);

        //search view
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                //submit a new query with term
                Call<API_Return> call = YelpAPIBuilder.build().getRestauranttList("montreal",query);
                call.enqueue(new Callback<API_Return>() {
                    @Override
                    public void onResponse(Call<API_Return> call, Response<API_Return> response) {
                        API_Return api_return = response.body();
                        data = api_return.businesses;
                        //Toast.makeText(getApplicationContext(), data.size() + " hello", Toast.LENGTH_SHORT).show();
                        //sort data by:
                        if (sp_sort.getSelectedItemPosition() == 0){
                            Collections.sort(data, ratingComparator);
                        }else if(sp_sort.getSelectedItemPosition() == 1){
                            Collections.sort(data, priceComparator);
                        }
                        MyStyleRecyclerAdapter myStyleRecyclerAdapter = new MyStyleRecyclerAdapter(getContext(), getActivity(),data);
                        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                        rv_list.setAdapter(myStyleRecyclerAdapter);
                        rv_list.setLayoutManager(manager);
                    }

                    @Override
                    public void onFailure(Call<API_Return> call, Throwable t) {

                    }
                });

                //Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        //API
        Call<API_Return> call = YelpAPIBuilder.build().getRestauranttList("montreal","ramen");
        call.enqueue(new Callback<API_Return>() {
            @Override
            public void onResponse(Call<API_Return> call, Response<API_Return> response) {
                if (response.isSuccessful()) {
                    API_Return api_return = response.body();
                    data = api_return.businesses;
                    //sort data by both:
                    if (sp_sort.getSelectedItemPosition() == 0){
                        Collections.sort(data, ratingComparator);
                    }else if(sp_sort.getSelectedItemPosition() == 1){
                        Collections.sort(data, priceComparator);
                    }

                    //Toast.makeText(getApplicationContext(), data.size() + " hello", Toast.LENGTH_SHORT).show();

                    MyStyleRecyclerAdapter myStyleRecyclerAdapter = new MyStyleRecyclerAdapter(getContext(), getActivity(),data);
                    LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                    rv_list.setAdapter(myStyleRecyclerAdapter);
                    rv_list.setLayoutManager(manager);
                } else {
                    // Print the response body in case of unsuccessful response
                    try {
                        String responseBody = response.errorBody().string();
                        Log.e("Response Body", responseBody);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<API_Return> call, Throwable t) {
                String errorMessage = t.getMessage();
                Log.e("API Failure", errorMessage);
                Toast.makeText(getContext(), "API Failure"+t.getCause(), Toast.LENGTH_LONG).show();

            }
        });

        //set spinner value
        String[] sp_value = {"Rating","Price"};
        ArrayAdapter<String> adapter = new ArrayAdapter(getContext(), R.layout.my_spinner_item, sp_value);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_sort.setAdapter(adapter);
        //get result
        sp_sort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    //test
                    //Toast.makeText(getApplicationContext(), "rating", Toast.LENGTH_LONG).show();
                    //sort data by rating

                    // Sort the data ArrayList using the ratingComparator
                    if(data != null){
                        Collections.sort(data, ratingComparator);
                        // show data in recycler view
                        MyStyleRecyclerAdapter myStyleRecyclerAdapter = new MyStyleRecyclerAdapter(getContext(), getActivity(),data);
                        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                        rv_list.setAdapter(myStyleRecyclerAdapter);
                        rv_list.setLayoutManager(manager);
                    }


                }else if(position == 1){
                    //test
                    //Toast.makeText(getApplicationContext(), "price", Toast.LENGTH_LONG).show();
                    //sort by Price

                    if (data != null){
                        // Sort the data ArrayList using the priceComparator
                        Collections.sort(data, priceComparator);
                        // show data in recycler view
                        MyStyleRecyclerAdapter myStyleRecyclerAdapter = new MyStyleRecyclerAdapter(getContext(), getActivity(),data);
                        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                        rv_list.setAdapter(myStyleRecyclerAdapter);
                        rv_list.setLayoutManager(manager);
                    }

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return view;
    }
}