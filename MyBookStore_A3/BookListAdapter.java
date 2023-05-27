package com.example.zhaojuntao_mybookstore_a3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BookListAdapter extends ArrayAdapter<Book> {
    private Context mycontext;
    int myResource;

    public BookListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Book> objects) {
        super(context, resource, objects);
        mycontext = context;
        myResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       //get the book information
        String bookname = getItem(position).getTitle();
        int booknum = getItem(position).getQty();
        double bookprice = getItem(position).getUnitPrice();
        String roundedBookPrice = String.format("%.2f", bookprice);
        double booktotal = booknum * bookprice;
        String roundedBookTotal = String.format("%.2f", booktotal);
        LayoutInflater inflater = LayoutInflater.from(mycontext);
        convertView = inflater.inflate(myResource,parent,false);
        TextView tv_name = (TextView)convertView.findViewById(R.id.tv_name);
        TextView tv_num = (TextView)convertView.findViewById(R.id.tv_num);
        TextView tv_price = (TextView)convertView.findViewById(R.id.tv_price);
        TextView tv_total = (TextView)convertView.findViewById(R.id.tv_total);
        tv_name.setText(bookname);
        tv_num.setText((booknum+""));
        tv_price.setText(roundedBookPrice);
        tv_total.setText(roundedBookTotal);
        return convertView;
    }
}
