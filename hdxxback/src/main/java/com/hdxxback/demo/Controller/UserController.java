package com.hdxxback.demo.Controller;

import com.hdxxback.demo.Pojo.Course;
import com.hdxxback.demo.Pojo.ResultData;
import com.hdxxback.demo.Pojo.User;
import com.hdxxback.demo.Pojo.User_course_chapter_info;
import com.hdxxback.demo.Service.Impl.UserServiceImpl;
import com.hdxxback.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

//    查免费公开课程和课程对应的章节视频。
    @CrossOrigin
    @GetMapping("/allCourseInfo")
    public ResultData<List<Course>> allCourseInfo(){
        return userService.allCourseInfo();
    }

    @CrossOrigin
    @GetMapping("/searchCourseInfo")
    public ResultData<List<Course>> searchCourseInfo(@RequestParam("course_name") String course_name){
//        System.out.println("数据: "+course_name);
           return userService.searchCourseInfo(course_name);
    }

    @CrossOrigin
    @PutMapping(value="/file/upload",produces = "application/json")
    public ResultData<User> fileUpload(@RequestParam("user_id") Integer user_id,
                                        @RequestParam("name") String name,
                                       @RequestParam("user_phone") String user_phone,
                                       @RequestParam("email") String email,
                                       @RequestParam("identity_card") String identity_card,
                                       @RequestParam("organization") String organization,
                                       @RequestParam("branch_name") String branch_name,
                                       @RequestParam("user_nickname") String user_nickname,
                                       @RequestParam("position") String position,
                                       @RequestParam("a_points") Integer a_points,
                                       @RequestParam("account_balance") Double account_balance,
                                       @RequestParam("file") MultipartFile file){
           User tuser=new User();
           tuser.setUser_id(user_id);
           tuser.setName(name);
           tuser.setUser_name(user_phone);
           tuser.setUser_phone(user_phone);
           tuser.setEmail(email);
           tuser.setIdentity_card(identity_card);
           tuser.setOrganization(organization);
           tuser.setBranch_name(branch_name);
           tuser.setUser_nickname(user_nickname);
           tuser.setPosition(position);
           tuser.setA_points(a_points);
           tuser.setAccount_balance(account_balance);
//           System.out.println(tuser);
            return userService.updateUserInfo(tuser,file);
    }

    @CrossOrigin
    @PostMapping("/userCommit")
    public ResultData<User_course_chapter_info> userCommit(@RequestBody User_course_chapter_info user_course_chapter_info){
//        System.out.println(user_course_chapter_info.getUser_commit_time());
        return userService.userCommit(user_course_chapter_info);
    }

    @CrossOrigin
    @PostMapping("/findUserCommit")
    public ResultData<List<User_course_chapter_info>> findUserCommit(@RequestBody User_course_chapter_info user_course_chapter_info){
//        System.out.println(user_course_chapter_info);
        return userService.findUserCommit(user_course_chapter_info);
    }
}
