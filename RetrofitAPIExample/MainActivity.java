package com.ben.retrofitapiexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView tv_name, tv_id;
    ImageView iv_pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        tv_name = findViewById(R.id.tv_name);
//        tv_id = findViewById(R.id.tv_id);
//        iv_pic = findViewById(R.id.imageView);
//
//
////        GithubAPIBuilder githubAPIBuilder = new GithubAPIBuilder();
//        GithubAPI api = GithubAPIBuilder.create();
//        Call<UserResponseObject> call = api.getUser();
//        Callback<UserResponseObject> callback = new Callback<UserResponseObject>() {
//            @Override
//            public void onResponse(Call<UserResponseObject> call, Response<UserResponseObject> response) {
//                UserResponseObject res = response.body();
//                tv_name.setText(res.name);
//                tv_id.setText(String.valueOf(res.userID));
//                Glide.with(MainActivity.this).load(res.userImgUrl).into(iv_pic);
//            }
//
//            @Override
//            public void onFailure(Call<UserResponseObject> call, Throwable t) {
//
//            }
//        };
//
//        call.enqueue(callback);

       SearchView searchView = findViewById(R.id.searchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

//        searchView.setOnSearchClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, searchView.getQuery(), Toast.LENGTH_SHORT).show();
//            }
//        });

        RecyclerView my_recycler = findViewById(R.id.my_recycler);

        Call<ArrayList<PhotoResponse>> call = UnsplashAPIBuilder.build().getPhotoList(4);
        call.enqueue(new Callback<ArrayList<PhotoResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<PhotoResponse>> call, Response<ArrayList<PhotoResponse>> response) {
                ArrayList<PhotoResponse> photos = response.body();
                BenStyleRecyclerAdapter benStyleRecyclerAdapter = new BenStyleRecyclerAdapter(getApplicationContext(), photos);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
                my_recycler.setAdapter(benStyleRecyclerAdapter);
                my_recycler.setLayoutManager(gridLayoutManager);

            }

            @Override
            public void onFailure(Call<ArrayList<PhotoResponse>> call, Throwable t) {

            }
        });




    }
}