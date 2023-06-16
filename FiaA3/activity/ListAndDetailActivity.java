package com.example.fia_a3.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fia_a3.R;
import com.example.fia_a3.adapter.BookListAdapter;
import com.example.fia_a3.fragments.BookListFragment;
import com.example.fia_a3.fragments.CartFragment;
import com.example.fia_a3.model.BookID;
import com.example.fia_a3.model.Constants;
import com.example.fia_a3.model.Utility;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class ListAndDetailActivity extends AppCompatActivity {

    private TextView tvTotalPrice;
    private Button btnCart;

    DrawerLayout drawerLayout;
    NavigationView nav_view;

    FrameLayout cart_container;

    private ActionBarDrawerToggle toggle;

    private static final String TAG = "BookListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_and_detail);

        tvTotalPrice = findViewById(R.id.tv_total_price);
        btnCart = findViewById(R.id.btn_cart);
        cart_container = findViewById(R.id.cart_container);
        drawerLayout = findViewById(R.id.drawer_layout);
        nav_view = findViewById(R.id.nav_view);
        Toolbar toolbar = findViewById(R.id.toolbar);

        btnCart.setVisibility(View.INVISIBLE);

        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.menu_books){
                   //we need to show list of books
                    cart_container.setVisibility(View.GONE);
                }else{
                    //we show cart
                    cart_container.setVisibility(View.VISIBLE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.cart_container, new CartFragment()).commit();

                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });



        btnCart.setOnClickListener(v -> {
            startActivity(new Intent(ListAndDetailActivity.this, CartActivity.class));
        });


        String category = getIntent().getStringExtra(Constants.CATEGORY_KEY);

        BookListFragment bookListFragment = new BookListFragment();
        Bundle bundle = new Bundle(); // like the intent
        bundle.putString(Constants.CATEGORY_KEY, category);
        bookListFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().replace(R.id.list_container, bookListFragment).commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateTotalPrice();
    }

    public void updateTotalPrice() {
        String items = Utility.getStringFromSP(this, "itemList");
        if (items == null || items.isEmpty()) {
            tvTotalPrice.setText("Total: 0.00$");
            Log.d(TAG, "updateTotalPrice: if tvTotalPrice");
        } else {
            ArrayList<BookID> storedBookModels = new Gson().fromJson(items, new TypeToken<List<BookID>>() {}.getType());
            if (storedBookModels != null) {
                double totalPrice = 0;
                for (int i = 0; i < storedBookModels.size(); i++) {
                    double bookPrice = storedBookModels.get(i).getPrice() * storedBookModels.get(i).getQty();
                    totalPrice += bookPrice;
                }
                tvTotalPrice.setText("Total: " + totalPrice + " $");
                Log.d(TAG, "updateTotalPrice: else tvTotalPrice");
            } else {
                tvTotalPrice.setText("Total: 0.00$");
                Log.d(TAG, "updateTotalPrice: else tvTotalPrice (storedBookModels is null)");
            }
        }
    }
}