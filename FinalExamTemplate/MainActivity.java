package com.julienb.assignment3_mobdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Bibliothèque");
    }

    public void mainMenuButtonClick(View view) {

        ImageButton imageButton = (ImageButton)view;

        String imageButtonId =  getResources().getResourceEntryName(view.getId());

        Intent intent = new Intent(this, BookListActivity.class);
        intent.putExtra("imageButtonId", imageButtonId);
        startActivity(intent);
    }
}