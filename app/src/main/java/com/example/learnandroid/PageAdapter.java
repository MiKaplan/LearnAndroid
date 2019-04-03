package com.example.learnandroid;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter {

    private final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[]{"Tasks", "Productivity"};

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new TasksFragment();
        } else {
            return new ProductivityFragment();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
