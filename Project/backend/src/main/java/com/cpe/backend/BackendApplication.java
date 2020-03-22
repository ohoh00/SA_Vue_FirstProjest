package com.cpe.backend;

import java.util.stream.Stream;
import com.cpe.backend.entity.Warehouse;
import com.cpe.backend.entity.Employee;
import com.cpe.backend.entity.Parcel;
import com.cpe.backend.repository.WarehouseRepository;
import com.cpe.backend.repository.EmployeeRepository;
import com.cpe.backend.repository.ParcelRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	ApplicationRunner init(EmployeeRepository employeeRepository,WarehouseRepository warehouseRepository,ParcelRepository parcelRepository) {
		return args -> {
			Stream.of("โกดัง1", "โกดัง2", "โกดัง3", "โกดัง4").forEach(name -> {
				Warehouse warehouse = new Warehouse(); // สร้าง Object Customer
				warehouse.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Customer
				warehouseRepository.save(warehouse); // บันทึก Objcet ชื่อ Customer
			});
			Stream.of("นายสอง หนึ่ง", "นายหนึ่ง สอง").forEach(name -> {
				Employee employee = new Employee(); // สร้าง Object Customer
				employee.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Customer
				employeeRepository.save(employee); // บันทึก Objcet ชื่อ Customer
			});
			Stream.of("นายพร เทพ", "นายเอ สอง").forEach(name -> {
				Parcel parcel = new Parcel(); // สร้าง Object Customer
				parcel.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Customer
				parcelRepository.save(parcel); // บันทึก Objcet ชื่อ Customer
			});


			employeeRepository.findAll().forEach(System.out::println);
			warehouseRepository.findAll().forEach(System.out::println);
			parcelRepository.findAll().forEach(System.out::println);
		};
	}		
}
