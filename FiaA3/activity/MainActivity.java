package com.example.fia_a3.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fia_a3.R;
import com.example.fia_a3.model.Constants;
import com.example.fia_a3.model.Utility;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clearSharedPreferences();

        LinearLayout llBiography = findViewById(R.id.ll_biography);
        LinearLayout llRomance = findViewById(R.id.ll_romance);
        LinearLayout llFiction = findViewById(R.id.ll_fiction);
        LinearLayout llPoem = findViewById(R.id.ll_poem);

        llBiography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBookListActivity(Constants.BIOGRAPHY);
            }
        });

        llRomance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBookListActivity(Constants.ROMANCE);
            }
        });

        llFiction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBookListActivity(Constants.FICTION);
            }
        });

        llPoem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBookListActivity(Constants.POEM);
            }
        });
    }

    private void openBookListActivity(String category) {
        Intent intent = new Intent(MainActivity.this, ListAndDetailActivity.class);
        intent.putExtra(Constants.CATEGORY_KEY, category);
        startActivity(intent);
    }
    private void clearSharedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        Utility.saveStringToSP(this, "itemList","");

    }
}
