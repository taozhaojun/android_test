package com.ben.intentexample;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout cl_main;
    Button btn_click;
    boolean isMain = false;
    ImageView iv_delete;
    final String FILE_NAME = "my_preference";
    final String MY_KEY = "user_input";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar mybar = getSupportActionBar();

        cl_main = findViewById(R.id.cl_main);
        btn_click = findViewById(R.id.btnClick);
        iv_delete = findViewById(R.id.iv_delete);


        iv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // launch the third activity

                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);

                startActivity(intent);

//                finish();
            }
        });

        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int orientation = getResources().getConfiguration().orientation;
                if (orientation != Configuration.ORIENTATION_LANDSCAPE) {   //check current orientation

                    if (!isMain) {
                        cl_main.setBackgroundResource(R.drawable.inuyasha_main);
                        isMain = true;
                    } else {
                        cl_main.setBackgroundResource(R.drawable.inuyasha);
                        isMain = false;
                    }
                }else{

                }
            }
        });



        try{
            mybar.setTitle("My title");
        }catch (Exception e){

//            Toast.makeText(MainActivity.this, "Opps you have error here, the error is " + e.getMessage(), Toast.LENGTH_LONG).show();
            Log.e("My log", e.getMessage());
        }

        Log.e("BenTest", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        //load the preference
        SharedPreferences sf = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        String s = sf.getString(MY_KEY, "");

        if(!s.isEmpty()){
            if(s.equalsIgnoreCase("main")){
                cl_main.setBackgroundResource(R.drawable.inuyasha_main);
            }else{
                cl_main.setBackgroundResource(R.drawable.inuyasha);
            }
        }
        Log.e("BenTest", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("BenTest", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("BenTest", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("BenTest", "onStop");
    }

    @Override
    protected void onDestroy() {
        Log.e("BenTest", "onDestroy");
        //clear database
        super.onDestroy();

    }
}