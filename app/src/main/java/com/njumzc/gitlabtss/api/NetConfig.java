package com.njumzc.gitlabtss.api;

/**
 * Created by mazhangchi on 2017/6/19.
 */

public class NetConfig {
    public static final String IP = "115.29.184.56";
    public static final String PORT = "8090";
    public static final String URL = "http://" + IP + ":" + PORT+"/api";
    public static final String URL_USER = URL + "/user";

    public static final int RESPONSE_OK = 0;

    public static final String ERROR = "发生错误";
}
