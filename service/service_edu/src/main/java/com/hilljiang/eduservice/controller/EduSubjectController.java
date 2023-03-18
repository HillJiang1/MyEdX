package com.hilljiang.eduservice.controller;


import com.hilljiang.commonutils.Result;
import com.hilljiang.eduservice.entity.EduSubject;
import com.hilljiang.eduservice.service.EduSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("addSubject")
    public Result addSubject(MultipartFile file){
        eduSubjectService.saveSubject(file,eduSubjectService);

        return Result.ok();
    }

}

