package com.hdxxback.demo.Service.Impl;

import com.hdxxback.demo.Mapper.TeacherMapper;
import com.hdxxback.demo.Pojo.ResultData;
import com.hdxxback.demo.Pojo.TeacherCourseInfo;
import com.hdxxback.demo.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    public ResultData<List<TeacherCourseInfo>> allCourseVideoInfo(Integer user_id){
        List<TeacherCourseInfo> tlist=teacherMapper.allCourseVideoInfo(user_id);
        return new ResultData<List<TeacherCourseInfo>>(200,"操作成功",tlist);
    }
}
