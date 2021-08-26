package com.hdxxback.demo.Service;


import com.hdxxback.demo.Pojo.Course;
import com.hdxxback.demo.Pojo.ResultData;
import com.hdxxback.demo.Pojo.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
    public ResultData<User> userNameRepeat(User user);
    public ResultData<User> userRegister(User user);
    public ResultData<List<Course>> allCourseInfo();
    public ResultData<List<Course>> searchCourseInfo(String course_name);
    public ResultData<User> updateUserInfo(User tuser, MultipartFile file);
}
