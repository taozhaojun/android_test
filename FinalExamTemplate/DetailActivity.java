package com.julienb.assignment3_mobdev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    private String itemPrice = "0";
    private String itemName = "";
    private String author = "";
    private String itemDescription = "";
    private String itemImage = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // getting item info from previous activity and storing everything in class variables
        itemName = getIntent().getExtras().getString("itemName");
        author = getIntent().getExtras().getString("author");
        itemDescription = getIntent().getExtras().getString("itemDescription");
        itemPrice = getIntent().getExtras().getString("itemPrice");
        itemImage = getIntent().getExtras().getString("itemImage");

        setTitle("Bibliothèque");

        // setting texts of the view
        ((TextView)findViewById(R.id.item_name_text)).setText(itemName);
        ((TextView)findViewById(R.id.description)).setText(itemDescription);
        ((TextView)findViewById(R.id.item_author)).setText(author);
        ((TextView)findViewById(R.id.item_price_text)).setText("$"+itemPrice);
        ((ImageView)findViewById(R.id.item_image_view)).setImageResource(getResources().getIdentifier(itemImage , "drawable", getPackageName()));
    }

    public void addToCartClicked(View view) {
        // getting the quantity desired
        String desiredQuantity = ((EditText)findViewById(R.id.quantity_edit)).getText().toString();
        // checking if the quantity entered is valid
        if(desiredQuantity.equals("") || desiredQuantity.equals("0")){
            Toast.makeText(view.getContext(), "Please enter a valid quantity",Toast.LENGTH_SHORT).show();
        }
        else{
            // adding the item to the cart and creating a confirmation toast
            DataSource.addToCart(new MenuItem(itemName,author, itemDescription, itemPrice, itemImage), Integer.parseInt(desiredQuantity));
            Toast.makeText(this, desiredQuantity + " item(s) added to cart", Toast.LENGTH_SHORT).show();
            // going back tot the previous activity
            finish();
        }

    }
}