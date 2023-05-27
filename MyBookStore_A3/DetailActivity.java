package com.example.zhaojuntao_mybookstore_a3;

import static com.example.zhaojuntao_mybookstore_a3.KeyValue.CATEGORY_KEY;
import static com.example.zhaojuntao_mybookstore_a3.KeyValue.POSITION_KEY;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    TextView tv_title;
    ImageView iv_bookimage;
    TextView tv_description;
    TextView tv_author;
    TextView tv_unitprice;
    EditText etn_qty;
    Button btn_additem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
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
        //set the link
        tv_title = findViewById(R.id.tv_title);
        iv_bookimage = findViewById(R.id.iv_bookimage);
        tv_description = findViewById(R.id.tv_description);
        tv_author = findViewById(R.id.tv_author);
        tv_unitprice = findViewById(R.id.tv_unitprice);
        etn_qty = findViewById(R.id.etn_qty);
        btn_additem = findViewById(R.id.btn_additem);


        //get information from intent
        String book_category = getIntent().getStringExtra(CATEGORY_KEY);
        int pos = getIntent().getIntExtra(POSITION_KEY, 0);
        if (book_category.equalsIgnoreCase("fasion"))
        {
            if (pos == 0)
            {
                tv_title.setText("Making Face");
                iv_bookimage.setBackgroundResource(R.drawable.makeface);
                tv_description.setText("A successful makeup artist to the stars offers an illustrated guide that presents his makeup hints and tricks.");
                tv_author.setText("Kevyn Aucoin");
                tv_unitprice.setText("$"+"10.10");
            }
            else if (pos == 1)
            {
                tv_title.setText("Coco Chanel");
                iv_bookimage.setBackgroundResource(R.drawable.coco);
                tv_description.setText("In this international bestseller from the critically acclaimed Little People, BIG DREAMS series, discover the inspiring story of this international style icon. ");
                tv_author.setText("Ana Albero");
                tv_unitprice.setText("$"+"6.30");
            }
            else if (pos == 2)
            {
                tv_title.setText("Color Me Beautiful");
                iv_bookimage.setBackgroundResource(R.drawable.colorme);
                tv_description.setText("Using simple guidelines, professional color consultant Carole Jackson helps you choose the thirty shades that make you look smashing.");
                tv_author.setText("Carole Jackson");
                tv_unitprice.setText("$"+"8.50");

            }
            else if (pos == 3)
            {
                tv_title.setText("Supreme Models");
                iv_bookimage.setBackgroundResource(R.drawable.suprememodels);
                tv_description.setText("This coffee-table book is the first-ever collection of works devoted to celebrating black models.");
                tv_author.setText("Marcellas Reynolds");
                tv_unitprice.setText("$"+"22.50");
            }
        }
        else if (book_category.equalsIgnoreCase("music"))
        {
            if (pos == 0)
            {
                tv_title.setText("Piano and Keyboard Chords");
                iv_bookimage.setBackgroundResource(R.drawable.piano);
                tv_description.setText("This is a handy, comprehensive reference for jazz, pop, rock and soul musicians playing the piano or keyboard at any level.");
                tv_author.setText("Jake Jackson");
                tv_unitprice.setText("$"+"6.20");
            }
            else if (pos == 1)
            {
                tv_title.setText("The Story of Rap");
                iv_bookimage.setBackgroundResource(R.drawable.rap);
                tv_description.setText("Lay down a baby beat and learn all about the history of rap From Grandmaster Flash to Kendrick Lamar.");
                tv_author.setText("Nicola Edwards");
                tv_unitprice.setText("$"+"8.50");
            }
            else if (pos == 2)
            {
                tv_title.setText("Violin for Dummies");
                iv_bookimage.setBackgroundResource(R.drawable.violin);
                tv_description.setText("The beginner's guide to learning the violin");
                tv_author.setText("Katharine Rapoport");
                tv_unitprice.setText("$"+"12.50");

            }
            else if (pos == 3)
            {
                tv_title.setText("Suzuki Cello School");
                iv_bookimage.setBackgroundResource(R.drawable.suzuki_);
                tv_description.setText("Teach Cello with the popular Suzuki Cello School.");
                tv_author.setText("Shinichi Suzuki");
                tv_unitprice.setText("$"+"6.50");
            }
        }
        else if (book_category.equalsIgnoreCase("computers"))
        {
            if (pos == 0)
            {
                tv_title.setText("Excel for Dummies");
                iv_bookimage.setBackgroundResource(R.drawable.excel);
                tv_description.setText("Whatever you're now doing with Microsoft Excel - there's much more you could be doing.");
                tv_author.setText("Greg Harvey");
                tv_unitprice.setText("$"+"6.50");
            }
            else if (pos == 1)
            {
                tv_title.setText("Cracking the Coding Interview");
                iv_bookimage.setBackgroundResource(R.drawable.interview);
                tv_description.setText("Cracking the Coding Interview gives you the interview preparation you need to get the top software developer jobs.");
                tv_author.setText("Gayle Laakmann McDowell");
                tv_unitprice.setText("$"+"16.50");

            }
            else if (pos == 2)
            {
                tv_title.setText("HTML and CSS");
                iv_bookimage.setBackgroundResource(R.drawable.html);
                tv_description.setText("A full-color introduction to the basics of HTML and CSS.");
                tv_author.setText("Jon Duckett");
                tv_unitprice.setText("$"+"8.50");
            }
            else if (pos == 3)
            {
                tv_title.setText("Thinking with Type");
                iv_bookimage.setBackgroundResource(R.drawable.type);
                tv_description.setText("The organization of letters on a blank sheet or screen is the most basic challenge facing anyone who practices design.");
                tv_author.setText("Ellen Lupton");
                tv_unitprice.setText("$"+"6.50");
            }
        }
        else if (book_category.equalsIgnoreCase("cooking"))
        {
            if (pos == 0)
            {
                tv_title.setText("More Than Cake");
                iv_bookimage.setBackgroundResource(R.drawable.cake);
                tv_description.setText("The sumptuous debut cookbook from celebrated baker, activist, and pastry.");
                tv_author.setText("Natasha Pickowicz");
                tv_unitprice.setText("$"+"30.30");

            }
            else if (pos == 1)
            {
                tv_title.setText("On the Curry Trail");
                iv_bookimage.setBackgroundResource(R.drawable.curry);
                tv_description.setText("Award-winning author and instructor Raghavan Iyer explores the origin of curry.");
                tv_author.setText("Raghavan Iyer");
                tv_unitprice.setText("$"+"22.40");

            }
            else if (pos == 2)
            {
                tv_title.setText("Teatime Discipleship");
                iv_bookimage.setBackgroundResource(R.drawable.teatime);
                tv_description.setText("Cultivate Friendship, Feasting, and Fellowship As a mother, friend, and traveler, Sally Clarkson has witnessed on countless occasions how a shared cup of tea can impact a heart.");
                tv_author.setText("Sally Clarkson");
                tv_unitprice.setText("$"+"26.50");

            }
            else if (pos == 3)
            {
                tv_title.setText("Everyday Bread");
                iv_bookimage.setBackgroundResource(R.drawable.bread);
                tv_description.setText("Simplify the baking equation to add up to bread, of all kinds, on any schedule, as often as every day.");
                tv_author.setText("America's Test Kitchen");
                tv_unitprice.setText("$"+"28.80");
            }
        }
        //button click
        btn_additem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double unit_price = Double.parseDouble(tv_unitprice.getText().toString().substring(1));
                int qty;
                try {
                    qty = Integer.parseInt(etn_qty.getText().toString());
                    Book book_added = new Book(tv_title.getText().toString(),unit_price,qty);
                    // Accessing cartItems
                    ArrayList<Book> cartItems = CartData.getCartItems();
                    // Check if the book is already in cartItems
                    boolean bookExists = false;
                    for (Book book : cartItems) {
                        if (book.getTitle().equals(book_added.getTitle())) {
                            book.setQty(book.getQty() + qty);
                            bookExists = true;
                            break;
                        }
                    }
                    // If the book doesn't exist in cartItems, add it
                    if (!bookExists) {
                        cartItems.add(book_added);
                    }
                    // renew cartItems
                    CartData.setCartItems(cartItems);
                    // return to BookListActivity
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra(CATEGORY_KEY, book_category);
                    setResult(0, returnIntent);
                    finish();
                } catch (NumberFormatException e) {
                    Toast.makeText(DetailActivity.this, "Invalid quantity", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}