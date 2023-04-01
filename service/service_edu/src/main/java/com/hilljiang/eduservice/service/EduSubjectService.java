package com.hilljiang.eduservice.service;

import com.hilljiang.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hilljiang.eduservice.entity.subject.SubjectNestedVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author hilljiang
 * @since 2023-03-18
 */
public interface EduSubjectService extends IService<EduSubject> {

    void saveSubject(MultipartFile file, EduSubjectService subjectService);

    List<SubjectNestedVo> nestedList();
}
