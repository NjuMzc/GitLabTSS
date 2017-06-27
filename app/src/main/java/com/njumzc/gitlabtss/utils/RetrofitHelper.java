package com.njumzc.gitlabtss.utils;

import com.njumzc.gitlabtss.api.service.AuthService;
import com.njumzc.gitlabtss.api.service.StudentService;
import com.njumzc.gitlabtss.api.service.TeacherService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mazhangchi on 2017/6/19.
 */

public class RetrofitHelper {
    private static final String TAG = RetrofitHelper.class.getSimpleName();
    private static Retrofit client;

    private static AuthService authService;
    private static TeacherService teacherService;
    private static StudentService studentService;

    private static void initClient(){
        client = new Retrofit.Builder()
                .baseUrl(NetConfig.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public static AuthService getAuthService(){
        if(null == authService){
            if(client == null){
                initClient();
            }
            authService = client.create(AuthService.class);
        }
        return authService;
    }

    public static TeacherService getTeacherService(){
        if(null == teacherService){
            if(client == null){
                initClient();
            }
            teacherService = client.create(TeacherService.class);
        }
        return teacherService;
    }

    public static StudentService getStudentService(){
        if(null == studentService){
            if(client == null){
                initClient();
            }
            studentService = client.create(StudentService.class);
        }
        return studentService;
    }
}
