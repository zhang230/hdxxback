package com.hdxxback.demo.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
    private Integer user_id;
    private Double account_balance;
    private String position;
    private Boolean position_open;
    private Integer branch_id;
    private String branch_name;
    private Boolean branch_open;
    private String organization;
    private Boolean organization_open;
    private String user_name;
    private String user_phone;
    private String user_phone_open;
    private String email;
    private Boolean email_vertify;
    private Boolean email_open;
    private String address;
    private Boolean address_open;
    private String user_icon;
    private String user_password;
    private String user_pay_password;
    private String user_nickname;
    private String name;
    private String identity_card;
    private Integer identity_card_status;
    private String role;
    private Boolean delete_flag;
    private  Integer a_points;
}
