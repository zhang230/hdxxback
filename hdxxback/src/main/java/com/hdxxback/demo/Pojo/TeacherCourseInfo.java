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

    public TeacherCourseInfo(Integer user_id, Integer course_id, Integer chapter_id, String course_name, String course_category, String course_zhang_name, String course_jie_name, String course_src_path, Integer course_check_status, Integer course_time, Date course_open_time, String course_belong_to, String course_origin) {
        this.user_id = user_id;
        this.course_id = course_id;
        this.chapter_id = chapter_id;
        this.course_name = course_name;
        this.course_category = course_category;
        this.course_zhang_name = course_zhang_name;
        this.course_jie_name = course_jie_name;
        this.course_src_path = course_src_path;
        this.course_check_status = course_check_status;
        this.course_time = course_time;
        this.course_open_time = course_open_time;
        this.course_belong_to = course_belong_to;
        this.course_origin = course_origin;
    }
}
