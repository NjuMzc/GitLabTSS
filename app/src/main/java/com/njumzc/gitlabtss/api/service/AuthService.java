package com.njumzc.gitlabtss.api.service;

import com.njumzc.gitlabtss.api.form.LoginInform;
import com.njumzc.gitlabtss.api.vo.UserAccount;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by mazhangchi on 2017/6/19.
 */

public interface AuthService {

    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("user/auth")
    Call<UserAccount> login(@Body LoginInform loginInform );

}
