package com.hilljiang.eduservice.controller;


import com.hilljiang.commonutils.Result;
import com.hilljiang.eduservice.entity.valueobject.CourseInfoForm;
import com.hilljiang.eduservice.service.EduCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author hilljiang
 * @since 2023-04-01
 */
@RestController
@RequestMapping("/eduservice/course")
@CrossOrigin
public class EduCourseController {

    @Autowired
    private EduCourseService courseService;

    @PostMapping("import")
    public Result addCourse(@RequestBody CourseInfoForm courseInfoForm){
        String id = courseService.saveCourseInfo(courseInfoForm);

        return Result.ok().data("courseId",id);
    }


}

