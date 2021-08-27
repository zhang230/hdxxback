package com.hdxxback.demo.Service.Impl;

import com.hdxxback.demo.Mapper.AdminMapper;
import com.hdxxback.demo.Pojo.Course_category_manage;
import com.hdxxback.demo.Pojo.ResultData;
import com.hdxxback.demo.Pojo.User;
import com.hdxxback.demo.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
//事务回滚，保证出问题时不会触发数据库
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public ResultData<List<User>> allUserInfo(){
        return new ResultData<List<User>>(200,"操作成功",adminMapper.allUserInfo());
    }

    @Override
    public ResultData<User> userInfoUpdate(User user){
        Integer influRows = adminMapper.userInfoUpdate(user);
//        System.out.println("受影响的行数: "+influRows);
        return new ResultData<User>(200,"操作成功",user);
    }

    public ResultData<User> userInfoAdd(User user){
        User tuser = adminMapper.userNameRepeat(user);
        //说明没有重复的
        if(tuser==null) {
            Integer n = adminMapper.userInfoAdd(user);
//            System.out.println("是: " + n);
            return new ResultData<User>(200, "操作成功", user);
        }else{
            return new ResultData<User>(200,"已存在用户名",user);
        }
    }

    public ResultData<User> userInfoDelete(User user){
         Integer rows=adminMapper.userInfoDelete(user);
//         System.out.println("受影响的行: "+rows);
         return new ResultData<User>(200,"操作成功",user);
    }

    public ResultData<List<User>> findUserInfos( User user){
        if(!user.getUser_name().equalsIgnoreCase("")) user.setUser_name("%"+user.getUser_name()+"%");
        if(!user.getUser_phone().equalsIgnoreCase("")) user.setUser_phone("%"+user.getUser_phone()+"%");
        if(!user.getEmail().equalsIgnoreCase(""))  user.setEmail("%"+user.getEmail()+"%");
        if(!user.getUser_nickname().equalsIgnoreCase("")) user.setUser_nickname("%"+user.getUser_nickname()+"%");
        if(user.getUser_name().equalsIgnoreCase("") && user.getUser_phone().equalsIgnoreCase("") && user.getEmail().equalsIgnoreCase("") && user.getUser_nickname().equalsIgnoreCase(""))
        {
            user.setUser_name("%");
        }
//        System.out.println(user);
          List<User> userList=adminMapper.findUserInfos(user);
//          System.out.println(userList);
          return new ResultData<List<User>>(200,"操作成功",userList);
    }

    //------------------------------------------------
    @Override
    public ResultData<List<Course_category_manage>> allCourseClassInfo(){
        return new ResultData<List<Course_category_manage>>(200,"操作成功",adminMapper.allCourseClassInfo());
    }

    @Override
    public ResultData<Course_category_manage> courseClassUpdate(Course_category_manage course_category_manage){
        Integer n = adminMapper.courseClassUpdate(course_category_manage);
        if(n>0) return new ResultData<Course_category_manage>(200,"操作成功",course_category_manage);
        return new ResultData<Course_category_manage>(500,"操作失败",null);
    }

    @Override
    public ResultData<Course_category_manage> courseClassAdd(Course_category_manage course_category_manage){
            Integer n = adminMapper.courseClassAdd(course_category_manage);

        if(n>0) return new ResultData<Course_category_manage>(200,"操作成功",course_category_manage);
        return new ResultData<Course_category_manage>(500,"操作失败",null);

    }

    @Override
    public ResultData<Course_category_manage> courseClassDelete(Course_category_manage course_category_manage){
        Integer n=adminMapper.courseClassDelete(course_category_manage);
        if(n>0) return new ResultData<Course_category_manage>(200,"操作成功",course_category_manage);
        return new ResultData<Course_category_manage>(500,"操作失败",null);
    }

    @Override
    public ResultData<List<Course_category_manage>> findCourseClassInfo(Course_category_manage course_category_manage){
        List<Course_category_manage> ccList=adminMapper.findCourseClassInfo(course_category_manage);
        System.out.println(ccList);
        return new ResultData<List<Course_category_manage>>(200,"操作成功",ccList);
    }
}
