package com.cpe.backend.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import com.cpe.backend.entity.Employee;
import com.cpe.backend.entity.Warehouse;
import com.cpe.backend.entity.Parcel;


@Data
@Entity
@NoArgsConstructor
@Table(name="Delivery")
public class Delivery {

    @Id
    @SequenceGenerator(name="Delivery_seq",sequenceName="Delivery_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Delivery_seq")
    @Column(name = "Delivery_ID", unique = true, nullable = true)
    private @NonNull Long id;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Employee.class)
    @JoinColumn(name = "Employee_ID", insertable = true)
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Warehouse.class)
    @JoinColumn(name = "Warehouse_ID", insertable = true)
    private Warehouse warehouse;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Parcel.class)
    @JoinColumn(name = "Parcel_ID", insertable = true)
    private Parcel parcel;
}