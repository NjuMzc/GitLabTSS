package com.njumzc.gitlabtss.features.teacher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.njumzc.gitlabtss.R;
import com.njumzc.gitlabtss.api.vo.StudentInClass;
import com.njumzc.gitlabtss.utils.ApplicationInform;
import com.njumzc.gitlabtss.utils.RetrofitHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeacherStudentsActivity extends AppCompatActivity {
    private static final String TAG = TeacherStudentsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_students);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.teacher_student_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        TextView classNameText = (TextView) findViewById(R.id.teacher_student_className);
        String className = getIntent().getStringExtra("className");
        String classId = getIntent().getStringExtra("classId");
        classNameText.setText(className);

        RetrofitHelper.getTeacherService().getStudents(ApplicationInform.getToken().trim(),classId)
                .enqueue(new Callback<List<StudentInClass>>(){

                    @Override
                    public void onResponse(Call<List<StudentInClass>> call, Response<List<StudentInClass>> response) {
                        if(response.code() == 200){
                            List<StudentInClass> list = response.body();
                            StudentAdapter adapter = new StudentAdapter(list);
                            recyclerView.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<StudentInClass>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"网络错误:"+t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
    }
}
