package com.hdxxback.demo.Controller;


import com.hdxxback.demo.Pojo.ResultData;
import com.hdxxback.demo.Pojo.User;
import com.hdxxback.demo.Service.AdminService;
import com.hdxxback.demo.Service.Impl.AdminServiceImpl;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;
    @CrossOrigin
    @GetMapping("/allUserInfo")
    public ResultData<List<User>> allUserInfo(){
        return adminService.allUserInfo();
    }

    @CrossOrigin
    @PutMapping("/userInfoUpdate")
    public ResultData<User> userInfoUpdate(@RequestBody User user){
//        System.out.println(user);
        return adminService.userInfoUpdate(user);
    }

    @CrossOrigin
    @PostMapping("/userInfoAdd")
    public ResultData<User> userInfoAdd(@RequestBody User user){
         return adminService.userInfoAdd(user);
    }

    @CrossOrigin
    @DeleteMapping("/userInfoDelete")
    public ResultData<User> userInfoDelete(@RequestBody User user){
        System.out.println(user);
       return adminService.userInfoDelete(user);
    }

    @CrossOrigin
    @PostMapping("/findUserInfos")
    public ResultData<List<User>> findUserInfos(@RequestBody User user){
        return adminService.findUserInfos(user);
    }
}
