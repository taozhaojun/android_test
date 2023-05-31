package com.ben.listviewexample;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class User implements Parcelable {
    private String name;
    private int imgId;
    private double price;

    protected User(Parcel in) {
        name = in.readString();
        imgId = in.readInt();
        price = in.readDouble();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getImgId() {
        return imgId;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User(String name, int id, double price){
        this.name = name;
        this.imgId = id;
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(imgId);
        dest.writeDouble(price);
    }
}
