package com.hdxxback.demo.Controller;

import com.hdxxback.demo.Pojo.ResultData;
import com.hdxxback.demo.Pojo.TeacherCourseInfo;
import com.hdxxback.demo.Pojo.User;
import com.hdxxback.demo.Service.Impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherServiceImpl teacherService;

    @CrossOrigin
    @GetMapping("/allCourseVideoInfo/{user_id}")
    public ResultData<List<TeacherCourseInfo>> allCourseVideoInfo(@PathVariable("user_id") Integer user_id){
//        System.out.println("user_id是: "+user_id);
       return teacherService.allCourseVideoInfo(user_id);
    }

    @CrossOrigin
    @PutMapping("/courseVideoInfoUpdate")
    public ResultData<TeacherCourseInfo> courseVideoInfoUpdate(@RequestBody TeacherCourseInfo teacherCourseInfo){
//        System.out.println(teacherCourseInfo);
        return teacherService.courseVideoInfoUpdate(teacherCourseInfo);
    }


    @CrossOrigin
    @DeleteMapping("/courseVideoInfoDelete")
    public ResultData<TeacherCourseInfo> courseVideoInfoDelete(@RequestBody TeacherCourseInfo teacherCourseInfo){
//        System.out.println(teacherCourseInfo);
        //需要删除course_chapter 和 chapter表对应的记录。因为teacherCourseInfo对象已经包含了 该用户对应的course和chapter。


        return teacherService.courseVideoInfoDelete(teacherCourseInfo);
    }




    @CrossOrigin
    @PostMapping(value="/file/upload",produces = "application/json")
    public ResultData<TeacherCourseInfo> uploadFile(@RequestParam("user_id") Integer user_id,
                                                    @RequestParam("course_id") Integer course_id,
                                                    @RequestParam("chapter_id") Integer chapter_id,
                                                    @RequestParam("course_name") String course_name,
                                                    @RequestParam("course_category") String course_category,
                                                    @RequestParam("course_time") Integer course_time,
                                                    @RequestParam("course_check_status") Integer course_check_status,
                                                    @RequestParam("course_open_time") Date course_open_time,
                                                    @RequestParam("course_src_path") String course_src_path,
                                                    @RequestParam("course_belong_to") String course_belong_to,
                                                    @RequestParam("course_origin") String course_origin,
                                                    @RequestParam("course_zhang_name") String course_zhang_name,
                                                    @RequestParam("course_jie_name") String course_jie_name,
                                                    @RequestParam("file") MultipartFile[] files){
        TeacherCourseInfo teacherCourseInfo = new TeacherCourseInfo(user_id,course_id,chapter_id,
                course_name,course_category,course_zhang_name,course_jie_name,course_src_path,
                course_check_status,course_time,course_open_time,course_belong_to,course_origin);
          return teacherService.uploadFile(teacherCourseInfo,files);
    }


    @CrossOrigin
    @PostMapping("/findCourseVideoInfo")
    public ResultData<List<TeacherCourseInfo>> findCourseVideoInfo(@RequestBody TeacherCourseInfo teacherCourseInfo){
//                System.out.println(teacherCourseInfo);
                return teacherService.findCourseVideoInfo(teacherCourseInfo);
    }

}
