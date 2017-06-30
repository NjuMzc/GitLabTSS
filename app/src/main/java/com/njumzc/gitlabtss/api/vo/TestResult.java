package com.njumzc.gitlabtss.api.vo;

import java.util.List;

import lombok.Data;

/**
 * Created by NjuMzc on 2017/6/30.
 */
@Data
public class TestResult {
    private String git_url;
    private boolean compile_succeeded;
    private boolean tested;
    private List<TestCase> testcases;
}
