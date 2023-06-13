package com.example.zhaojuntao_myyelp;

public class RestaurantDBObject {
    String name;
    Float rating;
    String category;
    String phone;
    String address;
    String price;
    String img_url;

    public RestaurantDBObject(String name, Float rating, String category, String phone, String address, String price, String img_url) {
        this.name = name;
        this.rating = rating;
        this.category = category;
        this.phone = phone;
        this.address = address;
        this.price = price;
        this.img_url = img_url;
    }
}
