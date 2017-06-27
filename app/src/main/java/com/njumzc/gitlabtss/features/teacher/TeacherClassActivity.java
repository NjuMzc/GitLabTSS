package com.njumzc.gitlabtss.features.teacher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.njumzc.gitlabtss.R;
import com.njumzc.gitlabtss.api.vo.Class;
import com.njumzc.gitlabtss.utils.ApplicationInform;
import com.njumzc.gitlabtss.utils.RetrofitHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeacherClassActivity extends AppCompatActivity {
    private static final String TAG = TeacherClassActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_class);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.class_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        final TeacherClassActivity activity = this;

        RetrofitHelper.getTeacherService().getAllClass(ApplicationInform.getToken().trim())
                .enqueue(new Callback<List<Class>>() {
                    @Override
                    public void onResponse(Call<List<Class>> call, Response<List<Class>> response) {
                        if(response.code()==200 ){
                            ClassAdapter adapter = new ClassAdapter(response.body(),activity);
                            recyclerView.setAdapter(adapter);
                        }else{
                            Toast.makeText(getApplicationContext(),"身份未认证",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Class>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"网络错误:"+t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
    }
}
