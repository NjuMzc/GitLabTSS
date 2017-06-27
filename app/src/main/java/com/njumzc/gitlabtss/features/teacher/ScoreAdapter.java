package com.njumzc.gitlabtss.features.teacher;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.njumzc.gitlabtss.R;
import com.njumzc.gitlabtss.api.vo.QuestionInfo;
import com.njumzc.gitlabtss.api.vo.Score;
import com.njumzc.gitlabtss.api.vo.ScoreQuestion;
import com.njumzc.gitlabtss.api.vo.StudentInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by NjuMzc on 2017/6/27.
 */

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ScoreViewHolder> {

    private Score score;

    public ScoreAdapter(Score score){
        this.score = score;
    }

    static class ScoreViewHolder extends RecyclerView.ViewHolder{
        TextView questionName;
        TextView scoreText1;
        TextView scoreText2;
        TextView scoreText3;
        TextView scoreText4;
        TextView scoreText5;

        public ScoreViewHolder(View itemView) {
            super(itemView);
            questionName = (TextView) itemView.findViewById(R.id.work_score_title);
            scoreText1 = (TextView) itemView.findViewById(R.id.work_score_score1);
            scoreText2 = (TextView) itemView.findViewById(R.id.work_score_score2);
            scoreText3 = (TextView) itemView.findViewById(R.id.work_score_score3);
            scoreText4 = (TextView) itemView.findViewById(R.id.work_score_score4);
            scoreText5 = (TextView) itemView.findViewById(R.id.work_score_score5);
        }
    }

    @Override
    public ScoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_score,parent,false);
        ScoreViewHolder holder = new ScoreViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ScoreViewHolder holder, int position) {
        List<ScoreQuestion> scoreQuestionList = score.getQuestions();
        ScoreQuestion sq = scoreQuestionList.get(position);
        holder.questionName.setText(sq.getQuestionInfo().getTitle());
        List<StudentInfo> studentInfoList = sq.getStudents();
        Map<Integer,Integer> scoreMap = new HashMap<>();
        scoreMap.put(1,0);
        scoreMap.put(2,0);
        scoreMap.put(3,0);
        scoreMap.put(4,0);
        scoreMap.put(5,0);
        for(StudentInfo si:studentInfoList){
            double s = si.getScore();
            if(s>=90){
                int counter = scoreMap.get(5);
                counter++;
                scoreMap.put(5,counter);
            }else if(s>=80){
                int counter = scoreMap.get(4);
                counter++;
                scoreMap.put(4,counter);
            }else if(s>=70){
                int counter = scoreMap.get(3);
                counter++;
                scoreMap.put(3,counter);
            }else if(s>=60){
                int counter = scoreMap.get(2);
                counter++;
                scoreMap.put(2,counter);
            }else{
                int counter = scoreMap.get(1);
                counter++;
                scoreMap.put(1,counter);
            }
        }
        holder.scoreText1.setText("0 分-59分 :"+String.valueOf(scoreMap.get(1))+"人");
        holder.scoreText2.setText("60分-69分 :"+String.valueOf(scoreMap.get(2))+"人");
        holder.scoreText3.setText("70分-79分 :"+String.valueOf(scoreMap.get(3))+"人");
        holder.scoreText4.setText("80分-89分 :"+String.valueOf(scoreMap.get(4))+"人");
        holder.scoreText5.setText("90分-100分:"+String.valueOf(scoreMap.get(5))+"人");
    }

    @Override
    public int getItemCount() {
        return score.getQuestions().size();
    }
}
