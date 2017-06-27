package com.njumzc.gitlabtss.utils;

import com.njumzc.gitlabtss.api.vo.UserAccount;
import com.njumzc.gitlabtss.api.vo.Work;

/**
 * Created by NjuMzc on 2017/6/26.
 */

public class ApplicationInform {
    private static UserAccount currentUser = null;
    private static String token="";
    private static Work currentWork = null;

    public static void setCurrentUser(UserAccount user){
        currentUser = user;
    }

    public static UserAccount getCurrentUser(){
        return currentUser;
    }

    public static void setToken(String myToken){
        token = myToken;
    }

    public static String getToken(){
        return token.trim();
    }

    public static Work getCurrentWork() {
        return currentWork;
    }

    public static void setCurrentWork(Work currentWork) {
        ApplicationInform.currentWork = currentWork;
    }
}
