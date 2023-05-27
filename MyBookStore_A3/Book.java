package com.example.zhaojuntao_mybookstore_a3;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
    private String title;
    private double unit_price;
    private int qty;


    public Book(String title,double price,int qty) {
        this.title = title;
        this.unit_price = price;
        this.qty = qty;
    }

    protected Book(Parcel in) {
        title = in.readString();
        unit_price = in.readDouble();
        qty = in.readInt();

    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public double getUnitPrice() {
        return unit_price;
    }

    public int getQty() {
        return qty;
    }
    public void setQty(int qty){
        this.qty = qty;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeDouble(unit_price);
        dest.writeInt(qty);
    }
}
