package com.hilljiang.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hilljiang.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hilljiang.eduservice.entity.valueobject.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author hilljiang
 * @since 2023-03-11
 */
public interface EduTeacherService extends IService<EduTeacher> {
    void pageQuery(Page<EduTeacher> pageParam, TeacherQuery teacherQuery);
}
