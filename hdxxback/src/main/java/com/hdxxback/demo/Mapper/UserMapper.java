package com.hdxxback.demo.Mapper;

import com.hdxxback.demo.Pojo.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.web.multipart.MultipartFile;

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

    @Select("select * from chapter where course_id=#{course_id}")
    public Chapter getChaptersByCourse_id(Integer course_id);



    @Select("select * from course where course_status='免费公开'")
    @Results( id="userMap1",value={
            @Result(id=true,column = "course_id",property = "course_id"),
            @Result(column = "course_name",property = "course_name"),
            @Result(column = "course_category",property = "course_category"),
            @Result(column = "course_info_manage_id",property = "course_info_manage_id"),
            @Result(column = "course_category_manage_id",property = "course_category_manage_id"),
            @Result(column = "course_time",property = "course_time"),
            @Result(column = "course_status",property = "course_status"),
            @Result(column = "already_study_time",property = "already_study_time"),
            @Result(column = "last_study_time",property = "last_study_time"),
            @Result(column = "study_process",property = "study_process"),
            @Result(column = "course_open_time",property = "course_open_time"),
            @Result(column = "course_grade",property = "course_grade"),
            @Result(column = "course_commit",property = "course_commit"),
            @Result(column = "course_evaluate",property = "course_evaluate"),
            @Result(column = "course_belong_to",property = "course_belong_to"),
            @Result(column = "course_origin",property = "course_origin"),
            @Result(column = "course_icon",property = "course_icon"),
            @Result(column = "course_create_time",property = "course_create_time"),
            @Result(column = "course_id",property = "chapters",many=@Many(select="com.hdxxback.demo.Mapper.UserMapper.getChaptersByCourse_id",fetchType = FetchType.LAZY))
    })
    public List<Course> allCourseInfo();



    @Select("select * from course where course_status='免费公开' and course_name like #{course_name}")
    @Results( id="userMap2",value={
            @Result(id=true,column = "course_id",property = "course_id"),
            @Result(column = "course_name",property = "course_name"),
            @Result(column = "course_category",property = "course_category"),
            @Result(column = "course_info_manage_id",property = "course_info_manage_id"),
            @Result(column = "course_category_manage_id",property = "course_category_manage_id"),
            @Result(column = "course_time",property = "course_time"),
            @Result(column = "course_status",property = "course_status"),
            @Result(column = "already_study_time",property = "already_study_time"),
            @Result(column = "last_study_time",property = "last_study_time"),
            @Result(column = "study_process",property = "study_process"),
            @Result(column = "course_open_time",property = "course_open_time"),
            @Result(column = "course_grade",property = "course_grade"),
            @Result(column = "course_commit",property = "course_commit"),
            @Result(column = "course_evaluate",property = "course_evaluate"),
            @Result(column = "course_belong_to",property = "course_belong_to"),
            @Result(column = "course_origin",property = "course_origin"),
            @Result(column = "course_icon",property = "course_icon"),
            @Result(column = "course_create_time",property = "course_create_time"),
            @Result(column = "course_id",property = "chapters",many=@Many(select="com.hdxxback.demo.Mapper.UserMapper.getChaptersByCourse_id",fetchType = FetchType.LAZY))
    })
    public List<Course> searchCourseInfo(String course_name);
//
//tuser.setUser_id(user_id);
//           tuser.setName(name);
//           tuser.setUser_name(user_phone);
//           tuser.setUser_phone(user_phone);
//           tuser.setEmail(email);
//           tuser.setIdentity_card(identity_card);
//           tuser.setOrganization(organization);
//           tuser.setBranch_name(branch_name);
//           tuser.setUser_nickname(user_nickname);
//           tuser.setPosition(position);
//           tuser.setA_points(a_points);
//           tuser.setAccount_balance(account_balance);


    @Update("update user " +
            "set name=#{name},user_name=#{user_phone},user_phone=#{user_phone}," +
            "email=#{email}," +
            "identity_card=#{identity_card},organization=#{organization}," +
            "branch_name=#{branch_name},user_nickname=#{user_nickname}," +
            "position=#{position},a_points=#{a_points},account_balance=#{account_balance},user_icon=#{user_icon} "+
            "where user_id=#{user_id}")
    public Integer updateUserInfo(User tuser);


    @Insert("insert into user_course_chapter_info(chapter_id,user_id,user_commit,user_commit_time) values(#{chapter_id},#{user_id},#{user_commit},#{user_commit_time})")
    public Integer insertUser_Chapter_Commit(User_course_chapter_info user_course_chapter_info);

    @Select("select * from user where user_id=#{user_id}")
    public List<User> getUsersByChapter_id(Integer user_id);

    @Select("select * from user_course_chapter_info where chapter_id=#{chapter_id}")
    @Results( id="userMap3",value={
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "chapter_id",property = "chapter_id"),
            @Result(column = "user_id",property = "user_id"),
            @Result(column = "user_id",property = "users",many=@Many(select="com.hdxxback.demo.Mapper.UserMapper.getUsersByChapter_id",fetchType = FetchType.LAZY))
    })
    public List<User_course_chapter_info> findUserCommit(User_course_chapter_info user_course_chapter_info);
}
