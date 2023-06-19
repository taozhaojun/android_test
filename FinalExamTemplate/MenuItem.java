package com.julienb.assignment3_mobdev;

// just a simple MenuItem class with a couple attributes
public class MenuItem {

    public String name, description, author, price, image;

    public MenuItem(String name,String author, String description, String price, String image){
        this.name = name;
        this.description = description;
        this.author = author;
        this.price = price;
        this.image = image;
    }

}
