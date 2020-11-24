package com.petziferum.backend.controller;

import com.petziferum.backend.model.Employee;
import com.petziferum.backend.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    private final EmployeeRepository repository;

    EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/")
    List<Employee> all() {
        return repository.findAll();
    }
    @PostMapping("/")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }

    // Single item

    @GetMapping("/employees/{id}")
    Employee one(@PathVariable String id) throws FileNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new FileNotFoundException(id));
    }
    @RequestMapping(value = "/employees/{lastname}", produces = "application/json")
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
                    employee.setfirstName(newEmployee.getfirstName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable String id) {
        repository.deleteById(id);
    }



}

