package com.njumzc.gitlabtss.features;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.njumzc.gitlabtss.R;
import com.njumzc.gitlabtss.api.vo.Question;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by NjuMzc on 2017/6/27.
 */

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {

    private List<Question>  questionList;

    public QuestionAdapter(List<Question> questionList){
        this.questionList = questionList;
    }

    static class QuestionViewHolder extends RecyclerView.ViewHolder{
        TextView nameText;
        TextView descriptionText;
        TextView difficultyTest;
        TextView gitUrlTest;
        TextView creatorText;
        public QuestionViewHolder(View itemView) {
            super(itemView);
            nameText = (TextView) itemView.findViewById(R.id.item_question_title);
            descriptionText = (TextView) itemView.findViewById(R.id.item_question_description_todo);
            difficultyTest = (TextView) itemView.findViewById(R.id.item_question_difficulty);
            gitUrlTest = (TextView) itemView.findViewById(R.id.item_question_gitUrl);
            creatorText = (TextView) itemView.findViewById(R.id.item_question_creator);
        }
    }

    @Override
    public QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question,parent,false);
        QuestionViewHolder holder = new QuestionViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(QuestionViewHolder holder, int position) {
        Question question = questionList.get(position);
        holder.nameText.setText(question.getTitle());
        holder.descriptionText.setText(question.getDescription());
        holder.difficultyTest.setText("难度系数:"+question.getDifficulty());
        holder.gitUrlTest.setText("gitUrl:"+question.getGitUrl());
        holder.creatorText.setText("创建者:"+question.getCreatorName());
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }
}
