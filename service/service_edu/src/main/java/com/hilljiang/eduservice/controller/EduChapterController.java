package com.hilljiang.eduservice.controller;


import com.hilljiang.commonutils.Result;
import com.hilljiang.eduservice.entity.chapter.ChapterVo;
import com.hilljiang.eduservice.service.EduChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author hilljiang
 * @since 2023-04-01
 */
@RestController
@RequestMapping("/eduservice/chapter")
@CrossOrigin
public class EduChapterController {

    @Autowired
    private EduChapterService eduChapterService;

    @GetMapping("getChapterVideo/{courseId}")
    public Result getChapterVideo(@PathVariable String courseId){
        List<ChapterVo> chapterVoList = eduChapterService.getChapterByCourseId(courseId);
        return Result.ok().data("chapters",chapterVoList);
    }


}

