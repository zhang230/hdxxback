package com.hdxxback.demo.Pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(value = { "handler" })
public class Course_chapter {
    private Integer id;
    private Integer course_id;
    private Integer chapter_id;
    private Boolean already_study;
}
