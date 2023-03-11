package com.hilljiang.eduservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hilljiang.commonutils.Result;
import com.hilljiang.eduservice.entity.EduTeacher;
import com.hilljiang.eduservice.entity.valueobject.TeacherQuery;
import com.hilljiang.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author hilljiang
 * @since 2023-03-11
 */
@RestController
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    @GetMapping("getAll")
    public Result getAllTeacher(){
        List<EduTeacher> list = eduTeacherService.list(null);
        return Result.ok().data("AllTeacherList",eduTeacherService.list(null));
    }

    @DeleteMapping("{id}")
    public Result removeById(@PathVariable String id){
        boolean flag = eduTeacherService.removeById(id);
        return flag? Result.ok() : Result.error();
    }

    @GetMapping("paging/{page}/{limit}")
    public Result pageList(@PathVariable Long page, @PathVariable Long limit){
        Page<EduTeacher> pageParam = new Page<>(page, limit);
        int i = 10/0;
        eduTeacherService.page(pageParam, null);
        List<EduTeacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return Result.ok().data("total", total).data("rows", records);
    }

    @PostMapping("condition/paging/{page}/{limit}")
    public Result getConditionalPages(@PathVariable Long page, @PathVariable Long limit, @RequestBody(required = false) TeacherQuery teacherQuery){
        Page<EduTeacher> pageParam = new Page<>(page, limit);
        eduTeacherService.pageQuery(pageParam, teacherQuery);
        List<EduTeacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return Result.ok().data("total", total).data("rows", records);
    }

    @PostMapping
    public Result insertTeacher(@RequestBody EduTeacher teacher){
        boolean flag = eduTeacherService.save(teacher);
        return flag ? Result.ok() : Result.error();
    }

    @PutMapping("{id}")
    public Result updateById(@PathVariable String id, @RequestBody EduTeacher teacher){
        teacher.setId(id);
        boolean flag = eduTeacherService.updateById(teacher);
        return flag? Result.ok():Result.error();
    }

}

