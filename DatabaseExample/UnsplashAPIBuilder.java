package com.ben.databaseexamplemon;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UnsplashAPIBuilder {


    public static UnsplashAPI build(){

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @NonNull
                    @Override
                    public Response intercept(@NonNull Chain chain) throws IOException {
                        return chain.proceed(
                                chain.request().newBuilder()
                                        .addHeader("Authorization", "Client-ID trWgowJtoIgmcUCz_yDK7FwW332J-9wlEpZSMNqJQYs")
                                        .build()
                                );
                    }
                }).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.unsplash.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();

        return retrofit.create(UnsplashAPI.class);

    }
}
