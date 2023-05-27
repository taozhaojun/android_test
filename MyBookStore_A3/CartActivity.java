package com.example.zhaojuntao_mybookstore_a3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    ListView lv_cart;
    TextView tv_total;
    Button btn_clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        //set action bar
        ActionBar myBar = getSupportActionBar();
        if (myBar != null){
            myBar.setTitle("Bibliothèque");
            myBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#6C3CC1")));
            int titleColor = Color.WHITE;
            SpannableString title = new SpannableString(myBar.getTitle());
            title.setSpan(new ForegroundColorSpan(titleColor), 0, title.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            myBar.setTitle(title);
        }
        // create the link
        lv_cart = findViewById(R.id.lv_cart);
        tv_total = findViewById(R.id.tv_total);
        btn_clear = findViewById(R.id.btn_clear);

        // Accessing cartItems
        ArrayList<Book> cartItems = CartData.getCartItems();
        //using BookListAdapter to generate listview
        BookListAdapter myadapter = new BookListAdapter(CartActivity.this,R.layout.cartlistlayout,cartItems);
        lv_cart.setAdapter(myadapter);
        //calculate total
        double totalPrice = 0.0;
        for (Book book : cartItems) {
            totalPrice += book.getUnitPrice() * book.getQty();
        }
        String roundedNumber = String.format("%.2f", totalPrice);
        //set tv_total to show total price
        tv_total.setText("Total:"+roundedNumber+"$");

        //when click clear
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear the cart items and update the adapter
                ArrayList<Book> cartItems = CartData.getCartItems();
                cartItems.clear();
                CartData.setCartItems(cartItems);
                BookListAdapter myadapter = new BookListAdapter(CartActivity.this,R.layout.cartlistlayout,cartItems);
                lv_cart.setAdapter(myadapter);

                // Clear the total price
                tv_total.setText("Total: 0.00$");

                // Show a toast message indicating the cart is cleared
                Toast.makeText(CartActivity.this, "Cart cleared", Toast.LENGTH_SHORT).show();
            }
        });
    }
}