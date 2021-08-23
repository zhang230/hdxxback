package com.hdxxback.demo.Pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User_course {
    private Integer id;
    private Integer user_id;
    private Integer course_id;
    private String course_distribution_name;
    private String course_name;
    private String course_origin;
    private Integer course_study_status;
    private Integer course_study_way;
    private Integer course_allow_study_time;
    private Integer course_allow_study_number;
}
