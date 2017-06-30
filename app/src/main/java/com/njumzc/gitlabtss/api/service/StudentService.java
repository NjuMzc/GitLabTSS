package com.njumzc.gitlabtss.api.service;

import com.njumzc.gitlabtss.api.vo.Analyse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by NjuMzc on 2017/6/26.
 */

public interface StudentService {
    @GET("assignment/{assignmentId}/student/{studentId}/analysis")
    Call<Analyse> getAnalyse(@Header("Authorization")String token,
                             @Path("assignmentId") String assignmentId,
                             @Path("studentId")String studentId);
}
