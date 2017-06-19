package com.njumzc.gitlabtss.api.service;

import com.njumzc.gitlabtss.api.form.LoginInform;
import com.njumzc.gitlabtss.api.vo.UserAccount;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by mazhangchi on 2017/6/19.
 */

public interface AuthService {

    @POST("/user/auth")
    Observable<UserAccount> login(@Body LoginInform loginInform);
}
