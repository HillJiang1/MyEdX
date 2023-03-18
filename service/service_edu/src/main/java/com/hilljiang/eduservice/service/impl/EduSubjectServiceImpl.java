package com.hilljiang.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.hilljiang.eduservice.entity.EduSubject;
import com.hilljiang.eduservice.entity.excel.ExcelSubjectData;
import com.hilljiang.eduservice.listener.SubjectExcelListener;
import com.hilljiang.eduservice.mapper.EduSubjectMapper;
import com.hilljiang.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

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
}
