package com.julienb.assignment3_mobdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;

public class BookListActivity extends AppCompatActivity {

    private ArrayList<MenuItem> menuItemsList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        setTitle("Bibliothèque");

        ((TextView)findViewById(R.id.total_text)).setText((new BigDecimal(DataSource.getCartTotal()).setScale(2, BigDecimal.ROUND_HALF_UP).toString()));

        String imageButtonId = getIntent().getExtras().getString("imageButtonId");
        ListView menuItemsListView = (ListView) findViewById(R.id.menu_list);


        // Switch case depending on the menu the user wants to see
        switch (imageButtonId){
            case "autobiography_menu_img":
                menuItemsList = DataSource.getAutobiography();
                break;

            case "fictional_menu_img":
                menuItemsList = DataSource.getFiction();
                break;

            case "comics_menu_img":
                menuItemsList = DataSource.getComics();
                break;

            case "self_help_menu_img":
                menuItemsList = DataSource.getSelfHelpBook();
                break;
        }

        //Creating the adapter and giving it the menuItems
        ArrayAdapter listViewAdapter = new ArrayAdapter<>(this, R.layout.book_item, DataSource.getMenuItemsNames(menuItemsList));
        // Linking the list view and the adapter
        menuItemsListView.setAdapter(listViewAdapter);

        // Creating the onClickListener event for each list items
        menuItemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Getting the "name" of the item clicked
                String itemName = (String)parent.getItemAtPosition(position);
                MenuItem selectedItem = DataSource.getItemDetailsByName(BookListActivity.this.menuItemsList, itemName);
                // Launching the appropriate details activity depending on the item clicked
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("itemName", selectedItem.name);
                intent.putExtra("itemDescription", selectedItem.description);
                intent.putExtra("author", selectedItem.author);
                intent.putExtra("itemPrice", selectedItem.price);
                intent.putExtra("itemImage", selectedItem.image);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        // Let's refresh the total when we come back to this activity
        ((TextView)findViewById(R.id.total_text)).setText("Total: "+ (new BigDecimal(DataSource.getCartTotal()).setScale(2, BigDecimal.ROUND_HALF_UP).toString())+ " $");
    }

    public void seeCartClicked(View view) {
        // opening the cart activity on button click
        Intent intent = new Intent(view.getContext(), CartActivity.class);
        startActivity(intent);
    }
}