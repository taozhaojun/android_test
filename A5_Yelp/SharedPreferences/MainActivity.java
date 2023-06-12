package com.example.zhaojuntao_myyelp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    //class variable
    NavigationView nv_sidebar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create link
        nv_sidebar = findViewById(R.id.nv_sidebar);


        //set main fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_main, new MainFragment()).commit();


        //sidebar click
        nv_sidebar.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.menu_search){
                    //set main fragment
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl_main, new MainFragment()).commit();
                }else if(id == R.id.menu_like){
                    //set favorite fragment
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl_main, new FavoriteFragment()).commit();
                }
                // Close the drawer
                DrawerLayout drawerLayout = findViewById(R.id.dl_main);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });


    }
}