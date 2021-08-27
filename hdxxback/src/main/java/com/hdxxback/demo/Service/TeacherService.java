package com.hdxxback.demo.Service;

import com.hdxxback.demo.Pojo.ResultData;
import com.hdxxback.demo.Pojo.TeacherCourseInfo;
import com.hdxxback.demo.Pojo.User_course_chapter_info;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface TeacherService {
    public ResultData<List<TeacherCourseInfo>> allCourseVideoInfo(Integer user_id);
    public ResultData<TeacherCourseInfo> courseVideoInfoUpdate(TeacherCourseInfo teacherCourseInfo);
    public ResultData<TeacherCourseInfo> uploadFile(TeacherCourseInfo teacherCourseInfo, MultipartFile[] files);
    public ResultData<List<TeacherCourseInfo>> findCourseVideoInfo(TeacherCourseInfo teacherCourseInfo);
    public ResultData<TeacherCourseInfo> courseVideoInfoDelete(TeacherCourseInfo teacherCourseInfo);
}
