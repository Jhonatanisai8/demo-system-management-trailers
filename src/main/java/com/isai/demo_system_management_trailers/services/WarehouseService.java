package com.isai.demo_system_management_trailers.services;

import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.Resource;

public interface WarehouseService {
    void startWarehouseFiles();

    String storeFile(MultipartFile archive);

    String loadFile(String nameArchive);

    Resource loadFileAsResource(String fileName);

    void deleteFile(String fileName);

}
