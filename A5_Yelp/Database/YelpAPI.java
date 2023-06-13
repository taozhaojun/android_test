package com.example.zhaojuntao_myyelp;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface YelpAPI {

    @GET("businesses/search")
    Call<API_Return> getRestauranttList(@Query("location") String location,@Query("term") String term);
}