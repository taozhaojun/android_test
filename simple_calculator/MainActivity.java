package com.example.simplecalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView tv_label_1; //reference to add result
    TextView tv_label_2; //reference to divide result
    Button btn_click;
    Spinner spinner1; //reference to first value to add
    Spinner spinner2; //reference to second value to add
    Spinner spinner3; //reference to third value to divide
    Spinner spinner4; //reference to fourth value to divide

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_label_1 = findViewById(R.id.add_result); // add result
        tv_label_2 = findViewById(R.id.divide_result); // divide result
        btn_click = findViewById(R.id.button);
        spinner1 = findViewById(R.id.sp_add1);
        spinner2 = findViewById(R.id.sp_add2);
        spinner3 = findViewById(R.id.sp_divide1);
        spinner4 = findViewById(R.id.sp_divide2);


        Integer[] numbers1 = {50,100,200,300};
        Integer[] numbers2 = {230,320,450,590};
        Integer[] numbers3 = {340,430,550,630};
        Integer[] numbers4 = {2,3,4,5,0};
        ArrayAdapter<Integer> adapter1 = new ArrayAdapter<>(this, R.layout.my_spinner_item, numbers1);
        adapter1.setDropDownViewResource(R.layout.my_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        ArrayAdapter<Integer> adapter2 = new ArrayAdapter<>(this, R.layout.my_spinner_item, numbers2);
        adapter2.setDropDownViewResource(R.layout.my_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        ArrayAdapter<Integer> adapter3 = new ArrayAdapter<>(this, R.layout.my_spinner_item, numbers3);
        adapter3.setDropDownViewResource(R.layout.my_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

        ArrayAdapter<Integer> adapter4 = new ArrayAdapter<>(this, R.layout.my_spinner_item, numbers4);
        adapter4.setDropDownViewResource(R.layout.my_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);


        btn_click.setOnClickListener(v -> {
            int amount1 = Integer.parseInt(spinner1.getSelectedItem().toString());
            int amount2 = Integer.parseInt(spinner2.getSelectedItem().toString());
            int amount3 = Integer.parseInt(spinner3.getSelectedItem().toString());
            int amount4 = Integer.parseInt(spinner4.getSelectedItem().toString());
            int result_add = amount1+amount2;
            //update tv_label_1 for add result
            @SuppressLint("DefaultLocale") String addResult = String.format("%d", result_add);
            tv_label_1.setText("= "+addResult);

            double result_divide;
            if (amount4 == 0) {
                //update tv_label_2
                tv_label_2.setText("= Infinity");
            } else {
                result_divide = (double) amount3/amount4;
                @SuppressLint("DefaultLocale") String formatted_result = String.format("%.2f", result_divide);
                tv_label_2.setText("= "+formatted_result);
            }
        });

    }
}