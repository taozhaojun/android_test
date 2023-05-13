package com.example.myfavoritecomic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SettingActivity extends AppCompatActivity {
    Spinner sp_background; //reference to first value to add
    Spinner sp_textcolor; //reference to second value to add
    Button btn_confirm;
    final String FILE_NAME = "my_preference";
    final String BG_KEY = "bg_key";
    final String TC_KEY = "tc_key";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        sp_background = findViewById(R.id.sp_background);
        sp_textcolor = findViewById(R.id.sp_textcolor);
        btn_confirm = findViewById(R.id.btn_confirm);



        String[] string_array_bg = {"Default","Warm","Cold","Horror"};
        String[] string_array_tc = {"Dark","Light"};

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, string_array_bg);
        adapter1.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        sp_background.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, string_array_tc);
        adapter2.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        sp_textcolor.setAdapter(adapter2);

        btn_confirm.setOnClickListener(v -> {
            //send back data
            SharedPreferences sf = getSharedPreferences(FILE_NAME,MODE_PRIVATE);
            SharedPreferences.Editor edit = sf.edit();
            edit.putString(BG_KEY,sp_background.getSelectedItem().toString());
            edit.putString(TC_KEY,sp_textcolor.getSelectedItem().toString());
            edit.apply();
            //return
            finish();
        });


    }
}