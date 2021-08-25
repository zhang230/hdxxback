package com.hdxxback.demo.Service;

import com.hdxxback.demo.Pojo.Course_category_manage;
import com.hdxxback.demo.Pojo.ResultData;
import com.hdxxback.demo.Pojo.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AdminService {
    public ResultData<List<User>> allUserInfo();
    public ResultData<User> userInfoUpdate(User user);
    public ResultData<User> userInfoAdd(User user);
    public ResultData<User> userInfoDelete(User user);
    public ResultData<List<User>> findUserInfos(User user);

    public ResultData<List<Course_category_manage>> allCourseClassInfo();
    public ResultData<Course_category_manage> courseClassUpdate(Course_category_manage course_category_manage);
    public ResultData<Course_category_manage> courseClassAdd(Course_category_manage course_category_manage);
    public ResultData<Course_category_manage> courseClassDelete(Course_category_manage course_category_manage);
    ResultData<List<Course_category_manage>> findCourseClassInfo(Course_category_manage course_category_manage);
}
