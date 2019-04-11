package com.example.learnandroid;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Adapter;

public class SwipeToDeleteCallBack extends ItemTouchHelper.SimpleCallback {
    private Adapter mAdapter;
    public  SwipeToDeleteCallBack (Adapter adapter) {
        super(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        mAdapter = adapter;
    }
    public SwipeToDeleteCallBack(int dragDirs, int swipeDirs) {
        super(dragDirs, swipeDirs);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
int position = viewHolder.getAdapterPosition();
//    mAdapter.deleteItem(position);
    }
}
