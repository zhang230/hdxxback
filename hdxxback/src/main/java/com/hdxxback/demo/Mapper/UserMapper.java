package com.hdxxback.demo.Mapper;

import com.hdxxback.demo.Pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user where user_name=#{user_name}")
    public User userNameRepeat(User user);

    @Insert("insert into user(user_id,account_balance,position,position_open,branch_id,branch_name,branch_open," +
            "organization,organization_open,user_name,user_phone,user_phone_open,email,email_vertify,email_open,address," +
            "address_open,user_icon,user_password,user_pay_password,user_nickname,name,identity_card,identity_card_status," +
            "role,delete_flag,a_points) " +
            "values(#{user_id},#{account_balance},#{position},#{position_open},#{branch_id},#{branch_name},#{branch_open}," +
            "#{organization},#{organization_open},#{user_name},#{user_phone},#{user_phone_open},#{email},#{email_vertify},#{email_open},#{address}," +
            "#{address_open},#{user_icon},#{user_password},#{user_pay_password},#{user_nickname},#{name},#{identity_card},#{identity_card_status}," +
            "#{role},#{delete_flag},#{a_points})")
    public Integer insertUser(User user);
}
