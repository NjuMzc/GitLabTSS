package com.njumzc.gitlabtss.api.vo;

import lombok.Data;

/**
 * Created by mazhangchi on 2017/6/19.
 */
@Data
public class UserAccount {
    private String username;
    private String name;
    private String type;//student,teacher,admin
    private String avatar;
    private String gender;//male,female
    private String email;

    //student attribute
    private int gitId;
    private String number;

    //teacher attribute
    private String authority;
}
