package com.hilljiang.oss.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.hilljiang.commonutils.Result;
import com.hilljiang.oss.service.FileService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("ossservice/file")
@CrossOrigin
public class FileUploadController {
    @Autowired
    private FileService fileService;

    @PostMapping("upload")
    public Result uploadOssFile(
            @ApiParam(name = "file", value = "文件", required = true) @RequestParam("file") MultipartFile file){
        String url = fileService.upload(file);

        return Result.ok().data("url",url);
    }
}
