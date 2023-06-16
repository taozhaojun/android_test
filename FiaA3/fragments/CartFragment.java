package com.example.fia_a3.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fia_a3.R;
import com.example.fia_a3.activity.CartActivity;
import com.example.fia_a3.model.BookID;
import com.example.fia_a3.model.Utility;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;


public class CartFragment extends Fragment {

    private ArrayList<BookID> bookIDS = new ArrayList<>();
    private ListView cartListView;
    private TextView totalPrice;
    private TextView tvTotalPrice;
    private Button btnClear;
    private CartAdapter cartAdapter;

    private static final String TAG = "CartFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cart, container, false);
        cartListView = v.findViewById(R.id.cart_list);
        totalPrice = v.findViewById(R.id.tv_total_price);
        tvTotalPrice = v.findViewById(R.id.tv_total_price);
        btnClear = v.findViewById(R.id.btn_clear);

        String items = Utility.getStringFromSP(requireActivity(), "itemList");
        if (!items.equals("")) {
            bookIDS = new Gson().fromJson(items, new TypeToken<List<BookID>>() {}.getType());
        }

        cartAdapter = new CartAdapter(bookIDS, requireActivity());
        cartListView.setAdapter(cartAdapter);

        double totalPrice = calculateTotalPrice(bookIDS);
        tvTotalPrice.setText(String.format("Total: %.2f $", totalPrice));

        setOnClicks();
        return v;
    }

    private void setOnClicks() {
        btnClear.setOnClickListener(v -> {
            // Clear the item list in SharedPreferences
            Utility.saveStringToSP(requireActivity(), "itemList", "");

            // Clear the bookIDS list
            bookIDS.clear();

            // Notify the adapter that the data has changed
            cartAdapter.notifyDataSetChanged();

            // Update the total price TextView
            tvTotalPrice.setText("Total: 0.00$");
        });
    }

    private double calculateTotalPrice(List<BookID> bookIDs) {
        double totalPrice = 0;
        for (BookID bookID : bookIDs) {
            double bookPrice = bookID.getPrice() * bookID.getQty();
            totalPrice += bookPrice;
        }
        return totalPrice;
    }

    class CartAdapter extends ArrayAdapter<BookID> {

        private ArrayList<BookID> dataSet;
        private Context context;

        // View lookup cache
        private static class ViewLiner {
            TextView bTitle;
            TextView bQty;
            TextView bPrice;
            TextView bTotal;
        }

        public CartAdapter(ArrayList<BookID> data, Context context) {
            super(context, R.layout.list_item_cart, data);
            this.dataSet = data;
            this.context = context;
        }
        private int lastPosition = -1;
        @Override
        public View getView(int position, View lineView, ViewGroup parent) {
            // Get the data item for this position
            BookID bookID = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            CartAdapter.ViewLiner viewLine; // view lookup cache stored in tag

            if (lineView == null) {
                viewLine = new CartAdapter.ViewLiner();
                LayoutInflater inflater = LayoutInflater.from(getContext());
                lineView = inflater.inflate(R.layout.list_item_cart, parent, false);
                viewLine.bTitle = lineView.findViewById(R.id.tv_card_item_name);
                viewLine.bQty = lineView.findViewById(R.id.tv_card_item_num);
                viewLine.bPrice = lineView.findViewById(R.id.tv_card_item_price);
                viewLine.bTotal = lineView.findViewById(R.id.tv_card_total);
                lineView.setTag(viewLine);
            } else {
                viewLine = (CartAdapter.ViewLiner) lineView.getTag();
            }
            lastPosition = position;
            // Set the data to the views

            viewLine.bTitle.setText(bookID.getTitle());
            viewLine.bQty.setText(String.valueOf(bookID.getQty()));
            viewLine.bPrice.setText(String.valueOf(bookID.getPrice()));
            double totalNumber = bookID.getPrice() * bookID.getQty();
            String formattedTotal = String.format("%.2f", totalNumber);
            viewLine.bTotal.setText(formattedTotal);

            // Return the completed view to render on screen
            return lineView;
        }

    }
}