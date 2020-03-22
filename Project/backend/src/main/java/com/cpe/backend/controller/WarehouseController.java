package com.cpe.backend.controller;

import com.cpe.backend.entity.Warehouse;
import com.cpe.backend.repository.WarehouseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class WarehouseController {

    @Autowired
    private final WarehouseRepository warehouseRepository;

    public WarehouseController(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @GetMapping("/warehouse")
    public Collection<Warehouse> Warehouses() {
        return warehouseRepository.findAll().stream().collect(Collectors.toList());
    }

}