package com.hdxxback.demo.Mapper;

import com.hdxxback.demo.Pojo.ResultData;
import com.hdxxback.demo.Pojo.TeacherCourseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;

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
            "cs.course_name as course_name,cs.course_category as course_category,c.course_zhang_name as course_zhang_name," +
            "c.course_jie_name as course_jie_name,c.course_src_path as course_src_path,c.course_check_status as course_check_status," +
            "cs.course_time as course_time,cs.course_open_time as course_open_time,cs.course_belong_to as course_belong_to," +
            "cs.course_origin as course_origin" +
            " from user as u,user_course_chapter_info as ucci," +
            "course as cs,course_chapter as cc,chapter as c " +
            "where u.user_id=#{user_id} and " +
            "u.user_id=ucci.user_id and " +
            "ucci.course_id=cs.course_id and " +
            "cs.course_id=cc.course_id and " +
            "cc.chapter_id=c.chapter_id")
    public List<TeacherCourseInfo> allCourseVideoInfo(Integer user_id);
}
