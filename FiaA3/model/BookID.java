package com.example.fia_a3.model;

import android.util.Log;

public class BookID {
    private String title;
    private String desc;
    private String author;
    private int image;
    private double price;
    private int qty;
    private static final String TAG = "BookID";
    public BookID(String title, String desc, String author, int image, double price, int qty) {
        this.title = title;
        this.desc = desc;
        this.author = author;
        this.image = image;
        this.price = price;
        this.qty = qty;

        Log.d(TAG, "BookID: initial");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getAuthor() {
        return author;
    }
}
