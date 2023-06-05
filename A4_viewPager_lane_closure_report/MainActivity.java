package com.example.zhaojuntao_a4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    ViewPagerAdapter viewPagerAdapter;
    public ViewPagerAdapter getviewPagerAdapter(){
        return viewPagerAdapter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create link
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        //list of fragments
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new LaneClosureListFragment());
        fragments.add(new SelectLaneClosureFragment());
        //list of title
        ArrayList<String> titles = new ArrayList<>();
        titles.add("Lane Closure List");
        titles.add("Select Lane Closure");

        //show viewpager with 2 fragments
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments,titles);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}