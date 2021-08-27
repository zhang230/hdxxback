package com.hdxxback.demo.Service;


import com.hdxxback.demo.Pojo.Course;
import com.hdxxback.demo.Pojo.ResultData;
import com.hdxxback.demo.Pojo.User;
import com.hdxxback.demo.Pojo.User_course_chapter_info;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
    public ResultData<User> userNameRepeat(User user);

    public ResultData<User> userRegister(User user);

    public ResultData<List<Course>> allCourseInfo();

    public ResultData<List<Course>> searchCourseInfo(String course_name);

    public ResultData<User> updateUserInfo(User tuser, MultipartFile file);

    public ResultData<User_course_chapter_info> userCommit(User_course_chapter_info user_course_chapter_info);

    public ResultData<List<User_course_chapter_info>> findUserCommit(User_course_chapter_info user_course_chapter_info);
}