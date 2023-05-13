package com.example.myfavoritecomic;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout cl_main;
    ImageView btn_setting;
    TextView tv_infor;
    TextView tv_title;
    final String FILE_NAME = "my_preference";
    final String BG_KEY = "bg_key";
    final String TC_KEY = "tc_key";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        ActionBar myBar = getSupportActionBar();
        if (myBar != null){
            myBar.setTitle("Assignment 2");
            myBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#6C3CC1")));
            int titleColor = Color.WHITE;
            SpannableString title = new SpannableString(myBar.getTitle());
            title.setSpan(new ForegroundColorSpan(titleColor), 0, title.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            myBar.setTitle(title);
        }
         */
        cl_main = findViewById(R.id.cl_main);
        btn_setting = findViewById(R.id.btn_setting);
        tv_infor = findViewById(R.id.tv_infor);
        tv_title = findViewById(R.id.tv_title);

        btn_setting.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,SettingActivity.class);
            startActivity(intent);
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        //load the preference
        SharedPreferences sf = getSharedPreferences(FILE_NAME,MODE_PRIVATE);
        String bg = sf.getString(BG_KEY,"");
        String tc = sf.getString(TC_KEY,"");
        if(!bg.isEmpty()){
            if (bg.equalsIgnoreCase("Default"))
            {
                cl_main.setBackgroundResource(R.drawable.primary);
            }
            else if (bg.equalsIgnoreCase("Warm"))
            {
                cl_main.setBackgroundResource(R.drawable.warm);
            }
            else if (bg.equalsIgnoreCase("Cold")){
                cl_main.setBackgroundResource(R.drawable.cold);
            }
            else if (bg.equalsIgnoreCase("Horror")){
                cl_main.setBackgroundResource(R.drawable.horror);
            }
        }
        //set text color
        if(!tc.isEmpty()){
            if (tc.equalsIgnoreCase("Dark"))
            {
                tv_infor.setTextColor(Color.BLACK);
                tv_title.setTextColor(Color.BLACK);
            }
            else if (tc.equalsIgnoreCase("Light"))
            {
                tv_infor.setTextColor(Color.YELLOW);
                tv_title.setTextColor(Color.YELLOW);
            }
        }


    }
}