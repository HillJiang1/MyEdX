package com.hilljiang.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hilljiang.eduservice.entity.EduChapter;
import com.hilljiang.eduservice.entity.EduVideo;
import com.hilljiang.eduservice.entity.chapter.ChapterVo;
import com.hilljiang.eduservice.entity.chapter.SectionVo;
import com.hilljiang.eduservice.mapper.EduChapterMapper;
import com.hilljiang.eduservice.service.EduChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hilljiang.eduservice.service.EduVideoService;
import org.apache.velocity.util.ArrayListWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author hilljiang
 * @since 2023-04-01
 */
@Service
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {

    @Autowired
    private EduVideoService eduVideoService;

    @Override
    public List<ChapterVo> getChapterByCourseId(String courseId) {
        QueryWrapper<EduChapter> chapterQueryWrapper = new QueryWrapper<>();
        chapterQueryWrapper.eq("course_id",courseId);
        List<EduChapter> chapterList= baseMapper.selectList(chapterQueryWrapper);

        QueryWrapper<EduVideo> videoQueryWrapper = new QueryWrapper<>();
        videoQueryWrapper.eq("course_id",courseId);
        List<EduVideo> videoList = eduVideoService.list(videoQueryWrapper);

        List<ChapterVo> finalList = new ArrayList<>();
        for(int i = 0; i < chapterList.size(); i++) {
            EduChapter eduChapter = chapterList.get(i);
            ChapterVo chapterVo = new ChapterVo();
            BeanUtils.copyProperties(eduChapter, chapterVo);
            finalList.add(chapterVo);

            List<SectionVo> sectionVoList = new ArrayList<>();
            for(int j = 0; j < videoList.size(); j++){
                EduVideo eduVideo = videoList.get(j);
                if(eduVideo.getChapterId().equals(eduChapter.getId())){
                    SectionVo sectionVo = new SectionVo();
                    BeanUtils.copyProperties(eduVideo,sectionVo);
                    sectionVoList.add(sectionVo);
                }
            }

            chapterVo.setSectionVoList(sectionVoList);
        }

        return finalList;
    }
}
