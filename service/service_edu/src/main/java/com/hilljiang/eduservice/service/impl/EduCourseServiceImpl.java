package com.hilljiang.eduservice.service.impl;

import com.hilljiang.eduservice.entity.EduCourse;
import com.hilljiang.eduservice.entity.EduCourseDescription;
import com.hilljiang.eduservice.entity.valueobject.CourseInfoForm;
import com.hilljiang.eduservice.mapper.EduCourseMapper;
import com.hilljiang.eduservice.service.EduCourseDescriptionService;
import com.hilljiang.eduservice.service.EduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hilljiang.servicebase.handler.exceptionhandler.MyException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author hilljiang
 * @since 2023-04-01
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    @Autowired
    private EduCourseDescriptionService courseDescriptionService;


    @Override
    public String saveCourseInfo(CourseInfoForm courseInfoForm) {
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoForm,eduCourse);
        int insert = baseMapper.insert(eduCourse);

        if(insert == 0){
            throw new MyException(20001,"Add Course Failed!");
        }

        String courseId = eduCourse.getId();

        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        eduCourseDescription.setDescription(courseInfoForm.getDescription());
        eduCourseDescription.setId(courseId);
        courseDescriptionService.save(eduCourseDescription);

        return courseId;
    }

    @Override
    public CourseInfoForm getCourseById(String id) {
        CourseInfoForm courseInfoForm = new CourseInfoForm();

        EduCourse eduCourse = baseMapper.selectById(id);
        BeanUtils.copyProperties(eduCourse,courseInfoForm);

        EduCourseDescription eduCourseDescription = courseDescriptionService.getById(id);
        courseInfoForm.setDescription(eduCourseDescription.getDescription());

        return courseInfoForm;
    }

    @Override
    public void updateCourseInfo(CourseInfoForm courseInfoForm) {
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoForm,eduCourse);
        int update = baseMapper.updateById(eduCourse);
        if(update == 0){
            throw new MyException(20001,"Update course info failed!");
        }

        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        BeanUtils.copyProperties(courseInfoForm,eduCourseDescription);
        courseDescriptionService.updateById(eduCourseDescription);
    }


}
