package com.hdxxback.demo.Service;

import com.hdxxback.demo.Pojo.ResultData;
import com.hdxxback.demo.Pojo.TeacherCourseInfo;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

public interface TeacherService {
    public ResultData<List<TeacherCourseInfo>> allCourseVideoInfo(Integer user_id);
}
