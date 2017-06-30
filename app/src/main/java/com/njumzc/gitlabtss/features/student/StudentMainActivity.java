package com.njumzc.gitlabtss.features.student;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.njumzc.gitlabtss.R;
import com.njumzc.gitlabtss.api.vo.UserAccount;
import com.njumzc.gitlabtss.features.WorkListActivity;
import com.njumzc.gitlabtss.features.teacher.TeacherClassActivity;
import com.njumzc.gitlabtss.utils.ApplicationInform;

import de.hdodenhof.circleimageview.CircleImageView;

public class StudentMainActivity extends AppCompatActivity implements View.OnClickListener{

    protected CircleImageView avatarImage;
    protected TextView usernameText;
    protected Button examButton;
    protected Button exerciseButton;
    protected Button homeworkButton;
    protected Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_main);

        avatarImage = (CircleImageView) findViewById(R.id.student_main_avatar);
        usernameText = (TextView) findViewById(R.id.student_main_username);
        examButton = (Button) findViewById(R.id.student_main_exam);
        exerciseButton = (Button) findViewById(R.id.student_main_exercise);
        homeworkButton = (Button) findViewById(R.id.student_main_homework);
        logoutButton = (Button) findViewById(R.id.student_main_logout);

        UserAccount userAccount = ApplicationInform.getCurrentUser();
        String avatar = userAccount.getAvatar();
        if(avatar != null && !avatar.equals("")){
            Uri uri = Uri.parse(avatar);
            avatarImage.setImageURI(uri);
        }else{
            avatarImage.setImageResource(R.drawable.profile);
        }
        usernameText.setText(userAccount.getName());

        homeworkButton.setOnClickListener(this);
        exerciseButton.setOnClickListener(this);
        examButton.setOnClickListener(this);
        logoutButton.setOnClickListener(this);
    }

    //监听页面上的按钮
    @Override
    public void onClick(View v) {
        Intent intent;
        int id = v.getId();
        switch (id){
            case R.id.student_main_homework:
                intent = new Intent(getApplicationContext(), WorkListActivity.class);
                intent.putExtra("workType",1);
                startActivity(intent);
                break;
            case R.id.student_main_exercise:
                intent = new Intent(getApplicationContext(), WorkListActivity.class);
                intent.putExtra("workType",2);
                startActivity(intent);
                break;
            case R.id.student_main_exam:
                intent = new Intent(getApplicationContext(), WorkListActivity.class);
                intent.putExtra("workType",3);
                startActivity(intent);
                break;
            case R.id.student_main_logout:
                finish();
                break;
            default:
                break;
        }
    }
}
