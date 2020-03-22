package com.cpe.backend.repository;

import com.cpe.backend.entity.Parcel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface ParcelRepository extends JpaRepository<Parcel, Long> {
	Parcel findById(long id);
}
