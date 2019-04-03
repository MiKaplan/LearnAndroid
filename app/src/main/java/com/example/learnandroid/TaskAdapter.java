package com.example.learnandroid;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder>{
    private final List<Task> data = new ArrayList<>() ;
    private final TaskClickListener taskClickListener;

    public TaskAdapter(TaskClickListener taskClickListener) {
    this.taskClickListener = taskClickListener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_task, viewGroup, false);
        TaskViewHolder viewHolder = new TaskViewHolder(view);

//            Spannable point = new SpannableString("•");

//            Random random = new Random();
//            int color1 = ContextCompat.getColor(TasksActivity.this, R.color.pointColorBlue);
//            int color2 = ContextCompat.getColor(TasksActivity.this, R.color.pointColorGreen);
//            int color3 = ContextCompat.getColor(TasksActivity.this, R.color.pointColorRed);
//            int color4 = ContextCompat.getColor(TasksActivity.this, R.color.pointColorYellow);
//            int colors [] = {color1, color2, color3, color4};
//            int pos = random.nextInt(colors.length);
//
//            point.setSpan(new ForegroundColorSpan(colors[pos]), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//
//
//            TextView textView = findViewById(R.id.ivPoint);
//            textView.setTextColor(colors[pos]);
//            setContentView(textView);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (RecyclerView.NO_POSITION != position) {
                    taskClickListener.onClick(data.get(position));
                }
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder taskViewHolder, int position) {
    Task task = data.get(position);
    taskViewHolder.setData(task);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void seData(List<Task> data) {
    this.data.clear();
    this.data.addAll(data);
    notifyDataSetChanged();
    }
}
