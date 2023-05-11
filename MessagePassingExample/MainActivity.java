package com.ben.messagepassingexample;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static com.ben.messagepassingexample.Constants.PAY_KEY;
import static com.ben.messagepassingexample.Constants.PRICE_KEY;
import static com.ben.messagepassingexample.Constants.TITLE_KEY;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView iv_tomato;
    ImageView iv_potato;
    ConstraintLayout cl_potato, cl_tomato;
    Button btn_checkout;
    TextView tv_tomato, tv_potato, tv_pay_info, tv_timer;
    EditText et_tomato_price, et_potato_price;

    boolean tomatoFlag = true;
    boolean potatoFlag = true;

    ActivityResultLauncher<Intent> myLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    tv_pay_info.setText(result.getData().getStringExtra(PAY_KEY));
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        iv_potato = findViewById(R.id.iv_potato);
        iv_tomato = findViewById(R.id.iv_tomato);
        cl_potato = findViewById(R.id.cl_potato);
        cl_tomato = findViewById(R.id.cl_tomato);
        btn_checkout = findViewById(R.id.btn_checkout);
        tv_tomato = findViewById(R.id.tv_tomato);
        tv_potato = findViewById(R.id.tv_potato);
        tv_pay_info = findViewById(R.id.tv_pay_info);
        tv_timer = findViewById(R.id.tv_timer);
        et_tomato_price = findViewById(R.id.et_tomato_price);
        et_potato_price = findViewById(R.id.et_potato_price);

        Handler handler = new Handler();
        Handler handler2 = new Handler();

        Runnable taks1 = new Runnable() {
            int sec = 0;
            @Override
            public void run() {

                tv_timer.setText(sec + "");
                sec++;
                handler.postDelayed(this, 500); //= 1sec
            }
        };

        Runnable taks2 = new Runnable() {
            int sec = 0;
            @Override
            public void run() {

                tv_timer.setText(sec + "");
                sec /= 5;
                handler.postDelayed(this, 1000); //= 1sec
            }
        };

//        new Thread(taks1).start();

        handler.post(taks1);
        handler.post(taks2);


        btn_checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title ="";
                if(!potatoFlag){
                    title += tv_potato.getText().toString();
                    if(!tomatoFlag){
                        title += " + " + tv_tomato.getText().toString();
                    }
                }else if(!tomatoFlag){
                    title += tv_tomato.getText().toString();
                    if(!potatoFlag){
                        title += " + " + tv_potato.getText().toString();
                    }
                }

                double price = 0;
                if(!et_potato_price.getText().toString().isEmpty() && !potatoFlag){
                    price += Double.parseDouble(et_potato_price.getText().toString());
                }

                if(!et_tomato_price.getText().toString().isEmpty() && !tomatoFlag){
                    price += Double.parseDouble(et_tomato_price.getText().toString());
                }

//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_DIAL);
//                startActivity(intent);


                Intent intent = new Intent(MainActivity.this, CartActivity.class);
                intent.putExtra(TITLE_KEY, title);
                intent.putExtra(PRICE_KEY, price);
                myLauncher.launch(intent);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | FLAG_ACTIVITY_NEW_TASK) ;
//                startActivity(intent);

            }
        });



        iv_potato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the color for the tint
                if(potatoFlag) {
                    String colorCode = "#80FF0000"; // Red color
                    int mycolor = Color.parseColor(colorCode);
                    ColorStateList colorStateList = ColorStateList.valueOf(mycolor);
                    iv_potato.setColorFilter(Color.argb(50, 0, 0, 0));
                    cl_potato.setBackgroundColor(mycolor);
                    potatoFlag = false;
                }else{
                    String colorCode = "#FFFFFF"; // white
                    int mycolor = Color.parseColor(colorCode);
                    iv_potato.setColorFilter(Color.argb(0, 0, 0, 0));
                    cl_potato.setBackgroundColor(mycolor);
                    potatoFlag = true;

                }

            }
        });

        iv_tomato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(tomatoFlag) {
                    String colorCode = "#80FF0000"; // Red color
                    int mycolor = Color.parseColor(colorCode);
                    ColorStateList colorStateList = ColorStateList.valueOf(mycolor);
                    iv_tomato.setColorFilter(Color.argb(50, 0, 0, 0));
                    cl_tomato.setBackgroundColor(mycolor);
                    tomatoFlag = false;
                }else{
                    String colorCode = "#FFFFFF"; // white
                    int mycolor = Color.parseColor(colorCode);
                    iv_tomato.setColorFilter(Color.argb(0, 0, 0, 0));
                    cl_tomato.setBackgroundColor(mycolor);
                    tomatoFlag = true;

                }

            }
        });

    }
}