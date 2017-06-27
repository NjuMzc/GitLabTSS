package com.njumzc.gitlabtss.api.vo;

import java.util.List;

import lombok.Data;

/**
 * Created by NjuMzc on 2017/6/27.
 */
@Data
public class Score {
    private String assignmentId;
    private List<ScoreQuestion> questions;

}
