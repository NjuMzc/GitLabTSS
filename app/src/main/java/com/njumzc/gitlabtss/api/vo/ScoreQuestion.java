package com.njumzc.gitlabtss.api.vo;

import java.util.List;

import lombok.Data;

/**
 * Created by NjuMzc on 2017/6/27.
 */
@Data
public class ScoreQuestion{
    private QuestionInfo questionInfo;
    private List<StudentInfo> students;
}
