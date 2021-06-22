package com.petziferum.backend.controller;

import com.petziferum.backend.model.Employee;
import com.petziferum.backend.model.EmployeeDTO;
import com.petziferum.backend.repository.EmployeeRepository;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;
    private String name;

    // Aggregate root

    @GetMapping("/")
    List<Employee> all() {
        return repository.findAll();
    }

    @GetMapping("/name")
    public Employee getEmployeesSorted(@RequestParam String e) {
        return repository.getEmployeeByFirstName(e);
    }

    @PostMapping("/")
    public ResponseEntity<Employee> saveNewEmployee(@RequestBody EmployeeDTO newEmployee) {

        Employee e =  Employee.createEmployee(newEmployee);

        repository.save(e);

        return ResponseEntity.ok(e);
    }

    // Single item

    @GetMapping("/employees/{id}")
    Employee one(@PathVariable String id) throws FileNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new FileNotFoundException(id));
    }

    @GetMapping("/query/firstname")
    public ResponseEntity<List<Employee>> queryFirstname(@RequestParam String firstname ){

        String search = firstname.substring(0,1).toUpperCase(Locale.ROOT).concat(firstname.substring(1)); //Todo: Casesensitivity raus machen wenn möglich, damit man auch Kleingeschriebenes angezeigt bekommt

        System.out.println(search);

        return ResponseEntity.ok(repository.findEmployeeByFirstNameContaining(search));
    }

    @GetMapping(value = "/employees/{lastname}", produces = "application/json")
    public ResponseEntity employees(@RequestParam(value= "lastname") String lastname) throws Exception {
        List<Employee> employeelist =
            repository.findByLastName(lastname);
        if(employeelist.isEmpty()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nicht gefunden.");
        }else {
            return ResponseEntity.ok(employeelist);
        }
    }

    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable String id) {

        return repository.findById(id)
                .map(employee -> {
                    employee.setfirstName(newEmployee.getFirstName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    @DeleteMapping("/delete/id/{id}")
    void deleteEmployee(@PathVariable String id) {
        repository.deleteById(id);
    }

    @DeleteMapping("/delete/name/{firstname}")
    void deleteEmployeeByName(@Parameter(description = "Search by Firstname of Employee")@PathVariable(value = "firstname") String name){
        this.name = name;

        System.out.println("wird gelöscht: " + name);

        repository.deleteEmployeeByFirstName(name);
    }



}

