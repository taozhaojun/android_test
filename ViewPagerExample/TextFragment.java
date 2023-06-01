package com.ben.viewpagerexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class TextFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_text, container, false);
        TextView tv_display = v.findViewById(R.id.tv_display);

        tv_display.setText(CloudCenter.currentItem); // two times
        return v;
    }
}