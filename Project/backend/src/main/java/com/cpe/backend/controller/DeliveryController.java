package com.cpe.backend.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.net.URLDecoder;

import com.cpe.backend.entity.Delivery;
import com.cpe.backend.entity.Employee;
import com.cpe.backend.entity.Warehouse;
import com.cpe.backend.entity.Parcel;

import com.cpe.backend.repository.DeliveryRepository;
import com.cpe.backend.repository.EmployeeRepository;
import com.cpe.backend.repository.WarehouseRepository;
import com.cpe.backend.repository.ParcelRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class DeliveryController {
    @Autowired
    private final DeliveryRepository deliveryRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private WarehouseRepository warehouseRepository;
    @Autowired
    private ParcelRepository parcelRepository;

    DeliveryController(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @GetMapping("/delivery")
    public Collection<Delivery> Deliverys() {
        return deliveryRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/delivery/{parcel_id}/{employee_id}/{warehouse_id}")
    public Delivery newDelivery(Delivery newDelivery,
    @PathVariable long employee_id,
    @PathVariable long warehouse_id,
    @PathVariable long parcel_id) {

    Employee employee = employeeRepository.findById(employee_id);
    Warehouse warehouse = warehouseRepository.findById(warehouse_id);
    Parcel parcel = parcelRepository.findById(parcel_id);

   
    newDelivery.setEmployee(employee);
    newDelivery.setParcel(parcel);
    newDelivery.setWarehouse(warehouse);
    

    return deliveryRepository.save(newDelivery); //บันทึก Objcet ชื่อ Delivery
    
    }
}