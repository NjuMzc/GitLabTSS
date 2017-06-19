package com.njumzc.gitlabtss;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.njumzc.gitlabtss.api.RetrofitHelper;
import com.njumzc.gitlabtss.api.form.LoginInform;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //test login
        LoginInform loginInform = new LoginInform();

    }
}
