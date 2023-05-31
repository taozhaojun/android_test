package com.ben.listviewexample;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BenStyleAdapter extends BaseAdapter {

    Context context;
    User[] data;

    public BenStyleAdapter(Context context, User[] data){
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {//how many data
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.list_item, null);
        TextView tv_display = v.findViewById(R.id.tv_item);
        ImageView imageView = v.findViewById(R.id.imageView);
        TextView tv_price = v.findViewById(R.id.tv_price);



        tv_display.setText(((User)getItem(position)).getName());
        imageView.setImageResource(data[position].getImgId());
        tv_price.setText(data[position].getPrice()+"");

        return v;
    }

    public void clear(){
        data = new User[0];
    }
}
