package com.example.fia_a3.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fia_a3.R;
import com.example.fia_a3.activity.DetailActivity;
import com.example.fia_a3.activity.ListAndDetailActivity;
import com.example.fia_a3.model.BookID;
import com.example.fia_a3.model.Constants;
import com.example.fia_a3.model.Utility;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class DetailFragment extends Fragment {

    private ImageView bookImage;

    private EditText etQty;
    private TextView bAuthor, bPrice, bTitle, bDes;
    private int qty;
    private Button btnAdd;
    private static final String TAG = "DetailFragment";
    private BookID bookID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        bookImage = view.findViewById(R.id.bookImage);
        bTitle = view.findViewById(R.id.tv_btitle);
        bDes = view.findViewById(R.id.tv_bdes);
        bAuthor = view.findViewById(R.id.tv_bathor);
        bPrice = view.findViewById(R.id.tv_bprice);
        btnAdd = view.findViewById(R.id.btn_add_to_cart);
        etQty = view.findViewById(R.id.et_qty);
        bookImage = view.findViewById(R.id.bookImage);

        // Retrieve the book model string from the intent
        String bookModelString = getArguments().getString(Constants.DETAIL_KEY);
        bookID = new Gson().fromJson(bookModelString, BookID.class);

        // Set the book details in the UI
        bTitle.setText(bookID.getTitle());
        bDes.setText(bookID.getDesc());
        bPrice.setText(String.valueOf(bookID.getPrice()) + " $");
        bAuthor.setText(bookID.getAuthor());
        bookImage.setImageResource(bookID.getImage());

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qty = Integer.parseInt(etQty.getText().toString());
                if (qty > 0) {
                    String items = Utility.getStringFromSP(requireActivity(), "itemList");
                    if (items.equals("")) {
                        bookID.setQty(qty);
                        ArrayList<BookID> bookIDs = new ArrayList<>();
                        bookIDs.add(bookID);
                        Utility.saveStringToSP(requireActivity(), "itemList", new Gson().toJson(bookIDs));
                    } else {
                        ArrayList<BookID> storedBookModels = new Gson().fromJson(items, new TypeToken<List<BookID>>() {
                        }.getType());
                        boolean oldProduct = false;
                        for (int i = 0; i < storedBookModels.size(); i++) {
                            if (storedBookModels.get(i).getTitle().equals(bookID.getTitle())) {
                                oldProduct = true;
                                int oldCount = storedBookModels.get(i).getQty();
                                storedBookModels.get(i).setQty(oldCount + qty);
                            }
                        }
                        if (!oldProduct) {
                            bookID.setQty(qty);
                            storedBookModels.add(bookID);
                        }
                        Utility.saveStringToSP(requireActivity(), "itemList", new Gson().toJson(storedBookModels));
                    }
                    Toast.makeText(requireActivity(), "The book was added to the cart", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(requireActivity(), "Please enter a quantity greater than zero", Toast.LENGTH_SHORT).show();
                }

                ((ListAndDetailActivity) requireActivity()).updateTotalPrice();
            }
        });


        return view;
    }
}