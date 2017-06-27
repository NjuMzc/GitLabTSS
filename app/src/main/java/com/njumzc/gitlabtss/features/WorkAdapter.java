package com.njumzc.gitlabtss.features;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.njumzc.gitlabtss.R;
import com.njumzc.gitlabtss.api.vo.Work;
import com.njumzc.gitlabtss.features.teacher.TeacherWorkDetailActivity;
import com.njumzc.gitlabtss.utils.ApplicationInform;

import java.util.List;

/**
 * Created by NjuMzc on 2017/6/27.
 */

public class WorkAdapter extends RecyclerView.Adapter<WorkAdapter.WorkViewHolder>{

    private List<Work> workList;
    private WorkListActivity activity;

    static class WorkViewHolder extends RecyclerView.ViewHolder{
        TextView titleText;
        TextView startText;
        TextView endText;
        TextView statusText;
        TextView detailText;

        public WorkViewHolder(View itemView) {
            super(itemView);
            titleText = (TextView) itemView.findViewById(R.id.item_work_title);
            startText = (TextView) itemView.findViewById(R.id.item_work_startTime);
            endText = (TextView) itemView.findViewById(R.id.item_work_endTime);
            statusText = (TextView) itemView.findViewById(R.id.item_work_status);
            detailText = (TextView) itemView.findViewById(R.id.item_work_details);

        }
    }

    public WorkAdapter(List<Work> works){
        workList = works;
    }

    @Override
    public WorkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_work,parent,false);
        WorkViewHolder holder = new WorkViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(WorkViewHolder holder, int position) {
        final Work work = workList.get(position);
        holder.titleText.setText(work.getTitle());
        holder.startText.setText("开始时间:"+work.getStartAt());
        holder.endText.setText("结束时间:"+work.getEndAt());
        String status = work.getStatus();
        String parsedStatus;
        switch (status){
            case "newly":
                parsedStatus = "新建中";
                break;
            case "initing":
                parsedStatus = "正在初始化";
                break;
            case "initFail":
                parsedStatus = "初始化失败";
                break;
            case "initSuccess":
                parsedStatus = "初始化成功";
                break;
            case "ongoing":
                parsedStatus = "进行中";
                break;
            case "timeup":
                parsedStatus = "时间到";
                break;
            case "analyzing":
                parsedStatus = "分析中";
                break;
            case "analyzingFinish":
                parsedStatus = "分析完毕";
                break;
            default:
                parsedStatus = "未知";
                break;
        }
        holder.statusText.setText(parsedStatus);
        holder.detailText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                String userType = ApplicationInform.getCurrentUser().getType();
                if(userType.equals("teacher")){
                    intent = new Intent(activity, TeacherWorkDetailActivity.class);
                }else{
                    intent = new Intent(activity, TeacherWorkDetailActivity.class);
                }
                ApplicationInform.setCurrentWork(work);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return workList.size();
    }

    public void setActivity(WorkListActivity activity){
        this.activity = activity;
    }
}
