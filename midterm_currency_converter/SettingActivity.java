package com.example.zhaojuntao_midterm;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SettingActivity extends AppCompatActivity {
    RadioGroup rg_from;
    RadioGroup rg_to;
    Button btn_confirm;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    RadioButton radioButton5;
    RadioButton radioButton6;
    RadioButton radioButton7;
    RadioButton radioButton8;
    final String FILE_NAME = "my_preference";
    final String FROM_KEY = "from_key";
    final String TO_KEY = "to_key";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ActionBar myBar = getSupportActionBar();
        if (myBar != null){
            myBar.setTitle("Currency Converter");
            myBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#6C3CC1")));
            int titleColor = Color.WHITE;
            SpannableString title = new SpannableString(myBar.getTitle());
            title.setSpan(new ForegroundColorSpan(titleColor), 0, title.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            myBar.setTitle(title);
        }
        rg_from = findViewById(R.id.rg_from);
        rg_to = findViewById(R.id.rg_to);

        btn_confirm = findViewById(R.id.btn_confirm);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton4 = findViewById(R.id.radioButton4);
        radioButton5 = findViewById(R.id.radioButton5);
        radioButton6 = findViewById(R.id.radioButton6);
        radioButton7 = findViewById(R.id.radioButton7);
        radioButton8 = findViewById(R.id.radioButton8);
        //load the preference
        SharedPreferences sf = getSharedPreferences(FILE_NAME,MODE_PRIVATE);
        String from_convency = sf.getString(FROM_KEY,"US Dollar");
        String to_convency = sf.getString(TO_KEY,"Japanese Yen");
        //from currency
        if (from_convency.equalsIgnoreCase("US Dollar")){
            rg_from.check(R.id.radioButton1);
        }else if (from_convency.equalsIgnoreCase("Canadian Dollar")){
            rg_from.check(R.id.radioButton2);
        }else if (from_convency.equalsIgnoreCase("Japanese Yen")){
            rg_from.check(R.id.radioButton3);
        }else if (from_convency.equalsIgnoreCase("Euro")){
            rg_from.check(R.id.radioButton4);
        }
        //to currency
        if (to_convency.equalsIgnoreCase("US Dollar")){
            rg_to.check(R.id.radioButton5);
        }else if (to_convency.equalsIgnoreCase("Canadian Dollar")){
            rg_to.check(R.id.radioButton6);
        }else if (to_convency.equalsIgnoreCase("Japanese Yen")){
            rg_to.check(R.id.radioButton7);
        }else if (to_convency.equalsIgnoreCase("Euro")){
            rg_to.check(R.id.radioButton8);
        }

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor edit = sf.edit();
                //send back from data
                int id1 = rg_from.getCheckedRadioButtonId();
                if (id1 == R.id.radioButton1){
                    edit.putString(FROM_KEY,"US Dollar");
                }else if (id1 == R.id.radioButton2){
                    edit.putString(FROM_KEY,"Canadian Dollar");
                }else if (id1 == R.id.radioButton3){
                    edit.putString(FROM_KEY,"Japanese Yen");
                }else if (id1 == R.id.radioButton4){
                    edit.putString(FROM_KEY,"Euro");
                }else{
                    edit.putString(FROM_KEY,"US Dollar");
                }
                //send back to data
                int id2 = rg_to.getCheckedRadioButtonId();
                if (id2 == R.id.radioButton5){
                    edit.putString(TO_KEY,"US Dollar");
                }else if (id2 == R.id.radioButton6){
                    edit.putString(TO_KEY,"Canadian Dollar");
                }else if (id2 == R.id.radioButton7){
                    edit.putString(TO_KEY,"Japanese Yen");
                }else if (id2 == R.id.radioButton8){
                    edit.putString(TO_KEY,"Euro");
                }else{
                    edit.putString(TO_KEY,"Japanese Yen");
                }
                edit.apply();
                //return
                finish();
            }
        });

    }
}