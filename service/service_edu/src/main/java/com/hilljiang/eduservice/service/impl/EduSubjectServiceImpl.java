package com.hilljiang.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hilljiang.eduservice.entity.EduSubject;
import com.hilljiang.eduservice.entity.excel.ExcelSubjectData;
import com.hilljiang.eduservice.entity.subject.SubjectNestedVo;
import com.hilljiang.eduservice.entity.subject.SubjectVo;
import com.hilljiang.eduservice.listener.SubjectExcelListener;
import com.hilljiang.eduservice.mapper.EduSubjectMapper;
import com.hilljiang.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author hilljiang
 * @since 2023-03-18
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    public void saveSubject(MultipartFile file, EduSubjectService subjectService) {
        try{
            InputStream in = file.getInputStream();

            EasyExcel.read(in, ExcelSubjectData.class, new SubjectExcelListener(subjectService)).sheet().doRead();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<SubjectNestedVo> nestedList() { //最终要的到的数据列表
        ArrayList<SubjectNestedVo> subjectNestedVoArrayList = new ArrayList<>();

        QueryWrapper<EduSubject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", 0);
        queryWrapper.orderByAsc("sort", "id");
        List<EduSubject> subjects = baseMapper.selectList(queryWrapper);

        QueryWrapper<EduSubject> queryWrapper2 = new QueryWrapper<>(); queryWrapper2.ne("parent_id", 0); queryWrapper2.orderByAsc("sort", "id");
        List<EduSubject> subSubjects = baseMapper.selectList(queryWrapper2);

        int count = subjects.size();
        for (int i = 0; i < count; i++) {
            EduSubject subject = subjects.get(i);

            SubjectNestedVo subjectNestedVo = new SubjectNestedVo();
            BeanUtils.copyProperties(subject, subjectNestedVo); subjectNestedVoArrayList.add(subjectNestedVo);

            ArrayList<SubjectVo> subjectVoArrayList = new ArrayList<>(); int count2 = subSubjects.size();
            for (int j = 0; j < count2; j++) {
                EduSubject subSubject = subSubjects.get(j);
                if(subject.getId().equals(subSubject.getParentId())){

                    SubjectVo subjectVo = new SubjectVo();
                    BeanUtils.copyProperties(subSubject, subjectVo); subjectVoArrayList.add(subjectVo);
                } }
            subjectNestedVo.setChildren(subjectVoArrayList);
        }

        return subjectNestedVoArrayList;
    }
}
