package com.njumzc.gitlabtss.features.teacher;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.njumzc.gitlabtss.R;
import com.njumzc.gitlabtss.api.vo.Class;

import java.util.List;

/**
 * Created by NjuMzc on 2017/6/27.
 */

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ViewHolder>{
    private List<Class> classList;
    private TeacherClassActivity activity;


    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView className;
        View classView;
        public ViewHolder(View itemView) {
            super(itemView);
            classView = itemView;
            className = (TextView) itemView.findViewById(R.id.item_class_name);
        }
    }

    public ClassAdapter(List<Class> classList,TeacherClassActivity activity){
        this.classList = classList;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_teacher_class,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.classView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Class myClass = classList.get(position);
                Intent intent = new Intent(v.getContext(),TeacherStudentsActivity.class);
                intent.putExtra("className",myClass.getName());
                intent.putExtra("classId",myClass.getId());
                activity.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Class myClass = classList.get(position);
        holder.className.setText(myClass.getName());
    }

    @Override
    public int getItemCount() {
        return classList.size();
    }

}
