package com.example.zhaojuntao_mybookstore_a3;

import static com.example.zhaojuntao_mybookstore_a3.KeyValue.CATEGORY_KEY;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FrameLayout fl_fasion;
    FrameLayout fl_music;
    FrameLayout fl_computers;
    FrameLayout fl_cooking;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set action bar
        ActionBar myBar = getSupportActionBar();
        if (myBar != null){
            myBar.setTitle("Bibliothèque");
            myBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#6C3CC1")));
            int titleColor = Color.WHITE;
            SpannableString title = new SpannableString(myBar.getTitle());
            title.setSpan(new ForegroundColorSpan(titleColor), 0, title.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            myBar.setTitle(title);
        }
        //creat the link
        fl_fasion = findViewById(R.id.fl_fasion);
        fl_music = findViewById(R.id.fl_music);
        fl_computers = findViewById(R.id.fl_computers);
        fl_cooking = findViewById(R.id.fl_cooking);




        fl_fasion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BookListActivity.class);
                intent.putExtra(CATEGORY_KEY, "fasion");
                startActivity(intent);
            }
        });
        fl_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BookListActivity.class);
                intent.putExtra(CATEGORY_KEY, "music");
                startActivity(intent);
            }
        });
        fl_computers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BookListActivity.class);
                intent.putExtra(CATEGORY_KEY, "computers");
                startActivity(intent);
            }
        });
        fl_cooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BookListActivity.class);
                intent.putExtra(CATEGORY_KEY, "cooking");
                startActivity(intent);
            }
        });
    }
}