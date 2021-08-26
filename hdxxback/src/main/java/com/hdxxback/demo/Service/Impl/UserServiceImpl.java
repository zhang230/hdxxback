package com.hdxxback.demo.Service.Impl;

import com.hdxxback.demo.Mapper.UserMapper;
import com.hdxxback.demo.Pojo.Course;
import com.hdxxback.demo.Pojo.ResultData;
import com.hdxxback.demo.Pojo.User;
import com.hdxxback.demo.Service.UserService;
import com.hdxxback.demo.Utils.ProduceSrcPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public ResultData<User> userNameRepeat(User user) {
        User tuser=userMapper.userNameRepeat(user);
        String msg="";
        if(tuser == null){
            msg="账号错误或者未注册";
        }else{
            if(tuser.getUser_password().equalsIgnoreCase(user.getUser_password())) msg="操作成功";
            else msg="密码错误";
        }
        return new ResultData<User>(200,msg,tuser);
    }

    @Override
    public ResultData<User> userRegister(User user) {
        user.setUser_phone(user.getUser_name());
        user.setRole("user");
        User tuser = userMapper.userNameRepeat(user);
        String msg="";
        if(tuser!=null){
            msg="账号重复";
        }else{
            msg="注册成功";
            Integer influrows=userMapper.insertUser(user);
        }
        return new ResultData<User>(200,msg,tuser);
    }
    @Override
    public ResultData<List<Course>> allCourseInfo(){
        List<Course> courselist=userMapper.allCourseInfo();
//        System.out.println(courselist);
        return new ResultData<List<Course>>(200,"操作成功",courselist);
    }

    @Override
    public ResultData<List<Course>> searchCourseInfo(String course_name){
           if("".equalsIgnoreCase(course_name))course_name="%";
           else course_name="%"+course_name+"%";

//           System.out.println(course_name);
           return new ResultData<List<Course>>(200,"操作成功",userMapper.searchCourseInfo(course_name));
    }


    @Override
    public ResultData<User> updateUserInfo(User tuser, MultipartFile file){
                String avatorSrc= ProduceSrcPath.savePathAndProducePath(file);
                tuser.setUser_icon(avatorSrc);
                Integer influRows=userMapper.updateUserInfo(tuser);
                return new ResultData<User>(200,"操作成功",tuser);
    }
}
