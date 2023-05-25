package com.ben.layoutsexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.my_list_view);

//        User user;
//
//        ArayyList<User>

//        String[] data = {"Ben", "Bassel", "Fia", "Anna", "Rolande"};
//        int[] age= {25, 30, 30, 30, 30};
//        String[] des = {};
//        int[] imgIds = {};
//        double[] price = {};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, R.layout.my_item, R.id.tv_name, Database.data);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(), data[position] + " age: " + age[position], Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                intent.putExtra("position_key", position);
                startActivity(intent);

            }
        });


    }
}