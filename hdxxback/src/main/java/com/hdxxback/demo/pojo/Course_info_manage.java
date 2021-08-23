package com.hdxxback.demo.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Course_info_manage {
    private Integer id;
    private String course_name;
    private String course_category;
    private String course_origin;
    private Integer course_time;
    private Boolean course_try_see;
    private Integer course_rank;
    private String course_teacher_name;
    private Integer course_history_study_number;
    private Boolean course_tui_yun_course;
    private Date course_create_time;
    private Double course_second_expense_price;
    private Integer course_buy_up;
    private Integer course_buy_down;
    private Double course_price;
    private Double course_time_expense_price;
    private Integer course_time_expense_up;
    private Integer course_time_expense_down;
    private Double course_orginazation_buy_price;
    private Integer course_orginazation_buy_number_up;
    private Integer course_orginazation_buy_number_down;
    private Double course_distribution_price;
    private Integer course_distribution_number;
    private Double course_discount;
    private String course_icon;
    private String course_src_path;
    private String course_introduce;
}
