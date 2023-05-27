package com.example.zhaojuntao_mybookstore_a3;

import java.util.ArrayList;

public class CartData {
    private static ArrayList<Book> cartItems = new ArrayList<>();

    public static ArrayList<Book> getCartItems() {
        return cartItems;
    }

    public static void setCartItems(ArrayList<Book> items) {
        cartItems = items;
    }
}
