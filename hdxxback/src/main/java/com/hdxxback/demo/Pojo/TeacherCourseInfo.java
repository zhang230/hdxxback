package com.hdxxback.demo.Pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class TeacherCourseInfo {
    //    user.user_id,course.course_id,chapter.chapter_id,
//    course.course_name,course.course_category,
//    chapter.course_zhang_name,chapter.course_jie_name,
//    chapter.course_src_path,chapter.course_check_status
    //      course.course_time,course.course_open_time,
//      course.course_belong_to, course.course_origin
    private Integer user_id;
    private Integer course_id;
    private Integer chapter_id;
    private String course_name;
    private String course_category;
    private String course_zhang_name;
    private String course_jie_name;
    private String course_src_path;
    private Integer course_check_status;
    private Integer course_time;
    private Date course_open_time;
    private String course_belong_to;
    private String course_origin;
}
