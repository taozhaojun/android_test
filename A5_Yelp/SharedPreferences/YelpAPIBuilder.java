package com.example.zhaojuntao_myyelp;
import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class YelpAPIBuilder {


    public static YelpAPI build(){

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @NonNull
                    @Override
                    public Response intercept(@NonNull Chain chain) throws IOException {
                        return chain.proceed(
                                chain.request().newBuilder()
                                        .addHeader("Authorization", "Bearer yzrx3pE0UOhR9tsZkMzsebAB9YeBoH7CMOoLRC-delVpHxEoE06-tihNC2KijZF2M3-7SVHk6FZj-vsF8RmCya321vIiwJWLK6M590IL3J70BCu-f2C0EeJj9N6DZHYx")
                                        .build()
                        );
                    }
                }).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.yelp.com/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();

        return retrofit.create(YelpAPI.class);

    }
}
