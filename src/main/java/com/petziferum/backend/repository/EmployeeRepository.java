package com.petziferum.backend.repository;

import com.petziferum.backend.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface EmployeeRepository extends MongoRepository<Employee, String> {

    List<Employee> findByLastName(String name);

    Employee getEmployeeByFirstName(String firstname);


    List<Employee> findEmployeeByFirstNameContaining(String firstname);

    void deleteEmployeeByFirstName(String firstname);
}

