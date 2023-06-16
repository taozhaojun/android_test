package com.example.fia_a3.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fia_a3.model.BookID;
import com.example.fia_a3.R;
import com.example.fia_a3.model.Constants;
import com.example.fia_a3.model.Utility;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    private ImageView bookImage;

    private EditText etQty;
    private TextView bAuthor, bPrice, bTitle, bDes;
    private int qty;
    private Button btnAdd;
    private static final String TAG = "DetailActivity";
    private BookID bookID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        bookImage = findViewById(R.id.bookImage);
        bTitle = findViewById(R.id.tv_btitle);
        bDes = findViewById(R.id.tv_bdes);
        bAuthor = findViewById(R.id.tv_bathor);
        bPrice = findViewById(R.id.tv_bprice);
        btnAdd = findViewById(R.id.btn_add_to_cart);
        etQty = findViewById(R.id.et_qty);
        bookImage = findViewById(R.id.bookImage);

        // Retrieve the book model string from the intent
        String bookModelString = getIntent().getStringExtra(Constants.DETAIL_KEY);
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
                    String items = Utility.getStringFromSP(DetailActivity.this, "itemList");
                    if (items.equals("")) {
                        bookID.setQty(qty);
                        ArrayList<BookID> bookIDs = new ArrayList<>();
                        bookIDs.add(bookID);
                        Utility.saveStringToSP(DetailActivity.this, "itemList", new Gson().toJson(bookIDs));
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
                        Utility.saveStringToSP(DetailActivity.this, "itemList", new Gson().toJson(storedBookModels));
                    }
                    Toast.makeText(DetailActivity.this, "The book was added to the cart", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(DetailActivity.this, "Please enter a quantity greater than zero", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        setup();
    }

    private void setup() {
        etQty.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals("")) {
                    qty = Integer.parseInt(s.toString());
                } else {
                    qty = 0;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}