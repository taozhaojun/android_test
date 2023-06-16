package com.example.fia_a3.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.fia_a3.model.BookID;
import com.example.fia_a3.R;

import java.util.ArrayList;

public class BookListAdapter extends ArrayAdapter<BookID> implements View.OnClickListener {
    private static final String TAG = "BookListAdapter";
    private ArrayList<BookID> dataSet;
    private Context context;
    private int lastPosition = -1;

    public BookListAdapter(ArrayList<BookID> data, Context context) {
        super(context, R.layout.list_item_layout, data);
        this.dataSet = data;
        this.context = context;
        Log.d(TAG, "BookListAdapter: data " + data);
    }

    private static class ViewHolder {
        TextView bookName;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        BookID bookID = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_item_layout, parent, false);
            viewHolder.bookName = convertView.findViewById(R.id.tv_book_item);

            convertView.setTag(viewHolder);
            Log.d(TAG, "getView: if");
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            Log.d(TAG, "getView: else");
        }
        lastPosition = position;

        viewHolder.bookName.setText(bookID.getTitle());

        // Return the completed view to render on screen
        return convertView;
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick: done");
    }
}

