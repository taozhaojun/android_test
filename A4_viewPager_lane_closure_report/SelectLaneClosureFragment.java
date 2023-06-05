package com.example.zhaojuntao_a4;

import static com.example.zhaojuntao_a4.CloudCenter.selecteditem;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class SelectLaneClosureFragment extends Fragment {
    private FrameLayout selected_fl_group1;
    private ImageView selected_iv_group1;
    private TextView selected_tv_group1;
    private FrameLayout selected_fl_group2;
    private ImageView selected_iv_group2;
    private TextView selected_tv_group2;
    Button btn_cancel;
    Button btn_save;

    FrameLayout fl_shoulder;
    ImageView iv_shoulder;
    TextView tv_shoulder;
    FrameLayout fl_hov;
    ImageView iv_hov;
    TextView tv_hov;
    FrameLayout fl_median;
    ImageView iv_median;
    TextView tv_median;
    FrameLayout fl_ramp;
    ImageView iv_ramp;
    TextView tv_ramp;
    FrameLayout fl_gore;
    ImageView iv_gore;
    TextView tv_gore;
    FrameLayout fl_closed;
    ImageView iv_closed;
    TextView tv_closed;

    FrameLayout fl_unknown;
    ImageView iv_unknown;
    TextView tv_unknown;
    FrameLayout fl_rolling;
    ImageView iv_rolling;
    TextView tv_rolling;
    FrameLayout fl_blocked;
    ImageView iv_blocked;
    TextView tv_blocked;
    FrameLayout fl_alternating;
    ImageView iv_alternating;
    TextView tv_alternating;
    FrameLayout fl_intermittent;
    ImageView iv_intermittent;
    TextView tv_intermittent;
    FrameLayout fl_lanesaffected;
    ImageView iv_lanesaffected;
    TextView tv_lanesaffected;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_select_lane_closure, container, false);
        btn_cancel = v.findViewById(R.id.btn_cancel);
        btn_save = v.findViewById(R.id.btn_save);
        fl_shoulder = v.findViewById(R.id.fl_shoulder);
        iv_shoulder = v.findViewById(R.id.iv_shoulder);
        tv_shoulder = v.findViewById(R.id.tv_shoulder);
        fl_hov = v.findViewById(R.id.fl_hov);
        iv_hov = v.findViewById(R.id.iv_hov);
        tv_hov = v.findViewById(R.id.tv_hov);
        fl_median = v.findViewById(R.id.fl_median);
        iv_median = v.findViewById(R.id.iv_median);
        tv_median = v.findViewById(R.id.tv_median);
        fl_ramp = v.findViewById(R.id.fl_ramp);
        iv_ramp = v.findViewById(R.id.iv_ramp);
        tv_ramp = v.findViewById(R.id.tv_ramp);
        fl_gore = v.findViewById(R.id.fl_gore);
        iv_gore = v.findViewById(R.id.iv_gore);
        tv_gore = v.findViewById(R.id.tv_gore);
        fl_closed = v.findViewById(R.id.fl_closed);
        iv_closed = v.findViewById(R.id.iv_closed);
        tv_closed = v.findViewById(R.id.tv_closed);
        fl_unknown = v.findViewById(R.id.fl_unknown);
        iv_unknown = v.findViewById(R.id.iv_unknown);
        tv_unknown = v.findViewById(R.id.tv_unknown);
        fl_rolling = v.findViewById(R.id.fl_rolling);
        iv_rolling = v.findViewById(R.id.iv_rolling);
        tv_rolling = v.findViewById(R.id.tv_rolling);
        fl_blocked = v.findViewById(R.id.fl_blocked);
        iv_blocked = v.findViewById(R.id.iv_blocked);
        tv_blocked = v.findViewById(R.id.tv_blocked);
        fl_alternating = v.findViewById(R.id.fl_alternating);
        iv_alternating = v.findViewById(R.id.iv_alternating);
        tv_alternating = v.findViewById(R.id.tv_alternating);
        fl_intermittent = v.findViewById(R.id.fl_intermittent);
        iv_intermittent = v.findViewById(R.id.iv_intermittent);
        tv_intermittent = v.findViewById(R.id.tv_intermittent);
        fl_lanesaffected = v.findViewById(R.id.fl_lanesaffected);
        iv_lanesaffected = v.findViewById(R.id.iv_lanesaffected);
        tv_lanesaffected = v.findViewById(R.id.tv_lanesaffected);


        fl_shoulder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleItemClick(fl_shoulder,iv_shoulder,tv_shoulder,1);
            }
        });
        fl_hov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleItemClick(fl_hov,iv_hov,tv_hov,1);
            }
        });
        fl_median.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleItemClick(fl_median,iv_median,tv_median,1);
            }
        });
        fl_ramp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleItemClick(fl_ramp,iv_ramp,tv_ramp,1);
            }
        });
        fl_gore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleItemClick(fl_gore,iv_gore,tv_gore,1);
            }
        });
        fl_closed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleItemClick(fl_closed,iv_closed,tv_closed,2);
            }
        });
        fl_unknown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleItemClick(fl_unknown,iv_unknown,tv_unknown,2);
            }
        });
        fl_rolling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleItemClick(fl_rolling,iv_rolling,tv_rolling,2);
            }
        });
        fl_blocked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleItemClick(fl_blocked,iv_blocked,tv_blocked,2);
            }
        });
        fl_alternating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleItemClick(fl_alternating,iv_alternating,tv_alternating,2);
            }
        });
        fl_intermittent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleItemClick(fl_intermittent,iv_intermittent,tv_intermittent,2);
            }
        });
        fl_lanesaffected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleItemClick(fl_lanesaffected,iv_lanesaffected,tv_lanesaffected,2);
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(), "Hello, Toast!", Toast.LENGTH_SHORT).show();
                //return to list fragment
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.viewPager.setCurrentItem(0);
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item1 = "";
                String item2 = "";
                //get data
                if (selected_fl_group1 == null && selected_fl_group2 == null) {
                    Toast.makeText(getActivity(), "Nothing added", Toast.LENGTH_SHORT).show();
                    //return to list fragment
                    MainActivity mainActivity = (MainActivity) getActivity();
                    mainActivity.viewPager.setCurrentItem(0);
                    return;

                }else if (selected_fl_group1 != null){
                    item1 = selected_tv_group1.getText().toString();
                    if (selected_fl_group2 != null){
                        item2 = selected_tv_group2.getText().toString();
                    }
                }else{
                    if (selected_fl_group2 != null){
                        item2 = selected_tv_group2.getText().toString();
                    }
                }
                //combine data
                String itemchosen = "";
                if (item1 == ""){
                    itemchosen = item2;
                }else{
                    if(item2 != ""){
                        itemchosen = item1+","+item2;
                    }else{
                        itemchosen = item1;
                    }
                }
                //Toast.makeText(getActivity(), itemchosen, Toast.LENGTH_SHORT).show();
                selecteditem.add(itemchosen);
                //set selected_fl_group1 and selected_fl_group2 to null
                selected_fl_group1 = null;
                selected_fl_group2 = null;
                //update data
                MainActivity activity = (MainActivity) getActivity();
                activity.getviewPagerAdapter().notifyDataSetChanged();

                //return to list fragment
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.viewPager.setCurrentItem(0);

            }
        });

        return v;
    }

    // Method to handle type item click
    private void handleItemClick(FrameLayout item_fl,ImageView item_iv,TextView item_tv,int group) {
        if(group == 1){
            if (selected_fl_group1 != null && selected_fl_group1 != item_fl) {
                // Deselect the previously selected item
                // Remove the visual state indicating selection (e.g., change background color)
                selected_fl_group1.setBackgroundResource(R.drawable.round_primary_bg);
                selected_iv_group1.clearColorFilter();
                selected_tv_group1.setTextColor(getResources().getColor(R.color.black));
                //set the flag to 0
            }
            if (selected_fl_group1 != null && selected_fl_group1 == item_fl) {
                // Deselect the previously selected item
                // Remove the visual state indicating selection (e.g., change background color)
                item_fl.setBackgroundResource(R.drawable.round_primary_bg);
                item_iv.clearColorFilter();
                item_tv.setTextColor(getResources().getColor(R.color.black));
                selected_fl_group1 = null;
                selected_iv_group1 = null;
                selected_tv_group1 = null;
                return;
            }
            // Select the clicked item
            // Apply the visual state indicating selection (e.g., change background color)
            item_fl.setBackgroundResource(R.drawable.round_setting_bg);
            item_iv.setColorFilter(getResources().getColor(R.color.white));
            item_tv.setTextColor(getResources().getColor(R.color.white));
            // Update the reference to the selected item
            selected_fl_group1 = item_fl;
            selected_iv_group1 = item_iv;
            selected_tv_group1 = item_tv;
        }else if(group == 2){
            if (selected_fl_group2 != null && selected_fl_group2 != item_fl) {
                // Deselect the previously selected item
                // Remove the visual state indicating selection (e.g., change background color)
                selected_fl_group2.setBackgroundResource(R.drawable.round_primary_bg);
                selected_iv_group2.clearColorFilter();
                selected_tv_group2.setTextColor(getResources().getColor(R.color.black));
                //set the flag to 0
            }
            if (selected_fl_group2 != null && selected_fl_group2 == item_fl) {
                // Deselect the previously selected item
                // Remove the visual state indicating selection (e.g., change background color)
                item_fl.setBackgroundResource(R.drawable.round_primary_bg);
                item_iv.clearColorFilter();
                item_tv.setTextColor(getResources().getColor(R.color.black));
                selected_fl_group2 = null;
                selected_iv_group2 = null;
                selected_tv_group2 = null;
                return;
            }
            // Select the clicked item
            // Apply the visual state indicating selection (e.g., change background color)
            item_fl.setBackgroundResource(R.drawable.round_setting_bg);
            item_iv.setColorFilter(getResources().getColor(R.color.white));
            item_tv.setTextColor(getResources().getColor(R.color.white));
            // Update the reference to the selected item
            selected_fl_group2 = item_fl;
            selected_iv_group2 = item_iv;
            selected_tv_group2 = item_tv;
        }
    }
}