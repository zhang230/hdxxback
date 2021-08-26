package com.hdxxback.demo.Pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
@JsonIgnoreProperties(value = { "handler" })
public class Course {
    private Integer course_id;
    private String course_name;
    private String course_category;
    private Integer course_info_manage_id;
    private Integer course_category_manage_id;
    private Integer course_time;
    private String course_status;
    private Integer already_study_time;
    private Date last_study_time;
    private Double study_process;
    private Date course_open_time;
    private Double course_grade;
    private String course_commit;
    private String course_evaluate;
    private String course_belong_to;
    private String course_origin;
    private String course_icon;
    private Date course_create_time;
    private List<Chapter> chapters;
}
