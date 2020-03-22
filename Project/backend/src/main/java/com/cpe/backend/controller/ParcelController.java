package com.cpe.backend.controller;

import com.cpe.backend.entity.Parcel;
import com.cpe.backend.repository.ParcelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ParcelController {

    @Autowired
    private final ParcelRepository parcelRepository;

    public ParcelController(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }

    @GetMapping("/parcel")
    public Collection<Parcel> Parcels() {
        return parcelRepository.findAll().stream().collect(Collectors.toList());
    }

}