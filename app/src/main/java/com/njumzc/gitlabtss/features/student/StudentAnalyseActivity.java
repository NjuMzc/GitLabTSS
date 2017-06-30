package com.njumzc.gitlabtss.features.student;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.njumzc.gitlabtss.R;
import com.njumzc.gitlabtss.api.vo.Analyse;
import com.njumzc.gitlabtss.api.vo.Work;
import com.njumzc.gitlabtss.features.QuestionAdapter;
import com.njumzc.gitlabtss.utils.ApplicationInform;
import com.njumzc.gitlabtss.utils.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.njumzc.gitlabtss.R.id.work_analyse_id_todo;
import static com.njumzc.gitlabtss.R.id.work_analyse_start_todo;

public class StudentAnalyseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_analyse);

        TextView nameText = (TextView) findViewById(R.id.work_analyse_name_todo);
        TextView idText = (TextView) findViewById(work_analyse_id_todo);
        TextView startText = (TextView) findViewById(work_analyse_start_todo);
        TextView endText = (TextView) findViewById(R.id.work_analyse_end_todo);
        TextView descriptionText = (TextView) findViewById(R.id.work_analyse_description_todo);
        RecyclerView questionRecyclerView = (RecyclerView) findViewById(R.id.work_analyse_questionList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        questionRecyclerView.setLayoutManager(linearLayoutManager);

        final RecyclerView questionResultRecyclerView = (RecyclerView) findViewById(R.id.work_analyse_scoreList);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        questionResultRecyclerView.setLayoutManager(linearLayoutManager2);

        Work work = ApplicationInform.getCurrentWork();
        nameText.setText(work.getTitle());
        idText.setText(String.valueOf(work.getId()));
        startText.setText(work.getStartAt());
        endText.setText(work.getEndAt());
        descriptionText.setText(work.getDescription());
        QuestionAdapter questionAdapter = new QuestionAdapter(work.getQuestions());
        questionRecyclerView.setAdapter(questionAdapter);

        RetrofitHelper.getStudentService().getAnalyse(ApplicationInform.getToken().trim(),
                String.valueOf(work.getId()),
                String.valueOf(ApplicationInform.getCurrentUser().getGitId()))
        .enqueue(new Callback<Analyse>() {
            @Override
            public void onResponse(Call<Analyse> call, Response<Analyse> response) {
                if(response.code()==200){
                    Analyse score = response.body();
                    if(score!=null){
                        QuestionResultAdapter scoreAdapter = new QuestionResultAdapter(score.getQuestionResults());
                        questionResultRecyclerView.setAdapter(scoreAdapter);
                    }
                }else{

                }
            }

            @Override
            public void onFailure(Call<Analyse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"网络错误:"+t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }
}
