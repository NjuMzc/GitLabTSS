package com.njumzc.gitlabtss.api.vo;

import java.util.List;

import lombok.Data;

/**
 * Created by NjuMzc on 2017/6/27.
 */
@Data
public class Work {
    private int id;
    private String title;
    private String description;
    private String startAt;
    private String endAt;
    private List<Question> questions;
    private int course;
    private String status;
    private String currentTime;

}
