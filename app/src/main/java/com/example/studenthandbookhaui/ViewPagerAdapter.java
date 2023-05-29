package com.example.studenthandbookhaui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.studenthandbookhaui.fragment.HomeFragment;
import com.example.studenthandbookhaui.fragment.ScheduleFragment;
import com.example.studenthandbookhaui.fragment.UserFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ScheduleFragment();
            case 1:
                return new HomeFragment();
            case 2:
                return new UserFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
