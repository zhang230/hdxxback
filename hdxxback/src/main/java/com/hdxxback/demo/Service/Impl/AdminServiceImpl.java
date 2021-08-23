package com.hdxxback.demo.Service.Impl;

import com.hdxxback.demo.Mapper.AdminMapper;
import com.hdxxback.demo.Pojo.ResultData;
import com.hdxxback.demo.Pojo.User;
import com.hdxxback.demo.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
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
         System.out.println("受影响的行: "+rows);
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
}
