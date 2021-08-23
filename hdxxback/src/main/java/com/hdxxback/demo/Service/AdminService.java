package com.hdxxback.demo.Service;

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
}
