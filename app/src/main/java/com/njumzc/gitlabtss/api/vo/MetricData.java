package com.njumzc.gitlabtss.api.vo;

import lombok.Data;

/**
 * Created by NjuMzc on 2017/6/30.
 */
@Data
public class MetricData {
    private String git_url;
    private boolean measured;
    private int total_line_count;
    private int comment_line_count;
    private int field_count;
    private int method_count;
    private int max_coc;
}
