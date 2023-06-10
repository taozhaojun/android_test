package com.ben.retrofitapiexample;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GithubAPI {

    @GET("Drishti-rawal")
    Call<UserResponseObject> getUser();

}
