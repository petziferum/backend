package com.petziferum.backend.repository;

import com.petziferum.backend.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface EmployeeRepository extends MongoRepository<Employee, String> {


}

