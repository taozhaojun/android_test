package com.example.fia_a3.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fia_a3.R;
import com.example.fia_a3.activity.BookListActivity;
import com.example.fia_a3.activity.CartActivity;
import com.example.fia_a3.activity.DetailActivity;
import com.example.fia_a3.activity.ListAndDetailActivity;
import com.example.fia_a3.adapter.BookListAdapter;
import com.example.fia_a3.model.BookID;
import com.example.fia_a3.model.Constants;
import com.google.gson.Gson;

import java.util.ArrayList;


public class BookListFragment extends Fragment {


    private ListView bookListView;
    private ArrayList<BookID> bookIDs = new ArrayList<>();
    private BookListAdapter bookListAdapter;

    private static final String TAG = "BookListFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_book_list, container, false);
        Log.d(TAG, "onCreate: started");

        // Get the list of book titles for the selected category
        getBookList();


        // Declare Views
        bookListView = view.findViewById(R.id.list_view);
        bookListAdapter = new BookListAdapter(bookIDs, requireActivity());
        bookListView.setAdapter(bookListAdapter);
        bookListView.setOnItemClickListener((parent, v, position, id) -> {
            String bookModelString = new Gson().toJson(bookIDs.get(position));
            DetailFragment detailFragment = new DetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString(Constants.DETAIL_KEY, bookModelString);
            detailFragment.setArguments(bundle);
            ((ListAndDetailActivity) requireActivity()).getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_container, detailFragment).commit();

            Log.d(TAG, "onCreate: bookModelString");
        });

        return view;
    }

    private void getBookList() {
        // Retrieve the selected category from the intent
        String category = getArguments().getString(Constants.CATEGORY_KEY);
        Log.d(TAG, "getBookList: category: " + category); // Add this line to log the category value

        switch (category) {
            case Constants.BIOGRAPHY:
                bookIDs = Constants.biographyList(requireActivity());
                break;
            case Constants.ROMANCE:
                bookIDs = Constants.romanceList(requireActivity());
                break;
            case Constants.FICTION:
                bookIDs = Constants.fictionList(requireActivity());
                break;
            case Constants.POEM:
                bookIDs = Constants.poemList(requireActivity());
                break;
        }

        Log.d(TAG, "getBookList: bookIDs size: " + bookIDs.size()); // Add this line to log the size of the bookIDs list
    }
}