package com.njumzc.gitlabtss.api;

import android.util.Log;

import com.njumzc.gitlabtss.api.service.AuthService;

import java.io.IOException;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mazhangchi on 2017/6/19.
 */

public class RetrofitHelper {
    private static final String TAG = RetrofitHelper.class.getSimpleName();
    private static Retrofit client;
    private static Cookie cookie;

    private static AuthService authService;

    private static void initClient(){
        client = new Retrofit.Builder()
                .client(new OkHttpClient.Builder().cookieJar(new CookieJar() {
                    @Override
                    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                        for (Cookie c : cookies){
                            Log.d(TAG, "saveFromResponse: "+c.name()+" "+c.value());
                        }
                    }

                    @Override
                    public List<Cookie> loadForRequest(HttpUrl url) {
                        return null;
                    }
                }).addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        return null;
                    }
                }).build())
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
}
