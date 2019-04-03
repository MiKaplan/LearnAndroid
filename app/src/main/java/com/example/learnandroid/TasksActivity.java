package com.example.learnandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class TasksActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        ViewPager vp = findViewById(R.id.vp);
        TabLayout tl = findViewById(R.id.tl);

        PageAdapter adapter = new PageAdapter(getSupportFragmentManager());
        vp.setAdapter(adapter);
        tl.setupWithViewPager(vp);
    }
    public class PageAdapter extends FragmentStatePagerAdapter{

        public PageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return "Tasks";
        }

        @Override
        public Fragment getItem(int position) {
            return new TasksFragment();
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
