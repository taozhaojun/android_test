package com.ben.viewsexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton btn_toggle;
    Switch switch1;
    ConstraintLayout cl_main_layout;
    RadioGroup rg_color;
    RadioButton rb_r, rb_g, rb_b;
    TextView tv_title;
    CheckBox cb_italic, cb_bold;
    ProgressBar progressBar, progressBar2;
    Handler handler = new Handler();
    Runnable updateBarTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_toggle = findViewById(R.id.toggleButton);
        switch1 = findViewById(R.id.switch1);
        cl_main_layout = findViewById(R.id.cl_main_layout);
        rg_color = findViewById(R.id.rg_color);
        rb_r = findViewById(R.id.rb_r);
        rb_g = findViewById(R.id.rb_g);
        rb_b = findViewById(R.id.rb_b);

        cb_italic = findViewById(R.id.cb_italic);
        cb_bold = findViewById(R.id.cb_bold);

        tv_title = findViewById(R.id.tv_title);
        progressBar = findViewById(R.id.progressBar);
        progressBar2 = findViewById(R.id.progressBar2);
        progressBar2.setMax(100);


        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch1.isChecked()) {
                    rb_r.setClickable(true);
                    rb_g.setClickable(true);
                    rb_b.setClickable(true);
                    Toast.makeText(MainActivity.this, "The switch is on", Toast.LENGTH_LONG).show();
                } else {
                    rb_r.setClickable(false);
                    rb_g.setClickable(false);
                    rb_b.setClickable(false);
                    rb_r.setChecked(false);
                    rb_g.setChecked(false);
                    rb_b.setChecked(false);
                    Toast.makeText(MainActivity.this, "switch is off", Toast.LENGTH_LONG).show();
                }
            }
        });

        btn_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn_toggle.isChecked()) {
                    int id = rg_color.getCheckedRadioButtonId();
                    if (id == R.id.rb_r) {
                        cl_main_layout.setBackgroundColor(Color.RED);
                    } else if (id == R.id.rb_g) {
                        cl_main_layout.setBackgroundColor(Color.GREEN);
                    } else if (id == R.id.rb_b) {
                        cl_main_layout.setBackgroundColor(Color.BLUE);
                    } else {
                        cl_main_layout.setBackgroundColor(Color.WHITE);
                    }

                    if (cb_italic.isChecked() && cb_bold.isChecked()) {
                        tv_title.setTypeface(null, Typeface.BOLD_ITALIC);
                    } else if (cb_italic.isChecked()) {
                        tv_title.setTypeface(null, Typeface.ITALIC);
                    } else if (cb_bold.isChecked()) {
                        tv_title.setTypeface(null, Typeface.BOLD);
                    } else {
                        tv_title.setTypeface(null, Typeface.NORMAL);
                    }

                    progressBar.setVisibility(View.VISIBLE);

                    updateBarTask = new Runnable() {
                        int number = 0;

                        @Override
                        public void run() {
                            progressBar2.setProgress(number);
                            number++;
                            if (number > progressBar2.getMax()) {
                                number = 0;
                            }
                            handler.postDelayed(this, 500); //0.5 second
                        }
                    };

                    handler.post(updateBarTask);


//                    Toast.makeText(MainActivity.this, "The button is on", Toast.LENGTH_LONG).show();
                } else {
                    cl_main_layout.setBackgroundColor(Color.WHITE);
                    tv_title.setTypeface(null, Typeface.NORMAL);
                    progressBar.setVisibility(View.GONE);
                    handler.removeCallbacks(updateBarTask);
//                    Toast.makeText(MainActivity.this, "off", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}