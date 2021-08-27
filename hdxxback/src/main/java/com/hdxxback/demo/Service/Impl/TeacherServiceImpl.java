package com.hdxxback.demo.Service.Impl;

import com.hdxxback.demo.Mapper.TeacherMapper;
import com.hdxxback.demo.Pojo.Course;
import com.hdxxback.demo.Pojo.ResultData;
import com.hdxxback.demo.Pojo.TeacherCourseInfo;
import com.hdxxback.demo.Pojo.User_course_chapter_info;
import com.hdxxback.demo.Service.TeacherService;
import com.hdxxback.demo.Utils.ProduceSrcPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {



    @Autowired
    private ProduceSrcPath psp;


    @Autowired
    private TeacherMapper teacherMapper;
    public ResultData<List<TeacherCourseInfo>> allCourseVideoInfo(Integer user_id){
        List<TeacherCourseInfo> tlist=teacherMapper.allCourseVideoInfo(user_id);
        return new ResultData<List<TeacherCourseInfo>>(200,"操作成功",tlist);
    }

    public ResultData<TeacherCourseInfo> uploadFile(TeacherCourseInfo teacherCourseInfo, MultipartFile[] files){

        //找course表中是否有相同的course_name，如果有返回course对象的id,如果没有那么c对象应该是null
        Course c = teacherMapper.findSameCourseNameCouse(teacherCourseInfo);
        Integer course_id;
        if(c!=null){
            course_id=c.getCourse_id();
        }else{
            //形成课程头像路径
            //这里要实现本地路径的存储!!!
           String icon_src= psp.savePathAndProducePath(files[1]);
//           System.out.println("icon_src:"+icon_src);
           teacherCourseInfo.setCourse_icon(icon_src);
            //如果没有相同的course_name,那么就把新的course_name插入到course表中，得到返回的主键
            Integer influRow=teacherMapper.insertCourse(teacherCourseInfo);
//            System.out.println("得到的course_id为: "+teacherCourseInfo.getCourse_id());
            course_id=teacherCourseInfo.getCourse_id();
        }

        //得到course_id之后，把user_id和course_id插入user_course_chapter_info表
        Integer user_id=teacherCourseInfo.getUser_id();

        //判断是否有重复的，如果有就不用把user_id和course_id插入User_course_chapter_info表了
        User_course_chapter_info tt=teacherMapper.findSameUCCI(user_id,course_id);
        if(tt==null) {
            Integer influRowucci=teacherMapper.insertUser_course_chapter_info(user_id,course_id);
        }
            //节的值就是课程名字
            teacherCourseInfo.setCourse_jie_name(files[1].getOriginalFilename());
            //这里要实现本地路径的存储!!!
            String video_src=psp.savePathAndProducePath(files[0]);
//            System.out.println("video_src:"+video_src);
        //设置课程视频路径
        teacherCourseInfo.setCourse_src_path(video_src);
        teacherCourseInfo.setCourse_id(course_id);
        Integer influRow=teacherMapper.insertChapter(teacherCourseInfo);
        //得到chapter_id
        Integer chapter_id=teacherCourseInfo.getChapter_id();
        influRow=teacherMapper.insertCourse_chapter(course_id,chapter_id);
        return new ResultData<TeacherCourseInfo>(200,"添加成功",teacherCourseInfo);
    }

    public ResultData<TeacherCourseInfo> courseVideoInfoUpdate(TeacherCourseInfo teacherCourseInfo){
             Integer rows=teacherMapper.courseVideoInfoUpdate(teacherCourseInfo);
             System.out.println(rows);
             return new ResultData<TeacherCourseInfo>(200,"操作成功",teacherCourseInfo);
    }

    public ResultData<List<TeacherCourseInfo>> findCourseVideoInfo(TeacherCourseInfo teacherCourseInfo){
        if(!teacherCourseInfo.getCourse_name().equalsIgnoreCase("")) teacherCourseInfo.setCourse_name("%"+teacherCourseInfo.getCourse_name()+"%");
        if(!teacherCourseInfo.getCourse_category().equalsIgnoreCase("")) teacherCourseInfo.setCourse_category("%"+teacherCourseInfo.getCourse_category()+"%");
        if (teacherCourseInfo.getCourse_name().equalsIgnoreCase("")&&teacherCourseInfo.getCourse_category().equalsIgnoreCase("")){
            teacherCourseInfo.setCourse_name("%");
        }
//        System.out.println(teacherCourseInfo);
        List<TeacherCourseInfo> list=teacherMapper.findCourseVideoInfo(teacherCourseInfo);
//        System.out.println(list);
            return new ResultData<List<TeacherCourseInfo>>(200,"操作成功",list);
    }
    public ResultData<TeacherCourseInfo> courseVideoInfoDelete(TeacherCourseInfo teacherCourseInfo){
//        因为有其他用户评论了该课程，所以需要删除chapter_id相等的记录在user_course_chapter_info表中
        Integer influRows=teacherMapper.user_course_chapter_infoDelete(teacherCourseInfo);
        influRows=teacherMapper.courseVideoInfoDeleteCourse_Chapter(teacherCourseInfo);
        influRows=teacherMapper.courseVideoInfoDeleteChapter(teacherCourseInfo);
        return new ResultData<TeacherCourseInfo>(200,"操作成功",teacherCourseInfo);
    }
}
