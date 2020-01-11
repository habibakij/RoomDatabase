package com.example.customroom;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    private Context mContext;
    private List<Task> taskList;

    public TaskAdapter(Context mContext, List<Task> taskList) {
        this.mContext = mContext;
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.taskitem, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task mTask= taskList.get(position);
        holder.textViewTask.setText(mTask.getTask());
        holder.textViewDesc.setText(mTask.getDesc());
        holder.textUseBy.setText(mTask.getUseby());
        if (mTask.isFinished()){
            holder.textViewStatus.setText("Complete");
        } else {
            holder.textViewStatus.setText("InComplete");
        }
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {

        TextView textViewStatus, textViewTask, textViewDesc, textUseBy;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewStatus = itemView.findViewById(R.id.textViewStatus);
            textViewTask = itemView.findViewById(R.id.textViewTask);
            textViewDesc = itemView.findViewById(R.id.textViewDesc);
            textUseBy = itemView.findViewById(R.id.textUseBy);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Task task= taskList.get(getAdapterPosition());

                    Intent intent= new Intent(mContext, UpdateData.class);
                    intent.putExtra("task", task);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
