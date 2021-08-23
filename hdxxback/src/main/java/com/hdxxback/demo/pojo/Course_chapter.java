package com.hdxxback.demo.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Course_chapter {
    private Integer id;
    private Integer course_id;
    private Integer chapter_id;
    private Boolean already_study;
}
