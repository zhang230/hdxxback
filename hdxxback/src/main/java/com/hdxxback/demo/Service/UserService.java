package com.hdxxback.demo.Service;


import com.hdxxback.demo.Pojo.ResultData;
import com.hdxxback.demo.Pojo.User;

public interface UserService {
    public ResultData<User> userNameRepeat(User user);
    public ResultData<User> userRegister(User user);
}
