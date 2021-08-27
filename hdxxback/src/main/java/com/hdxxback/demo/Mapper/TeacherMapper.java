package com.hdxxback.demo.Mapper;

import com.hdxxback.demo.Pojo.Course;
import com.hdxxback.demo.Pojo.ResultData;
import com.hdxxback.demo.Pojo.TeacherCourseInfo;
import com.hdxxback.demo.Pojo.User_course_chapter_info;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Mapper
public interface TeacherMapper {
//    前端需要的属性有:
//    user.user_id,course.course_id,chapter.chapter_id,


//    course.course_name,course.course_category,
//      course.course_time,course.course_open_time,
//      course.course_belong_to,course.course_origin


//    chapter.course_zhang_name,chapter.course_jie_name,
//    chapter.course_src_path,chapter.course_check_status
    @Select("select u.user_id as user_id,cs.course_id as course_id,c.chapter_id as chapter_id," +
            "cs.course_name as course_name,cs.course_category as course_category,cs.course_create_time as course_create_time,c.course_zhang_name as course_zhang_name," +
            "c.course_jie_name as course_jie_name,c.course_src_path as course_src_path,c.course_check_status as course_check_status," +
            "cs.course_time as course_time,cs.course_open_time as course_open_time,cs.course_belong_to as course_belong_to," +
            "cs.course_origin as course_origin,cs.course_icon as course_icon" +
            " from user as u,user_course_chapter_info as ucci," +
            "course as cs,course_chapter as cc,chapter as c " +
            "where u.user_id=#{user_id} and " +
            "u.user_id=ucci.user_id and " +
            "ucci.course_id=cs.course_id and " +
            "cs.course_id=cc.course_id and " +
            "cc.chapter_id=c.chapter_id and cs.delete_flag=0 and c.delete_flag=0")
    public List<TeacherCourseInfo> allCourseVideoInfo(Integer user_id);

    @Update("update user as u,course as cs,chapter as c " +
            "set cs.course_name=#{course_name},cs.course_category=#{course_category}," +
            "cs.course_time=#{course_time},cs.course_open_time=#{course_open_time}," +
            "cs.course_belong_to=#{course_belong_to},cs.course_origin=#{course_origin}," +
            "c.course_zhang_name=#{course_zhang_name},c.course_jie_name=#{course_jie_name}," +
            "c.course_src_path=#{course_src_path},c.course_check_status=#{course_check_status} " +
            "where u.user_id=#{user_id} and cs.course_id=#{course_id} and c.chapter_id=#{chapter_id}")
    public Integer courseVideoInfoUpdate(TeacherCourseInfo teacherCourseInfo);


    @Select("select * from course where course_name=#{course_name} and delete_flag=0")
    public Course findSameCourseNameCouse(TeacherCourseInfo teacherCourseInfo);

    @Insert("insert into course(course_name,course_category,course_create_time,course_time,course_open_time,course_belong_to,course_origin,course_icon,course_status) values(#{course_name},#{course_category},#{course_create_time},#{course_time},#{course_open_time},#{course_belong_to},#{course_origin},#{course_icon},'免费公开')")
    @Options(useGeneratedKeys = true,keyProperty = "course_id",keyColumn = "course_id")
    public Integer insertCourse(TeacherCourseInfo teacherCourseInfo);


    @Insert("insert into user_course_chapter_info(user_id,course_id) values(#{user_id},#{course_id})")
    public Integer insertUser_course_chapter_info(Integer user_id,Integer course_id);

    @Insert("insert into chapter(course_id,course_check_status,course_src_path,course_zhang_name,course_jie_name) values(#{course_id},#{course_check_status},#{course_src_path},#{course_zhang_name},#{course_zhang_name})")
    @Options(useGeneratedKeys = true,keyProperty = "chapter_id",keyColumn = "chapter_id")
    public Integer insertChapter(TeacherCourseInfo teacherCourseInfo);

    @Insert("insert into course_chapter(course_id,chapter_id) values(#{course_id},#{chapter_id})")
    public Integer insertCourse_chapter(Integer course_id,Integer chapter_id);

    @Select("select u.user_id as user_id,cs.course_id as course_id,c.chapter_id as chapter_id," +
            "cs.course_name as course_name,cs.course_category as course_category,cs.course_create_time as course_create_time,c.course_zhang_name as course_zhang_name," +
            "c.course_jie_name as course_jie_name,c.course_src_path as course_src_path,c.course_check_status as course_check_status," +
            "cs.course_time as course_time,cs.course_open_time as course_open_time,cs.course_belong_to as course_belong_to," +
            "cs.course_origin as course_origin,cs.course_icon as course_icon" +
            " from user as u,user_course_chapter_info as ucci," +
            "course as cs,course_chapter as cc,chapter as c " +
            "where (u.user_id=#{user_id} and " +
            "u.user_id=ucci.user_id and " +
            "ucci.course_id=cs.course_id and " +
            "cs.course_id=cc.course_id and " +
            "cc.chapter_id=c.chapter_id) and (" +
            "cs.course_name like #{course_name} or cs.course_category like #{course_category}) and cs.delete_flag=0 and c.delete_flag=0")
    public List<TeacherCourseInfo> findCourseVideoInfo(TeacherCourseInfo teacherCourseInfo);

    @Select("select * from user_course_chapter_info where user_id=#{user_id} and course_id=#{course_id}")
    public User_course_chapter_info findSameUCCI(Integer user_id, Integer course_id);
    //虚拟删除
    @Delete("delete from course_chapter " +
            "where course_id=#{course_id} and chapter_id=#{chapter_id}")
    public Integer courseVideoInfoDeleteCourse_Chapter(TeacherCourseInfo teacherCourseInfo);

    @Delete("delete from chapter " +
            "where chapter_id=#{chapter_id}")
    public Integer courseVideoInfoDeleteChapter(TeacherCourseInfo teacherCourseInfo);

    @Delete("delete from user_course_chapter_info where chapter_id=#{chapter_id}")
    public Integer user_course_chapter_infoDelete(TeacherCourseInfo teacherCourseInfo);

}
