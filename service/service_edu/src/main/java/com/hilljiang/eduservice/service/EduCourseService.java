package com.hilljiang.eduservice.service;

import com.hilljiang.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hilljiang.eduservice.entity.valueobject.CourseInfoForm;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author hilljiang
 * @since 2023-04-01
 */
public interface EduCourseService extends IService<EduCourse> {
    String saveCourseInfo(CourseInfoForm courseInfoForm);

    CourseInfoForm getCourseById(String id);

    void updateCourseInfo(CourseInfoForm courseInfoForm);
}
