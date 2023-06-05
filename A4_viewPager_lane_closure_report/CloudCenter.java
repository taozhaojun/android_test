package com.example.zhaojuntao_a4;

import java.util.ArrayList;

public class CloudCenter {
    public static ArrayList<String> selecteditem = new ArrayList<String>();
    public static ArrayList<String> group1_items = new ArrayList<String>();
    public static ArrayList<String> group2_items = new ArrayList<String>();
    static {
        // Add items to group1_items in a static initializer block
        group1_items.add("Shoulder");
        group1_items.add("Hov");
        group1_items.add("Median");
        group1_items.add("Ramp");
        group1_items.add("Gore");
        group2_items.add("Closed");
        group2_items.add("Unknown");
        group2_items.add("Rolling");
        group2_items.add("Blocked");
        group2_items.add("Alternating");
        group2_items.add("Intermittent");
        group2_items.add("Lanes affected");
    }

}
