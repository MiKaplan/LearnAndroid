package com.example.learnandroid;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learnandroid.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TasksActivity extends AppCompatActivity {

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false ));
        TaskAdapter adapter = new TaskAdapter(new TaskClickListener() {
            @Override
            public void onClick(Task task) {
                Toast.makeText(TasksActivity.this, task.getName() + " in progres...", Toast.LENGTH_LONG).show();
            }
        });
        rv.setAdapter(adapter);
        adapter.seData(generateFakeData());



    }
    public List<Task> generateFakeData(){
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            tasks.add(new Task("Task " + i, 3));
        }
        return  tasks;
    }
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

    public static class TaskViewHolder extends RecyclerView.ViewHolder{
        private TextView tvTaskName;
        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTaskName = itemView.findViewById(R.id.tvTaskName);
        }

        public void setData(Task task) {
            tvTaskName.setText(task.getName());
        }
    }
    public interface TaskClickListener{
        public void onClick(Task task);

    }
}
