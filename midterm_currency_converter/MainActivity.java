package com.example.zhaojuntao_midterm;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    Button bt_convert;
    TextView tv_result;
    TextView tv_start;
    TextView tv_end;
    ImageView iv_setting;
    EditText et_amount;
    // Create a HashMap to store the conversion factors
    HashMap<String, Double> conversionFactors = new HashMap<>();
    final String FILE_NAME = "my_preference";
    final String FROM_KEY = "from_key";
    final String TO_KEY = "to_key";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar myBar = getSupportActionBar();
        if (myBar != null){
            myBar.setTitle("Currency Converter");
            myBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#6C3CC1")));
            int titleColor = Color.WHITE;
            SpannableString title = new SpannableString(myBar.getTitle());
            title.setSpan(new ForegroundColorSpan(titleColor), 0, title.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            myBar.setTitle(title);
        }
        bt_convert = findViewById(R.id.bt_convert);
        tv_result = findViewById(R.id.tv_result);
        tv_start = findViewById(R.id.tv_start);
        tv_end = findViewById(R.id.tv_end);
        iv_setting = findViewById(R.id.iv_setting);
        et_amount = findViewById(R.id.et_amount);


        // Populate the dictionary with conversion factors
        conversionFactors.put("USD_TO_USD", 1.0);
        conversionFactors.put("USD_TO_CAD", 1.34);
        conversionFactors.put("USD_TO_JPY", 137.58);
        conversionFactors.put("USD_TO_EUR", 0.92);
        conversionFactors.put("CAD_TO_USD", 0.74);
        conversionFactors.put("CAD_TO_CAD", 1.0);
        conversionFactors.put("CAD_TO_JPY", 102.23);
        conversionFactors.put("CAD_TO_EUR", 0.68);
        conversionFactors.put("JPY_TO_USD", 0.0072);
        conversionFactors.put("JPY_TO_CAD", 0.0097);
        conversionFactors.put("JPY_TO_JPY", 1.0);
        conversionFactors.put("JPY_TO_EUR", 0.0067);
        conversionFactors.put("EUR_TO_USD", 1.084);
        conversionFactors.put("EUR_TO_CAD", 1.45);
        conversionFactors.put("EUR_TO_JPY", 149.15);
        conversionFactors.put("EUR_TO_EUR", 1.0);

        bt_convert.setOnClickListener(v -> {
            double amount_start;
            double amount_end;
            double convert_factor;

            //amount_start = Double.parseDouble(et_amount.getText().toString());
            try {
                amount_start = Double.parseDouble(et_amount.getText().toString());
            } catch (NumberFormatException e) {
                // Handle the exception here, such as displaying an error message
                //Toast.makeText(getApplicationContext(), "Invalid input", Toast.LENGTH_SHORT).show();
                return; // or perform any necessary actions
            }
            if (tv_start.getText().toString().equalsIgnoreCase("US Dollar") && tv_end.getText().toString().equalsIgnoreCase("Japanese Yen")){
                convert_factor =  conversionFactors.get("USD_TO_JPY");
            }else if (tv_start.getText().toString().equalsIgnoreCase("US Dollar") && tv_end.getText().toString().equalsIgnoreCase("Canadian Dollar")) {
                convert_factor = conversionFactors.get("USD_TO_CAD");
            }else if (tv_start.getText().toString().equalsIgnoreCase("US Dollar") && tv_end.getText().toString().equalsIgnoreCase("Euro")) {
                convert_factor = conversionFactors.get("USD_TO_EUR");
            }else if (tv_start.getText().toString().equalsIgnoreCase("Canadian Dollar") && tv_end.getText().toString().equalsIgnoreCase("US Dollar")){
                convert_factor = conversionFactors.get("CAD_TO_USD");
            }else if (tv_start.getText().toString().equalsIgnoreCase("Canadian Dollar") && tv_end.getText().toString().equalsIgnoreCase("Euro")) {
                convert_factor = conversionFactors.get("CAD_TO_EUR");
            } else if (tv_start.getText().toString().equalsIgnoreCase("Canadian Dollar") && tv_end.getText().toString().equalsIgnoreCase("Japanese Yen")) {
                convert_factor = conversionFactors.get("CAD_TO_JPY");
            }else if (tv_start.getText().toString().equalsIgnoreCase("Japanese Yen") && tv_end.getText().toString().equalsIgnoreCase("US Dollar")) {
                convert_factor = conversionFactors.get("JPY_TO_USD");
            }else if (tv_start.getText().toString().equalsIgnoreCase("Japanese Yen") && tv_end.getText().toString().equalsIgnoreCase("Canadian Dollar")) {
                convert_factor = conversionFactors.get("JPY_TO_CAD");
            }else if (tv_start.getText().toString().equalsIgnoreCase("Japanese Yen") && tv_end.getText().toString().equalsIgnoreCase("Euro")) {
                convert_factor = conversionFactors.get("JPY_TO_EUR");
            }else if (tv_start.getText().toString().equalsIgnoreCase("Euro") && tv_end.getText().toString().equalsIgnoreCase("US Dollar")) {
                convert_factor = conversionFactors.get("EUR_TO_USD");
            }else if (tv_start.getText().toString().equalsIgnoreCase("Euro") && tv_end.getText().toString().equalsIgnoreCase("Canadian Dollar")) {
                convert_factor = conversionFactors.get("EUR_TO_CAD");
            }else if (tv_start.getText().toString().equalsIgnoreCase("Euro") && tv_end.getText().toString().equalsIgnoreCase("Japanese Yen")) {
                convert_factor = conversionFactors.get("EUR_TO_JPY");
            }else{
                convert_factor = 1;
            }
            amount_end = amount_start*convert_factor;
            @SuppressLint("DefaultLocale") String roundedNumber = String.format("%.2f", amount_end);
            tv_result.setText(roundedNumber+" "+tv_end.getText().toString());

        });

        iv_setting.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SettingActivity.class);
            startActivity(intent);
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        //load the preference
        SharedPreferences sf = getSharedPreferences(FILE_NAME,MODE_PRIVATE);
        String from_convency = sf.getString(FROM_KEY,"US Dollar");
        String to_convency = sf.getString(TO_KEY,"Japanese Yen");
        tv_start.setText(from_convency);
        tv_end.setText(to_convency);
        bt_convert.performClick();
    }
}