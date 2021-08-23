package com.hdxxback.demo.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User_course_chapter_info {
    private Integer id;
    private Integer chapter_id;
    private Integer course_id;
    private Integer course_catelog_id;
    private Integer user_id;
    private String study_note;
    private Boolean note_status;
    private String correct_infomation;
    private Boolean already_study_flag;
    private String user_commit;
    private Boolean course_open_flag;
    private String course_note;
}
