package com.isai.demo_system_management_trailers.controllers;

import com.isai.demo_system_management_trailers.services.imp.WarehouseServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/assets")
@RequiredArgsConstructor
public class WebConfigController {
    private final WarehouseServiceImp warehouseServiceImp;

    @GetMapping("/{filename:.+}")
    public Resource getResource(@PathVariable String filename) {
        return warehouseServiceImp.loadFileAsResource(filename);
    }

}
