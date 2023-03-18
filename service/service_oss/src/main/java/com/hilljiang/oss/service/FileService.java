package com.hilljiang.oss.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    /**
     * Upload File to aliyun OSS
     * @param file
     * @return
     */
    String upload(MultipartFile file);
}
