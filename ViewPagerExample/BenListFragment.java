package com.ben.viewpagerexample;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class BenListFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ben_list, container, false);
        ListView listView = v.findViewById(R.id.list_view);

        ArrayList<String> data = new ArrayList<>();

        for (int i = 1; i <=500; i++){
            data.add(String.valueOf(i));
        }

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.list_item,R.id.tv_item, data);
        ListAdapter adapter = new ListAdapter(getActivity(), data);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                CloudCenter.currentItem = String.valueOf(data.get(position));

                MainActivity activity = (MainActivity) getActivity();
                activity.getBenPagerAdapter().notifyDataSetChanged();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.bottom_right_container, new TextFragment()).commit();

            }
        });

        return v;
    }
}