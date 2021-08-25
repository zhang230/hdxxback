package com.hdxxback.demo.Service.Impl;

import com.hdxxback.demo.Mapper.TeacherMapper;
import com.hdxxback.demo.Pojo.Course;
import com.hdxxback.demo.Pojo.ResultData;
import com.hdxxback.demo.Pojo.TeacherCourseInfo;
import com.hdxxback.demo.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
public class TeacherServiceImpl implements TeacherService {

//    windows
    private static String UPLOADED_FOLDER = "C://springboot//";
    private static String UPLOADED_VIDEO_FOLDER = "C:/advisor/upload/video/";
    private static String UPLOADED_IMAGE_FOLDER="C:/advisor/upload/image/";
//    Linux
//    private static String UPLOADED_FOLDER = "/home/sx/springboot/";
//    private static String UPLOADED_VIDEO_FOLDER = "/home/sx/advisor/upload/video/";
//    private static String UPLOADED_IMAGE_FOLDER="/home/sx/advisor/upload/image/";





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
            //如果没有相同的course_name,那么就把新的course_name插入到course表中，得到返回的主键
            Integer influRow=teacherMapper.insertCourse(teacherCourseInfo);
//            System.out.println("得到的course_id为: "+teacherCourseInfo.getCourse_id());
            course_id=teacherCourseInfo.getCourse_id();
        }

        //得到course_id之后，把user_id和course_id插入user_course_chapter_info表
        Integer user_id=teacherCourseInfo.getUser_id();
        Integer influRowucci=teacherMapper.insertUser_course_chapter_info(user_id,course_id);
//        for(Integer i=0;i<files.length;i++){
            teacherCourseInfo.setCourse_jie_name(files[0].getOriginalFilename());
            //这里要实现本地路径的存储!!!



            String pathOnServer="";
            if(files[0].isEmpty()){
                System.out.println("文件为空");
                return null; //redirect:
            }
            int begin = files[0].getOriginalFilename().indexOf(".");
            int last=files[0].getOriginalFilename().length();
            String end_filename="";
            //获得文件后缀名
            String fileType=files[0].getOriginalFilename().substring(begin+1,last);
            String pathPrefix=""; //保存文件的路径前缀

            try {
                byte[] bytes =files[0].getBytes();
                String fileNameNew =files[0].getOriginalFilename();
                int dotLocation = fileNameNew.lastIndexOf('.');
                //文件名，用日期命名保证唯一
                fileNameNew = fileNameNew.substring(0,dotLocation)
                        + (new SimpleDateFormat("_yyyyMMdd-HHmmss-SSS").format(new Date()))
                        + fileNameNew.substring(dotLocation);
                end_filename=fileNameNew;
                if(fileType.equalsIgnoreCase("mp4")||fileType.equalsIgnoreCase("ogg")
                        ||fileType.equalsIgnoreCase("flv")||fileType.equalsIgnoreCase("avi")
                ||fileType.equalsIgnoreCase("wmv")||fileType.equalsIgnoreCase("rmvb")){
                    pathPrefix=UPLOADED_VIDEO_FOLDER;
                }else if(fileType.equalsIgnoreCase("jpeg")||fileType.equalsIgnoreCase("jpg")||fileType.equalsIgnoreCase("png")){
                    pathPrefix=UPLOADED_IMAGE_FOLDER;
                }else{
                    return null;
                }
                pathOnServer=pathPrefix+end_filename;
                Path path= Paths.get(pathOnServer);
                //写入本地文件
                Files.write(path,bytes);

            } catch (IOException e) {
                e.printStackTrace();
                pathOnServer="";
            }
            System.out.println(pathOnServer);



            teacherCourseInfo.setCourse_src_path(pathOnServer);
            Integer influRow=teacherMapper.insertChapter(teacherCourseInfo);
            //得到chapter_id
            Integer chapter_id=teacherCourseInfo.getChapter_id();
            influRow=teacherMapper.insertCourse_chapter(course_id,chapter_id);
//        }

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
        Integer influRows=teacherMapper.courseVideoInfoDeleteCourse_Chapter(teacherCourseInfo);
        influRows=teacherMapper.courseVideoInfoDeleteChapter(teacherCourseInfo);
        return new ResultData<TeacherCourseInfo>(200,"操作成功",teacherCourseInfo);
    }
}
