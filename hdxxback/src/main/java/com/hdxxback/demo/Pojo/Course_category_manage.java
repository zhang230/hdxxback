package com.hdxxback.demo.Pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Course_category_manage {
    private Integer course_category_id;
    private String course_category_name;
    private String course_father_name;
    private Integer course_number;
    private Boolean course_status;
    private Date course_create_time;
    private Boolean course_shotcut;
}
