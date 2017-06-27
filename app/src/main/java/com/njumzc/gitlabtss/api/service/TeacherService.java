package com.njumzc.gitlabtss.api.service;

import com.njumzc.gitlabtss.api.vo.Class;
import com.njumzc.gitlabtss.api.vo.Score;
import com.njumzc.gitlabtss.api.vo.StudentInClass;
import com.njumzc.gitlabtss.api.vo.Work;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by NjuMzc on 2017/6/26.
 */

public interface TeacherService {
    @GET("group")
    Call<List<Class>> getAllClass(@Header("Authorization")String token);

    @GET("group/{groupId}/students")
    Call<List<StudentInClass>> getStudents(@Header("Authorization")String token,@Path("groupId")String groupId);

    @GET("course/{courseId}/exam")
    Call<List<Work>> getExams(@Header("Authorization")String token,@Path("courseId")String courseId);

    @GET("course/{courseId}/homework")
    Call<List<Work>> getHomework(@Header("Authorization")String token,@Path("courseId")String courseId);

    @GET("course/{courseId}/exercise")
    Call<List<Work>> getExercise(@Header("Authorization")String token,@Path("courseId")String courseId);

    @GET("assignment/{assignmentId}/score")
    Call<Score> getScore(@Header("Authorization")String token,@Path("assignmentId")String assignmentId);

}
