package com.isai.demo_system_management_trailers.services;

import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;


public interface WarehouseService {
    void startWarehouseFiles();

    String storeFile(MultipartFile archive);

    Path loadFile(String nameArchive);

    Resource loadFileAsResource(String fileName);

    void deleteFile(String fileName);

}
