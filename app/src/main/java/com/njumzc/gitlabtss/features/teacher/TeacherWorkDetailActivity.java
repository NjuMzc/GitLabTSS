package com.njumzc.gitlabtss.features.teacher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.njumzc.gitlabtss.R;
import com.njumzc.gitlabtss.api.vo.Score;
import com.njumzc.gitlabtss.api.vo.Work;
import com.njumzc.gitlabtss.features.QuestionAdapter;
import com.njumzc.gitlabtss.utils.ApplicationInform;
import com.njumzc.gitlabtss.utils.RetrofitHelper;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.njumzc.gitlabtss.R.id.work_detail_id_todo;
import static com.njumzc.gitlabtss.R.id.work_detail_start_todo;

public class TeacherWorkDetailActivity extends AppCompatActivity {
    private static final String TAG = TeacherStudentsActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_work_detail);

        TextView nameText = (TextView) findViewById(R.id.work_detail_name_todo);
        TextView idText = (TextView) findViewById(work_detail_id_todo);
        TextView startText = (TextView) findViewById(work_detail_start_todo);
        TextView endText = (TextView) findViewById(R.id.work_detail_end_todo);
        TextView descriptionText = (TextView) findViewById(R.id.work_detail_description_todo);
        RecyclerView questionRecyclerView = (RecyclerView) findViewById(R.id.work_detail_questionList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        questionRecyclerView.setLayoutManager(linearLayoutManager);
        final RecyclerView scoreRecycleView = (RecyclerView) findViewById(R.id.work_detail_scoreList);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        scoreRecycleView.setLayoutManager(linearLayoutManager2);
        Work work = ApplicationInform.getCurrentWork();
        nameText.setText(work.getTitle());
        idText.setText(String.valueOf(work.getId()));
        startText.setText(work.getStartAt());
        endText.setText(work.getEndAt());
        descriptionText.setText(work.getDescription());
        QuestionAdapter questionAdapter = new QuestionAdapter(work.getQuestions());
        questionRecyclerView.setAdapter(questionAdapter);
        RetrofitHelper.getTeacherService().getScore(ApplicationInform.getToken().trim(),String.valueOf(work.getId()))
                .enqueue(new Callback<Score>() {
                    @Override
                    public void onResponse(Call<Score> call, Response<Score> response) {
                        if(response.code()==200){
                            Score score = response.body();
                            if(score!=null){
                                ScoreAdapter scoreAdapter = new ScoreAdapter(score);
                                scoreRecycleView.setAdapter(scoreAdapter);
                            }
                        }else{

                        }
                    }

                    @Override
                    public void onFailure(Call<Score> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"网络错误:"+t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
    }
}
