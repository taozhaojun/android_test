package com.ben.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {


    int position;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

//        position = getIntent().getIntExtra(DataCloud.INTENT_KEY, 0);
        user = getIntent().getParcelableExtra(DataCloud.INTENT_KEY);

        TextView tv_name = findViewById(R.id.tv_name);
        ImageView imageView = findViewById(R.id.iv_picture);
        EditText et_price = findViewById(R.id.et_price);
        Button btn_confirm = findViewById(R.id.btn_confirm);

        tv_name.setText(user.getName());
        et_price.setText(user.getPrice()+"");
        imageView.setImageResource(user.getImgId());

//        tv_name.setText(DataCloud.userData[position].getName());
//        et_price.setText(DataCloud.userData[position].getPrice()+"");
//        imageView.setImageResource(DataCloud.userData[position].getImgId());

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double newPrice = Double.parseDouble(et_price.getText().toString());
//                DataCloud.userData[position].setPrice(newPrice);
//                DataCloud.total_price += 500;
                finish();
            }
        });


    }
}