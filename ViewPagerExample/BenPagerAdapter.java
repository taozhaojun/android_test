package com.ben.viewpagerexample;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManagerNonConfig;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class BenPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragments;

    public BenPagerAdapter(@NonNull FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

//        if(position == 0 ){
//            return new BenListFragment();
//        } else if (position == 1) {
//            return new PictureFragment();
//
//        }
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Picture";
        } else if (position == 1) {
            return "List";

        } else {
            return "Text";
        }
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
