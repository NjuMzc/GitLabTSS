package com.njumzc.gitlabtss.features;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.njumzc.gitlabtss.R;
import com.njumzc.gitlabtss.api.vo.Work;
import com.njumzc.gitlabtss.utils.ApplicationInform;
import com.njumzc.gitlabtss.utils.RetrofitHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WorkListActivity extends AppCompatActivity {
    private static final String TAG = WorkListActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_list);

        final WorkListActivity activity = this;
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.work_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        String token = ApplicationInform.getToken().trim();
        String courseId = "2";
        int type = getIntent().getIntExtra("workType",1);
        Call<List<Work>> callBack;
        switch (type){
            case 1:
                callBack = RetrofitHelper.getTeacherService().getHomework(token,courseId);
                break;
            case 2:
                callBack = RetrofitHelper.getTeacherService().getExercise(token,courseId);
                break;
            case 3:
                callBack = RetrofitHelper.getTeacherService().getExams(token,courseId);
                break;
            default:
                callBack = null;
                break;
        }
        if(callBack!=null){
            callBack.enqueue(new Callback<List<Work>>() {
                @Override
                public void onResponse(Call<List<Work>> call, Response<List<Work>> response) {
                    if(response.code()==200){
                        List<Work> workList = response.body();
                        WorkAdapter workAdapter = new WorkAdapter(workList);
                        workAdapter.setActivity(activity);
                        recyclerView.setAdapter(workAdapter);
                    }else{
                        Toast.makeText(getApplicationContext(),"身份未认证",Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<List<Work>> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),"网络错误:"+t.getMessage(),Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
