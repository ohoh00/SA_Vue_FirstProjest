package com.cpe.backend.repository;

import com.cpe.backend.entity.Warehouse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
	Warehouse findById(long id);
}
