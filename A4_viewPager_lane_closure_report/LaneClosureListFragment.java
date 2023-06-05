package com.example.zhaojuntao_a4;

import static com.example.zhaojuntao_a4.CloudCenter.selecteditem;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class LaneClosureListFragment extends Fragment {
    ImageView iv_road;
    TextView tv_current;
    TextView tv_toadd;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment\
        View v = inflater.inflate(R.layout.fragment_lane_closure_list, container, false);
        ListView listview = v.findViewById(R.id.list_view);
        iv_road = v.findViewById(R.id.iv_road);
        tv_current = v.findViewById(R.id.tv_current);
        tv_toadd = v.findViewById(R.id.tv_toadd);


        iv_road.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.viewPager.setCurrentItem(1);
            }
        });

        // set visibility
        if (selecteditem.size()==0){
            listview.setVisibility(View.INVISIBLE);
            iv_road.setVisibility(View.VISIBLE);
            tv_current.setVisibility(View.VISIBLE);
            tv_toadd.setVisibility(View.VISIBLE);
        }else{
            //set the image and text visibility to invisible
            iv_road.setVisibility(View.INVISIBLE);
            tv_current.setVisibility(View.INVISIBLE);
            tv_toadd.setVisibility(View.INVISIBLE);
            //set the list visible
            listview.setVisibility(View.VISIBLE);
            //ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,selecteditem);
            ListAdapter listadapter = new ListAdapter(getActivity(),selecteditem);
            listview.setAdapter(listadapter);
        }


        return v;
    }
}