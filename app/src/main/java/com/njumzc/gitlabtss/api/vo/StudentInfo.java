package com.njumzc.gitlabtss.api.vo;

import lombok.Data;

/**
 * Created by NjuMzc on 2017/6/27.
 */

@Data
public class StudentInfo{
    private int studentId;
    private String studentName;
    private String studentNumber;
    private double score;
    private boolean scored;
}
