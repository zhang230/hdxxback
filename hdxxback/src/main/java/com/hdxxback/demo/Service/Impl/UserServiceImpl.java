package com.hdxxback.demo.Service.Impl;

import com.hdxxback.demo.Mapper.UserMapper;
import com.hdxxback.demo.Pojo.ResultData;
import com.hdxxback.demo.Pojo.User;
import com.hdxxback.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
