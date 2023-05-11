package com.ben.messagepassingexample;

import static com.ben.messagepassingexample.Constants.PAY_KEY;
import static com.ben.messagepassingexample.Constants.PRICE_KEY;
import static com.ben.messagepassingexample.Constants.TITLE_KEY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CartActivity extends AppCompatActivity {


    TextView tv_item_names, tv_total_price;
    Button btn_pay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        tv_item_names = findViewById(R.id.tv_item_names);
        tv_total_price = findViewById(R.id.tv_total_price);
        btn_pay = findViewById(R.id.btn_pay);

        Intent intent = getIntent();
//        if(intent != null){
        String data = intent.getStringExtra(TITLE_KEY);
        tv_item_names.setText(data);

        tv_total_price.setText(String.valueOf(intent.getDoubleExtra(PRICE_KEY, 0.0)));

        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
//                Intent returnIntent = new Intent(CartActivity.this, MainActivity.class);
                returnIntent.putExtra(PAY_KEY, "Pay");
                setResult(0, returnIntent);
                finish();
//                getApplicationContext().startActivity(returnIntent);
            }
        });
//        }


    }
}