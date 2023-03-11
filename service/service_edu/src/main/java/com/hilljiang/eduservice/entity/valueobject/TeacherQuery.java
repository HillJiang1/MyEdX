package com.hilljiang.eduservice.entity.valueobject;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: HillJiang
 * @Date: 2023/3/11
 * @Version 1.0
 */
@Data
public class TeacherQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    private Integer level;

    private String begin;

    private String end;
}
