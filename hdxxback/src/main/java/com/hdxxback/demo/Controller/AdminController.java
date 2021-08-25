package com.hdxxback.demo.Controller;


import com.hdxxback.demo.Pojo.Course_category_manage;
import com.hdxxback.demo.Pojo.ResultData;
import com.hdxxback.demo.Pojo.User;
import com.hdxxback.demo.Service.AdminService;
import com.hdxxback.demo.Service.Impl.AdminServiceImpl;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;
    @CrossOrigin
    @GetMapping("/allUserInfo")
    public ResultData<List<User>> allUserInfo(){
        return adminService.allUserInfo();
    }

    @CrossOrigin
    @PutMapping("/userInfoUpdate")
    public ResultData<User> userInfoUpdate(@RequestBody User user){
//        System.out.println(user);
        return adminService.userInfoUpdate(user);
    }

    @CrossOrigin
    @PostMapping("/userInfoAdd")
    public ResultData<User> userInfoAdd(@RequestBody User user){
         return adminService.userInfoAdd(user);
    }

    @CrossOrigin
    @DeleteMapping("/userInfoDelete")
    public ResultData<User> userInfoDelete(@RequestBody User user){
//        System.out.println(user);
       return adminService.userInfoDelete(user);
    }

    @CrossOrigin
    @PostMapping("/findUserInfos")
    public ResultData<List<User>> findUserInfos(@RequestBody User user){
        return adminService.findUserInfos(user);
    }

//-------------------------------------------------------

    @CrossOrigin
    @GetMapping("/allCourseClassInfo")
    public ResultData<List<Course_category_manage>> allCourseClassInfo(){
        return adminService.allCourseClassInfo();
    }

    @CrossOrigin
    @PutMapping("/courseClassUpdate")
    public ResultData<Course_category_manage> courseClassUpdate(@RequestBody Course_category_manage course_category_manage){
        return adminService.courseClassUpdate(course_category_manage);
    }

    @CrossOrigin
    @PostMapping("/courseClassAdd")
    public ResultData<Course_category_manage> courseClassAdd(@RequestBody Course_category_manage course_category_manage){
        System.out.println("TestAddController: "+course_category_manage);
        return adminService.courseClassAdd(course_category_manage);
    }

    @CrossOrigin
    @DeleteMapping("/courseClassDelete")
    public ResultData<Course_category_manage> courseClassDelete(@RequestBody Course_category_manage course_category_manage){
        return adminService.courseClassDelete(course_category_manage);
    }
}
