package com.ben.databaseexamplemon;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PhotoResponse implements Serializable {

    @SerializedName("alt_description")
    public String des;

    @SerializedName("user")
    public User user;

    @SerializedName("urls")
    public Url urls;

    public PhotoResponse(String name, String des, String url){
        this.des = des;
        this.user = new User(name);
        this.urls = new Url(url);

    }
}

class Url implements Serializable {

    @SerializedName("regular")
    public String regular_size;

    @SerializedName("small")
    public String small_size;

    public Url(String img_url){
        this.small_size = img_url;
    }
}


class User implements Serializable {

    @SerializedName("name")
    public String name;

    public User(String name){
        this.name = name;
    }
}
