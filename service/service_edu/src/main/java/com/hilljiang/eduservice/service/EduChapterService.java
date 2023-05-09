package com.hilljiang.eduservice.service;

import com.hilljiang.eduservice.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hilljiang.eduservice.entity.chapter.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author hilljiang
 * @since 2023-04-01
 */
public interface EduChapterService extends IService<EduChapter> {
    List<ChapterVo> getChapterByCourseId(String courseId);
}
