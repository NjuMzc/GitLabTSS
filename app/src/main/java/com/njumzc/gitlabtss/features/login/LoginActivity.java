package com.njumzc.gitlabtss.features.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.njumzc.gitlabtss.R;
import com.njumzc.gitlabtss.api.form.LoginInform;
import com.njumzc.gitlabtss.api.vo.UserAccount;
import com.njumzc.gitlabtss.features.student.StudentMainActivity;
import com.njumzc.gitlabtss.features.teacher.TeacherMainActivity;
import com.njumzc.gitlabtss.utils.ApplicationInform;
import com.njumzc.gitlabtss.utils.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = LoginActivity.class.getSimpleName();

    protected EditText usernameInput;
    protected EditText passwordInput;
    protected Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameInput = (EditText) findViewById(R.id.username);
        passwordInput = (EditText) findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();
                doLogin(username, password);
            }
        });
    }

    private void doLogin(final String username, final String password) {

        LoginInform loginInform = new LoginInform();
        loginInform.setUsername(username);
        loginInform.setPassword(password);
        RetrofitHelper.getAuthService().login(loginInform)
                .enqueue(new Callback<UserAccount>() {
                    @Override
                    public void onResponse(Call<UserAccount> call, Response<UserAccount> response) {
                        if(response.code() == 200){
                            //登陆成功
                            //设置token
                            String tokenOrigin = username+":"+password;
                            String token = Base64.encodeToString(tokenOrigin.getBytes(),Base64.DEFAULT);
                            ApplicationInform.setToken("Basic"+" "+token);
                            //设置当前用户信息
                            UserAccount userAccount = response.body();
                            ApplicationInform.setCurrentUser(userAccount);
                            //跳转界面
                            if(userAccount.getType().equals("student")){
                                //学生用户
                                Intent intent = new Intent(getApplicationContext(), StudentMainActivity.class);
                                startActivity(intent);
                            }else{
                                //老师用户
                                Intent intent = new Intent(getApplicationContext(), TeacherMainActivity.class);
                                startActivity(intent);
                            }
                        }else{
                            //登陆失败
                            Toast.makeText(getApplicationContext(),"用户名或密码错误",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<UserAccount> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"网络错误:"+t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
    }
}
