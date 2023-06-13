package com.ben.databaseexamplemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    PhotoDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SearchView searchView = findViewById(R.id.searchView);
        RecyclerView my_recycler = findViewById(R.id.my_recycler);

        database = new PhotoDatabase(this, Constants.DB_NAME, null, 1);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query.equalsIgnoreCase("show")) {
                    // we show photos from database
                    Cursor cursor = database.getReadableDatabase().query(
                            Constants.TABLE_NAME, null,
                            null, null, null, null, null
                    );

//                    ArrayList<PhotoResponse> data = new ArrayList<>();
                    ArrayList<PhotoDBObject> data = new ArrayList<>();

                    cursor.moveToFirst();

                    while (!cursor.isAfterLast()) {
                        String name = cursor.getString(cursor.getColumnIndexOrThrow(Constants.COL_NAME)); // name
                        String des = cursor.getString(cursor.getColumnIndexOrThrow(Constants.COL_DES)); // name
                        String img_url = cursor.getString(cursor.getColumnIndexOrThrow(Constants.COL_IMG_URL)); // name

//                        data.add(new PhotoResponse(name, des, img_url));

                        data.add(new PhotoDBObject(name, des, img_url));

                        cursor.moveToNext();
                    }

//                    BenStyleRecyclerAdapter benStyleRecyclerAdapter = new BenStyleRecyclerAdapter(MainActivity.this, data);
                    BenDBAdapter adapter = new BenDBAdapter(MainActivity.this, data);
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
                    my_recycler.setAdapter(adapter);
                    my_recycler.setLayoutManager(gridLayoutManager);

                } else if (query.equalsIgnoreCase("delete")) {
                    database.getWritableDatabase().delete(Constants.TABLE_NAME, null, null);

                } else {
                    Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();

                    Call<ArrayList<PhotoResponse>> call = UnsplashAPIBuilder.build().getPhotoList(Integer.parseInt(query));
                    call.enqueue(new Callback<ArrayList<PhotoResponse>>() {
                        @Override
                        public void onResponse(Call<ArrayList<PhotoResponse>> call, Response<ArrayList<PhotoResponse>> response) {
                            ArrayList<PhotoResponse> photos = response.body();
                            BenStyleRecyclerAdapter benStyleRecyclerAdapter = new BenStyleRecyclerAdapter(MainActivity.this, photos);
                            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
                            my_recycler.setAdapter(benStyleRecyclerAdapter);
                            my_recycler.setLayoutManager(gridLayoutManager);

                        }

                        @Override
                        public void onFailure(Call<ArrayList<PhotoResponse>> call, Throwable t) {

                        }
                    });

                }


                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
}