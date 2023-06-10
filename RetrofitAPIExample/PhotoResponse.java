package com.ben.retrofitapiexample;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PhotoResponse implements Serializable {

    @SerializedName("alt_description")
    public String des;

    @SerializedName("user")
    public User user;

    @SerializedName("urls")
    public Url urls;

}

class Url implements  Serializable{

    @SerializedName("regular")
    public String regular_size;

    @SerializedName("small")
    public String small_size;
}
