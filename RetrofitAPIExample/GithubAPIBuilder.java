package com.ben.retrofitapiexample;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubAPIBuilder {

    public static GithubAPI create(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/users/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

       return retrofit.create(GithubAPI.class);

    }
}
