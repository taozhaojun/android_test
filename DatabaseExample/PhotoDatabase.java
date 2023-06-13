package com.ben.databaseexamplemon;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class PhotoDatabase extends SQLiteOpenHelper {

    public PhotoDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Constants.TABLE_NAME +
                " (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Constants.COL_NAME + " TEXT, "
                + Constants.COL_DES + " TEXT, "
                + Constants.COL_IMG_URL + " TEXT);");

       // db.execSQL("CREATE TABLE photos (_id INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Des TEXT, Img_url TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //dont worry
    }
}
