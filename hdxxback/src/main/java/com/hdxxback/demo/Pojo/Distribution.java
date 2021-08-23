package com.hdxxback.demo.Pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Distribution {
    private Integer distribution_id;
    private String distribution_name;
    private Date distribution_time;
    private String distribution_category;
    private Date distribution_open_time;
    private String distribution_status;
    private Boolean distribution_info_user;
    private Date distribution_start_time;
    private Date distribution_end_time;
}
