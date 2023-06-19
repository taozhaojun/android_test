package com.julienb.assignment3_mobdev;

// Just a simple cart entry class with a couple of attributes
public class CartEntry {

    public String name,  price;
    public int quantity = 0;

    public CartEntry(String name, int quantity, String price){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
