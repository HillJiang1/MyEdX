package com.hilljiang.oss.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.hilljiang.commonutils.Result;
import com.hilljiang.oss.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("ossservice/file")
@CrossOrigin
public class FileUploadController {
    @Autowired
    private FileService fileService;

    @PostMapping("upload")
    public Result uploadOssFile(MultipartFile file){
        String url = fileService.upload(file);

        return Result.ok().data("url",url);
    }
}
