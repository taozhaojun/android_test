package com.ben.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView tv_label; //reference to the xml View
    TextView tv_value;
    Button btn_click;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_super);

        tv_label = findViewById(R.id.tv_value_label); // label
        tv_value = findViewById(R.id.tv_value); // value e.g. 400
        btn_click = findViewById(R.id.btn_click_me);
        spinner = findViewById(R.id.spinner);

        tv_value.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_value.setText("500");
            }
        });

        Integer[] numbers = {100, 200, 300, 400, 500};
        ArrayAdapter<Integer> adapter = new ArrayAdapter(getApplicationContext(), R.layout.my_spinner_item, numbers);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



//        btn_click.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // 100 to the current value
//                int currentValue = Integer.parseInt(tv_value.getText().toString()); // charsequence != string 400
//
//                if(currentValue >= 1000){
//                    tv_label.setText("OMG you are rich: ");
//                }
//
//                tv_value.setText(Model.addAmount(currentValue, 100) + "");
//
//
//
//            }
//        });




    }


    public void onLabelClick(View v) {

        if (v instanceof Button) {
            int currentValue = Integer.parseInt(tv_value.getText().toString()); // charsequence != string 400



            int amount = (Integer) spinner.getSelectedItem();

            tv_value.setText(Model.addAmount(currentValue, amount) + ""); //update 1000

            if (currentValue >= 900) {
                tv_label.setText("OMG you are rich: ");
            }
        } else if (v instanceof TextView) {
            tv_label.setText(getString(R.string.value_label));
        }


    }
}