package com.njumzc.gitlabtss.features.student;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.njumzc.gitlabtss.R;
import com.njumzc.gitlabtss.api.vo.QuestionResult;

import java.util.List;

/**
 * Created by NjuMzc on 2017/6/30.
 */

public class QuestionResultAdapter extends RecyclerView.Adapter<QuestionResultAdapter.ViewHolder> {
    private List<QuestionResult>  questionResultList;

    public QuestionResultAdapter(List<QuestionResult> questionResults){
        this.questionResultList = questionResults;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView titleText;
        TextView scoreText;
        RecyclerView testCasesView;
        TextView totalLineText;
        TextView commentLineText;
        TextView methodCount;

        public ViewHolder(View itemView) {
            super(itemView);
            titleText = (TextView) itemView.findViewById(R.id.item_question_analyse_title);
            scoreText = (TextView) itemView.findViewById(R.id.item_question_analyse_score);
            totalLineText = (TextView) itemView.findViewById(R.id.item_question_analyse_totalLine);
            commentLineText = (TextView) itemView.findViewById(R.id.item_question_analyse_commentLine);
            methodCount = (TextView) itemView.findViewById(R.id.item_question_analyse_methodCount);
            testCasesView = (RecyclerView) itemView.findViewById(R.id.item_question_analyse_testcases);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question_analyse,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        QuestionResult questionResult = questionResultList.get(position);
        holder.titleText.setText(questionResult.getQuestionTitle());
        holder.scoreText.setText("得分:"+String.valueOf(questionResult.getScoreResult().getScore()));
        holder.totalLineText.setText("总行数:"+String.valueOf(questionResult.getMetricData().getTotal_line_count()));
        holder.commentLineText.setText("注释行数:"+String.valueOf(questionResult.getMetricData().getComment_line_count()));
        holder.methodCount.setText("方法数:"+String.valueOf(questionResult.getMetricData().getMethod_count()));
    }

    @Override
    public int getItemCount() {
        return questionResultList.size();
    }
}
