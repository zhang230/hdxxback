package com.hdxxback.demo.Controller;

import com.hdxxback.demo.Pojo.ResultData;
import com.hdxxback.demo.Pojo.TeacherCourseInfo;
import com.hdxxback.demo.Pojo.User;
import com.hdxxback.demo.Service.Impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


}
