package com.example.zhaojuntao_myyelp;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Location implements Serializable {
    @SerializedName("address1")
    public String address1;

    @SerializedName("city")
    public String city;

    @SerializedName("state")
    public String state;
}
