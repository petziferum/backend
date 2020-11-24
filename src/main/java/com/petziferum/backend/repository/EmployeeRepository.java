package com.petziferum.backend.repository;

import com.petziferum.backend.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface EmployeeRepository extends MongoRepository<Employee, String> {

    List<Employee> findByLastName(String name);
}

