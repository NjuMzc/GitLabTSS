package com.njumzc.gitlabtss.api.vo;

import lombok.Data;

/**
 * Created by NjuMzc on 2017/6/27.
 */
@Data
public class Question {
    private int id;
    private String title;
    private String description;
    private String difficulty;
    private String gitUrl;
    private String type;
    private Creator creator;
    private int duration;
    private int link;
    private String knowledgeVos;

    @Data
    class Creator{
        private  int id;
        private String username;
        private String name;
        private String type;
        private String avatar;
        private String gender;
        private String email;
        private int schoolId;

        public String getName(){
            return name;
        }
    }

    public String getCreatorName(){
        return creator.getName();
    }
}
