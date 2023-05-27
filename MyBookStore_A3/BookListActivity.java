package com.example.zhaojuntao_mybookstore_a3;

import static com.example.zhaojuntao_mybookstore_a3.KeyValue.CATEGORY_KEY;
import static com.example.zhaojuntao_mybookstore_a3.KeyValue.POSITION_KEY;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BookListActivity extends AppCompatActivity {
    ListView lv_items;
    TextView tv_total;
    Button btn_seecart;
    ActivityResultLauncher<Intent> myLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    //get information from returned result
                    String book_category = (result.getData().getStringExtra(CATEGORY_KEY));
                    setBookListFromIntent(book_category);

                }
            }
    );
    private void setBookListFromIntent(String book_category){
        if (book_category.equalsIgnoreCase("fasion"))
        {
            String[] data = {"Making Face", "Coco Chanel", "Color Me Beautiful", "Supreme Models"};
            ArrayAdapter my_adapter = new ArrayAdapter(BookListActivity.this,R.layout.mylistlayout,R.id.tv_name,data);
            lv_items.setAdapter(my_adapter);
        }
        else if (book_category.equalsIgnoreCase("music"))
        {
            String[] data = {"Piano and Keyboard Chords", "The Story of Rap", "Violin for Dummies", "Suzuki Cello School"};
            ArrayAdapter my_adapter = new ArrayAdapter(BookListActivity.this,R.layout.mylistlayout,R.id.tv_name,data);
            lv_items.setAdapter(my_adapter);
        }
        else if (book_category.equalsIgnoreCase("computers"))
        {
            String[] data = {"Excel for Dummies", "Cracking the Coding Interview", "HTML and CSS", "Thinking with Type"};
            ArrayAdapter my_adapter = new ArrayAdapter(BookListActivity.this,R.layout.mylistlayout,R.id.tv_name,data);
            lv_items.setAdapter(my_adapter);
        }
        else if (book_category.equalsIgnoreCase("cooking"))
        {
            String[] data = {"More Than Cake", "On the Curry Trail", "Teatime Discipleship", "Everyday Bread"};
            ArrayAdapter my_adapter = new ArrayAdapter(BookListActivity.this,R.layout.mylistlayout,R.id.tv_name,data);
            lv_items.setAdapter(my_adapter);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
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
        //create the link
        lv_items = findViewById(R.id.lv_items);
        tv_total = findViewById(R.id.tv_total);
        btn_seecart = findViewById(R.id.btn_seecart);
        // Accessing cartItems
        ArrayList<Book> cartItems = CartData.getCartItems();

        //get information from intent
        String book_category = getIntent().getStringExtra(CATEGORY_KEY);
        setBookListFromIntent(book_category);
        //calculate total
        double totalPrice = 0.0;
        for (Book book : cartItems) {
            totalPrice += book.getUnitPrice() * book.getQty();
        }
        String roundedNumber = String.format("%.2f", totalPrice);
        //set tv_total to show total price
        tv_total.setText("Total:"+roundedNumber+"$");

        //event when click list item
        lv_items.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(BookListActivity.this, DetailActivity.class);
                intent.putExtra(CATEGORY_KEY,book_category);
                intent.putExtra(POSITION_KEY, position);
                startActivity(intent);
            }
        });
        //event when click button see_cart
        btn_seecart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookListActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Accessing cartItems
        ArrayList<Book> cartItems = CartData.getCartItems();
        //calculate total
        double totalPrice = 0.0;
        for (Book book : cartItems) {
            totalPrice += book.getUnitPrice() * book.getQty();
        }
        String roundedNumber = String.format("%.2f", totalPrice);
        //set tv_total to show total price
        tv_total.setText("Total:"+roundedNumber+"$");
    }
}