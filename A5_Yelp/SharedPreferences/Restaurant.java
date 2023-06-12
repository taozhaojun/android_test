package com.example.zhaojuntao_myyelp;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Restaurant implements Serializable {

    @SerializedName("name")
    public String name;

    @SerializedName("rating")
    public Float rating;

    @SerializedName("categories")
    public ArrayList<Categories> categories;

    @SerializedName("phone")
    public String phone;

    @SerializedName("location")
    public Location location;

    @SerializedName("price")
    public String price;

    @SerializedName("image_url")
    public String image_url;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Restaurant other = (Restaurant) obj;
        // Compare the unique identifier of the restaurants
        return Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}

class API_Return implements Serializable {
    @SerializedName("businesses")
    public ArrayList<Restaurant> businesses;

    @SerializedName("total")
    public int total;
}
