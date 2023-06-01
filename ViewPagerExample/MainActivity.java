package com.ben.viewpagerexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    BenPagerAdapter benPagerAdapter;

//    FrameLayout list_container, top_right_container, bottom_right_container;

    public BenPagerAdapter getBenPagerAdapter() {
        return benPagerAdapter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        list_container = findViewById(R.id.list_container);
//        top_right_container = findViewById(R.id.top_right_container);
//        bottom_right_container = findViewById(R.id.bottom_right_container);

        TabLayout my_tabs = findViewById(R.id.my_tabs);

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new PictureFragment());
        fragments.add(new BenListFragment());
        fragments.add(new TextFragment());


        ViewPager viewPager = findViewById(R.id.viewPager);
        benPagerAdapter = new BenPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(benPagerAdapter);
        my_tabs.setupWithViewPager(viewPager);



        BenListFragment benListFragment = new BenListFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.list_container, benListFragment).commit();

        getSupportFragmentManager().beginTransaction().replace(R.id.bottom_right_container, new BenListFragment()).commit();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menus, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.menu_setting){
            Toast.makeText(this, "Im setting", Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.bottom_right_container, new TextFragment()).commit();
        } else if(id == R.id.menu_hate){
            Toast.makeText(this, "dislike", Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.top_right_container, new BenListFragment()).commit();
        } else{
            Toast.makeText(this, "Like", Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.top_right_container, new PictureFragment()).commit();
        }

        return super.onOptionsItemSelected(item);
    }
}