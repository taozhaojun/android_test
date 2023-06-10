package com.ben.retrofitapiexample;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserResponseObject implements Serializable {

    @SerializedName("id")
    public int userID;

    @SerializedName("avatar_url")
    public String userImgUrl;

    @SerializedName("name")
    public String name;
}
