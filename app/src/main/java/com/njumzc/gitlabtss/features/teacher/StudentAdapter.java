package com.njumzc.gitlabtss.features.teacher;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.njumzc.gitlabtss.R;
import com.njumzc.gitlabtss.api.vo.StudentInClass;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by NjuMzc on 2017/6/27.
 */

public class StudentAdapter  extends RecyclerView.Adapter<StudentAdapter.ViewHolder>{
    private List<StudentInClass> studentList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView avatar;
        TextView nameText;
        TextView numberText;
        TextView detailText;

        public ViewHolder(View itemView) {
            super(itemView);
            avatar = (CircleImageView) itemView.findViewById(R.id.teacher_student_avatar);
            nameText = (TextView) itemView.findViewById(R.id.item_student_name);
            numberText = (TextView) itemView.findViewById(R.id.item_student_number);
            detailText = (TextView) itemView.findViewById(R.id.item_student_details);
        }
    }

    public StudentAdapter(List<StudentInClass> studentList){
        this.studentList = studentList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_teacher_student,parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        StudentInClass student = studentList.get(position);
        String avatarString = student.getAvatar();
        if(avatarString != null && !avatarString.equals("")){
            Uri uri = Uri.parse(avatarString);
            holder.avatar.setImageURI(uri);
        }else{
            holder.avatar.setImageResource(R.drawable.profile);
        }
        holder.nameText.setText(student.getName());
        holder.numberText.setText(student.getUsername());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }
}
