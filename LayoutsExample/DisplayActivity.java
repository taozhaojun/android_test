package com.ben.layoutsexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        String[] data = {"Ben", "Bassel", "Fia", "Anna", "Rolande"};
        int[] age= {25, 30, 30, 30, 30};

        Intent intent = getIntent();

        TextView tv_display = findViewById(R.id.tv_display);

        int pos = intent.getIntExtra("position_key", 0);

        tv_display.setText(data[pos] + " : " + age[pos]);


    }
}