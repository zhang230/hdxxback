package com.hdxxback.demo.Controller;

import com.hdxxback.demo.Pojo.ResultData;
import com.hdxxback.demo.Pojo.User;
import com.hdxxback.demo.Service.Impl.UserServiceImpl;
import com.hdxxback.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userregister")
public class RegisterController {
    @Autowired
    private UserServiceImpl userService;
    @CrossOrigin
    @PostMapping("/register")
    public ResultData<User> userRegister(@RequestBody User user){
        return userService.userRegister(user);
    }
}
