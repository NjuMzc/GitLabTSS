package com.njumzc.gitlabtss.api.vo;

import lombok.Data;

/**
 * Created by NjuMzc on 2017/6/30.
 */
@Data
public class QuestionResult {
    private int questionId;
    private String questionTitle;
    private ScoreResult scoreResult;
    private TestResult testResult;
    private MetricData metricData;
}
