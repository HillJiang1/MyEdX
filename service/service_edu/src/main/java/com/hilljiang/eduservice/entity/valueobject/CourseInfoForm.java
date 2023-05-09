package com.hilljiang.eduservice.entity.valueobject;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CourseInfoForm {
    private static final long serialVersionUID = 1L;

    private String id;

    private String teacherId;

    private String subjectId;

    private String subjectParentId;

    private String title;

    private BigDecimal price;

    private Integer lessonNum;

    private String cover;

    private String description;
}
