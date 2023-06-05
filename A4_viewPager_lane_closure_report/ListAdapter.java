package com.example.zhaojuntao_a4;

import static com.example.zhaojuntao_a4.CloudCenter.group1_items;
import static com.example.zhaojuntao_a4.CloudCenter.group2_items;
import static com.example.zhaojuntao_a4.CloudCenter.selecteditem;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    ArrayList<String> data;
    Context context;
    private void combien_image(Drawable drawable1,Drawable drawable2,ImageView iv){
        // Scale factor for drawable2
        float scale = 0.5f;
        // Get the intrinsic width and height of drawable1 and drawable2
        int originalWidth1 = drawable1.getIntrinsicWidth();
        int originalHeight1 = drawable1.getIntrinsicHeight();
        int originalWidth2 = drawable2.getIntrinsicWidth();
        int originalHeight2 = drawable2.getIntrinsicHeight();
        // Calculate the new width and height of drawable2
        int newWidth2 = (int) (originalWidth2 * scale);
        int newHeight2 = (int) (originalHeight2 * scale);
        // Scale drawable2 to the new dimensions
        drawable2.setBounds(0, 0, newWidth2, newHeight2);
        // Calculate the position of drawable2 within the combined drawable
        int xOffset2 = (originalWidth1 - newWidth2) / 2;
        int yOffset2 = (originalHeight1 - newHeight2) / 2;
        // Create a LayerDrawable with drawable1 and scaled drawable2
        Drawable[] layers = {drawable1, drawable2};
        LayerDrawable layerDrawable = new LayerDrawable(layers);
        layerDrawable.setLayerInset(1, xOffset2, yOffset2, xOffset2, yOffset2);
        iv.setImageDrawable(layerDrawable);
    }
    public ListAdapter(Context context,ArrayList<String> data) {
        this.data = data;
        this.context = context;
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
        View v = View.inflate(context,R.layout.listitem,null);
        TextView tv_description = v.findViewById(R.id.tv_description);
        ImageView iv_delete = v.findViewById(R.id.iv_delete);
        ImageView iv_up = v.findViewById(R.id.iv_up);
        ImageView iv_down = v.findViewById(R.id.iv_down);

        String data_get = data.get(position);
        tv_description.setText(data_get);
        //get the 2 item
        String item1 = "";
        String item2 = "";
        if (data_get.contains(",")){
            String[] divide = data_get.split(",");
            item1 = divide[0];
            item2 = divide[1];
        }else{
            if (group1_items.contains(data_get)){
                item1 = data_get;
            }else if (group2_items.contains(data_get)){
                item2 = data_get;
            }
        }
        // set the image dependong on the chosen
        if (item1 == ""|| item1.equalsIgnoreCase("Shoulder")){
            iv_up.setImageResource(R.drawable.ic_open);
        }else{
            if (item1.equalsIgnoreCase("Hov"))
            {
                //combine image
                // Assuming you have an ImageView instance named "imageView" and a valid context
                Drawable drawable1 = ContextCompat.getDrawable(context, R.drawable.ic_open);
                Drawable drawable2 = ContextCompat.getDrawable(context, R.drawable.ic_hov);
                // Create a new Drawable with the combined images
                //Drawable combinedDrawable = new LayerDrawable(new Drawable[]{drawable1, drawable2});
                // Set the combined drawable as the image source of the ImageView
                //iv_up.setImageDrawable(combinedDrawable);
                combien_image(drawable1,drawable2,iv_up);
            }else if(item1.equalsIgnoreCase("Median")){
                Drawable drawable1 = ContextCompat.getDrawable(context, R.drawable.ic_open);
                Drawable drawable2 = ContextCompat.getDrawable(context, R.drawable.ic_median);
                combien_image(drawable1,drawable2,iv_up);

            }else if(item1.equalsIgnoreCase("Ramp")){
                Drawable drawable1 = ContextCompat.getDrawable(context, R.drawable.ic_open);
                Drawable drawable2 = ContextCompat.getDrawable(context, R.drawable.ic_ramp);
                //Drawable combinedDrawable = new LayerDrawable(new Drawable[]{drawable1, drawable2});
                //iv_up.setImageDrawable(combinedDrawable);
                combien_image(drawable1,drawable2,iv_up);
            }else if(item1.equalsIgnoreCase("Gore")){
                Drawable drawable1 = ContextCompat.getDrawable(context, R.drawable.ic_open);
                Drawable drawable2 = ContextCompat.getDrawable(context, R.drawable.ic_gore);
                //Drawable combinedDrawable = new LayerDrawable(new Drawable[]{drawable1, drawable2});
                //iv_up.setImageDrawable(combinedDrawable);
                combien_image(drawable1,drawable2,iv_up);
            }
        }
        if (item2.equalsIgnoreCase("Closed")){
            iv_down.setImageResource(R.drawable.ic_closed);
        }else if(item2.equalsIgnoreCase("Unknown")){
            iv_down.setImageResource(R.drawable.ic_unknown);
        }else if(item2.equalsIgnoreCase("Rolling")){
            iv_down.setImageResource(R.drawable.ic_rolling);
        }else if(item2.equalsIgnoreCase("Blocked")){
            iv_down.setImageResource(R.drawable.ic_blocked);
        }else if(item2.equalsIgnoreCase("Alternating")){
            iv_down.setImageResource(R.drawable.ic_alternating);
        }else if(item2.equalsIgnoreCase("Intermittent")){
            iv_down.setImageResource(R.drawable.ic_intermittent);
        }else if(item2.equalsIgnoreCase("Lanes affected")){
            iv_down.setImageResource(R.drawable.ic_lanesaffected);
        }else{
            iv_down.setImageDrawable(null);
        }


        iv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.remove(position);
                //update data
                MainActivity activity = (MainActivity) context;
                activity.getviewPagerAdapter().notifyDataSetChanged();
            }
        });
        return v;
    }

}
