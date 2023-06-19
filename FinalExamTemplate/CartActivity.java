package com.julienb.assignment3_mobdev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        setTitle("Bibliothèque");
        buildView();
    }

    // Just a view builder function
    private void buildView(){
        // Getting all the cart entries
        ArrayList<CartEntry> cart = DataSource.getCart();
        // Getting the list view element
        ListView menuItemsListView = (ListView) findViewById(R.id.cart_list);
        // Linking the listview element to the custom CartEntryAdapter
        CartEntryAdapter listViewAdapter = new CartEntryAdapter(this, cart);
        menuItemsListView.setAdapter(listViewAdapter);
        // Just updating the total
        ((TextView)findViewById(R.id.total_text)).setText("Total: "+ (new BigDecimal(DataSource.getCartTotal()).setScale(2, BigDecimal.ROUND_HALF_UP).toString() + " $"));
    }

    // Clearing the cart and updating the view on clear button click
    public void clearBtnClicked(View view) {
        DataSource.clearCart();
        buildView();
    }
}