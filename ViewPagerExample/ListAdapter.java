package com.ben.viewpagerexample;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class ListAdapter extends BaseAdapter {
    List<String> data;
    Context context;

    public ListAdapter(Context context, List<String> data){
        this.context = context;
        this.data = data;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(context, R.layout.list_item, null);
        TextView tv_item = v.findViewById(R.id.tv_item);
        if(position % 2 == 0){//color red
            tv_item.setBackgroundColor(Color.RED);
        }else{
            tv_item.setBackgroundColor(Color.BLUE);
        }

        tv_item.setText(data.get(position));
        return v;
    }
}
