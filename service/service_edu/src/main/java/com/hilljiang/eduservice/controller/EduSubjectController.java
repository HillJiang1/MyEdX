package com.hilljiang.eduservice.controller;


import com.hilljiang.commonutils.Result;
import com.hilljiang.eduservice.entity.EduSubject;
import com.hilljiang.eduservice.entity.subject.SubjectNestedVo;
import com.hilljiang.eduservice.service.EduSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author hilljiang
 * @since 2023-03-18
 */
@RestController
@RequestMapping("/eduservice/subject")
@CrossOrigin
public class EduSubjectController {
    @Autowired
    private EduSubjectService eduSubjectService;

    @PostMapping("import")
    public Result addSubject(MultipartFile file){
        eduSubjectService.saveSubject(file,eduSubjectService);

        return Result.ok();
    }

    @GetMapping
    public Result getSubject(){

        List<SubjectNestedVo> subjectNestedVoList = eduSubjectService.nestedList();
        return Result.ok().data("items", subjectNestedVoList);
    }

}

