
package com.example.fia_a3.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fia_a3.model.BookID;
import com.example.fia_a3.model.Constants;
import com.example.fia_a3.R;
import com.example.fia_a3.model.Utility;
import com.example.fia_a3.adapter.BookListAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BookListActivity extends AppCompatActivity {
    private ListView bookListView;
    private ArrayList<BookID> bookIDs = new ArrayList<>();
    private TextView tvTotalPrice;
    private Button btnCart;
    private BookListAdapter bookListAdapter;

    private static final String TAG = "BookListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        Log.d(TAG, "onCreate: started");

        // Get the list of book titles for the selected category
        getBookList();

        // Declare Views
        bookListView = findViewById(R.id.list_view);
        tvTotalPrice = findViewById(R.id.tv_total_price);
        btnCart = findViewById(R.id.btn_cart);
        btnCart.setOnClickListener(v -> {
            startActivity(new Intent(BookListActivity.this, CartActivity.class));
        });
        bookListAdapter = new BookListAdapter(bookIDs, this);
        bookListView.setAdapter(bookListAdapter);
        bookListView.setOnItemClickListener((parent, view, position, id) -> {
            String bookModelString = new Gson().toJson(bookIDs.get(position));
            startActivity(new Intent(this, DetailActivity.class).putExtra(Constants.DETAIL_KEY, bookModelString));
            Log.d(TAG, "onCreate: bookModelString");
        });

        // Update the total price
        updateTotalPrice();
    }

    // Implementation to return a list of books for the selected category
    private void getBookList() {
        // Retrieve the selected category from the intent
        String category = getIntent().getStringExtra(Constants.CATEGORY_KEY);
        Log.d(TAG, "getBookList: category: " + category); // Add this line to log the category value


        switch (category) {
            case Constants.BIOGRAPHY:
                bookIDs = Constants.biographyList(this);
                break;
            case Constants.ROMANCE:
                bookIDs = Constants.romanceList(this);
                break;
            case Constants.FICTION:
                bookIDs = Constants.fictionList(this);
                break;
            case Constants.POEM:
                bookIDs = Constants.poemList(this);
                break;
        }

        Log.d(TAG, "getBookList: bookIDs size: " + bookIDs.size()); // Add this line to log the size of the bookIDs list
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");

        String items = Utility.getStringFromSP(this, "itemList");
        if (items == null || items.isEmpty()) {
            tvTotalPrice.setText("Total: 0.00$");
        } else {
            ArrayList<BookID> storedBookModels = new Gson().fromJson(items, new TypeToken<List<BookID>>() {}.getType());
            if (storedBookModels != null) {
                double totalPrice = 0;
                for (int i = 0; i < storedBookModels.size(); i++) {
                    double bookPrice = storedBookModels.get(i).getPrice() * storedBookModels.get(i).getQty();
                    totalPrice += bookPrice;
                }
                tvTotalPrice.setText(String.format(Locale.getDefault(), "Total: %.2f $", totalPrice));
            } else {
                tvTotalPrice.setText("Total: 0.00$");
                Log.d(TAG, "onResume: storedBookModels is null");
            }
        }

        Log.d(TAG, "onResume: finish");
    }

    private void updateTotalPrice() {
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
