package com.julienb.assignment3_mobdev;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CartEntryAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<CartEntry> cart;

    CartEntryAdapter(Context context, ArrayList<CartEntry> cartEntryArrayList) {
        this.context = context;
        this.cart = cartEntryArrayList;
    }

    @Override
    public int getCount() {
        return cart.size();
    }

    @Override
    public Object getItem(int i) {
        return cart.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int index, View view, ViewGroup viewGroup) {
        // Inflate or render
        View v = View.inflate(context, R.layout.cart_item, null);
        // Getting the text views for each attributes
        TextView cartEntryName = v.findViewById(R.id.cart_entry_name);
        TextView cartEntryQuantity = v.findViewById(R.id.cart_entry_quantity);
        TextView cartEntryPrice = v.findViewById(R.id.cart_entry_price);
        TextView cartEntryTotal = v.findViewById(R.id.cart_entry_total);
        // Getting the cart entry and changing the text of the cart_item layout
        CartEntry cartEntry = cart.get(index);
        cartEntryName.setText(cartEntry.name);
        cartEntryQuantity.setText(String.valueOf(cartEntry.quantity));
        cartEntryPrice.setText(cartEntry.price);
        // Calculating the total for one item and making sure it displays correctly using bigdecimal
        cartEntryTotal.setText((new BigDecimal(cartEntry.quantity * Double.parseDouble(cartEntry.price))).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        return v;
    }
}
