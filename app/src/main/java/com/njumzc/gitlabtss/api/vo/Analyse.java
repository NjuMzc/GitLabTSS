package com.njumzc.gitlabtss.api.vo;

import java.util.List;

import lombok.Data;

/**
 * Created by NjuMzc on 2017/6/30.
 */
@Data
public class Analyse {
    private int studentId;
    private int assignmentId;
    private List<QuestionResult> questionResults;
}
