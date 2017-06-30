package com.njumzc.gitlabtss.api.vo;

import lombok.Data;

/**
 * Created by NjuMzc on 2017/6/30.
 */
@Data
public class ScoreResult {
    private String git_url;
    private double score;
    private boolean scored;
}
