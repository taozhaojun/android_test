package com.ben.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {

    Button btn_confirm;
    EditText et_user_input;
    final String FILE_NAME = "my_preference";
    final String MY_KEY = "user_input";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        btn_confirm = findViewById(R.id.btn_confirm);
        et_user_input = findViewById(R.id.et_user_input);

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent = new Intent(ThirdActivity.class, MainActivity.class);
//                intent.putExtra(MY_KEY, et_user_input.getText());
//                startActivity(intent);
                SharedPreferences sf = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
                SharedPreferences.Editor edit = sf.edit();
                edit.putString(MY_KEY, et_user_input.getText().toString());
                edit.apply();
                //send back data
                finish();
            }
        });
    }
}
