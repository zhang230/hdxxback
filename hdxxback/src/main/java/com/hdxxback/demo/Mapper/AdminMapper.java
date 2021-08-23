package com.hdxxback.demo.Mapper;

import com.hdxxback.demo.Pojo.ResultData;
import com.hdxxback.demo.Pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface AdminMapper {
    @Select("select * from user where role!='admin'")
    public List<User> allUserInfo();

    @Select("select * from user where user_name=#{user_name}")
    public User userNameRepeat(User user);


    @Update("update user " +
            "set user_id=#{user_id},account_balance=#{account_balance},position=#{position},position_open=#{position_open},branch_id=#{branch_id}" +
            ",branch_name=#{branch_name},branch_open=#{branch_open},organization=#{organization},organization_open=#{organization_open},user_name=#{user_name}" +
            ",user_phone=#{user_phone},user_phone_open=#{user_phone_open},email=#{email},email_vertify=#{email_vertify},email_open=#{email_open}" +
            ",address=#{address},address_open=#{address_open},user_icon=#{user_icon},user_password=#{user_password},user_pay_password=#{user_pay_password}" +
            ",user_nickname=#{user_nickname},name=#{name},identity_card=#{identity_card},identity_card_status=#{identity_card_status}" +
            ",role=#{role},delete_flag=#{delete_flag},a_points=#{a_points} " +
            "where user_id=#{user_id}")
    public Integer userInfoUpdate(User user);

    @Insert("insert into user(user_id,account_balance,position,position_open,branch_id,branch_name,branch_open," +
            "organization,organization_open,user_name,user_phone,user_phone_open,email,email_vertify,email_open,address," +
            "address_open,user_icon,user_password,user_pay_password,user_nickname,name,identity_card,identity_card_status," +
            "role,delete_flag,a_points) " +
            "values(#{user_id},#{account_balance},#{position},#{position_open},#{branch_id},#{branch_name},#{branch_open}," +
            "#{organization},#{organization_open},#{user_name},#{user_phone},#{user_phone_open},#{email},#{email_vertify},#{email_open},#{address}," +
            "#{address_open},#{user_icon},#{user_password},#{user_pay_password},#{user_nickname},#{name},#{identity_card},#{identity_card_status}," +
            "#{role},#{delete_flag},#{a_points})")
    public Integer userInfoAdd(User user);


    @Delete("delete from user where user_id=#{user_id}")
    public Integer userInfoDelete(User user);

    @Select("select * from user where (user_name like #{user_name} or " +
            "user_phone like #{user_phone} or " +
            "email like #{email} or " +
            "user_nickname like #{user_nickname}) and role!='admin'")
    public List<User> findUserInfos(User user);
}
