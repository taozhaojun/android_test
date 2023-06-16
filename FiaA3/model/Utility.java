package com.example.fia_a3.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

public class Utility {
    private static final String TAG = "Utility";

    public static void saveStringToSP(Context context, String key, String value) {
        // Replace "your_preference_name" with your preferred preference file name
        SharedPreferences preferences = context.getSharedPreferences("your_preference_name", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
        Log.d(TAG, "saveStringToSP: ");
    }

    public static String getStringFromSP(Context context, String key) {
        // Replace "your_preference_name" with your preferred preference file name
        SharedPreferences preferences = context.getSharedPreferences("your_preference_name", Context.MODE_PRIVATE);
        Log.d(TAG, "getStringFromSP: key: " + key);
        return preferences.getString(key, "");
    }
}


