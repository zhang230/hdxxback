package com.hdxxback.demo.Pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Chapter {
    private Integer chapter_id;
    private String course_zhang_name;
    private String course_jie_name;
    private String course_category;
    private String course_catelog_category;
    private Boolean course_try_see;
    private Boolean course_must_study;
    private String course_src_path;
    private String course_choose_src;
    private String course_catelog_introduce;
    private String course_choose_paper;
    private Integer course_check_status;
    private Boolean delete_flag;
}
