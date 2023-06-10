package com.ben.retrofitapiexample;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface UnsplashAPI {

    @GET("photos")
    Call<ArrayList<PhotoResponse>> getPhotoList(@Query("per_page") int perPage);


    @GET("photos/random")
    Call<ArrayList<PhotoResponse>> getRandomPhoto();
}
