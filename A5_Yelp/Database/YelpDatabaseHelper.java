package com.example.zhaojuntao_myyelp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class YelpDatabaseHelper extends SQLiteOpenHelper{
    public YelpDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Constants.TABLE_NAME +
                " ("
                + Constants.COL_NAME+" TEXT PRIMARY KEY, "
                + Constants.COL_RATING + " REAL, "
                + Constants.COL_CATEGORY + " TEXT, "
                + Constants.COL_PHONE + " TEXT, "
                + Constants.COL_ADDRESS + " TEXT, "
                + Constants.COL_PRICE + " TEXT, "
                + Constants.COL_IMG_URL + " TEXT);");

        // db.execSQL("CREATE TABLE photos (_id INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Des TEXT, Img_url TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //dont worry
    }
}
