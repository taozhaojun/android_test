package com.ben.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView tv_display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        String[] data = {"Kris", "Robert", "Zhaojun", "Neda", "Baseel", "Kris", "Robert", "Zhaojun", "Neda", "Baseel", "Kris", "Robert", "Zhaojun", "Neda", "Baseel", "Robert", "Zhaojun", "Neda", "Baseel", "Kris", "Robert", "Zhaojun", "Neda", "Baseel"};

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.tv_item, data);

//        User[] userData = {
//                new User("Ben", R.drawable.img2, 10000),
//                new User("Kris", R.drawable.img3, 500),
//                new User("Robert", R.drawable.img4, 600),
//                new User("Zhaojun", R.drawable.img5, 999),
//                new User("Neda", R.drawable.img6, 20000),
//                new User("Ben", R.drawable.img2, 10000),
//                new User("Kris", R.drawable.img3, 500),
//                new User("Robert", R.drawable.img4, 600),
//                new User("Zhaojun", R.drawable.img5, 999),
//                new User("Neda", R.drawable.img6, 20000),
//                new User("Ben", R.drawable.img2, 10000),
//                new User("Kris", R.drawable.img3, 500),
//                new User("Robert", R.drawable.img4, 600),
//                new User("Zhaojun", R.drawable.img5, 999),
//                new User("Neda", R.drawable.img6, 20000),
//        };

//        BenStyleAdapter adapter = new BenStyleAdapter(this, DataCloud.userData);
//
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
//                intent.putExtra(DataCloud.INTENT_KEY, position);
//                startActivity(intent);
//
//            }
//        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        BenStyleAdapter adapter = new BenStyleAdapter(this, DataCloud.userData);

        ListView listView = findViewById(R.id.my_list);

//        adapter.clear();
//        BenStyleAdapter adapter2 = new BenStyleAdapter(this, new User[0]);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
//                intent.putExtra(DataCloud.INTENT_KEY, position);

                intent.putExtra(DataCloud.INTENT_KEY, DataCloud.userData[position]);

                startActivity(intent);

            }
        });
    }
}