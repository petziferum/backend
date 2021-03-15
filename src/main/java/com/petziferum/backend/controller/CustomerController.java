package com.petziferum.backend.controller;

import com.petziferum.backend.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @PostMapping("/newcustomer")
    public ResponseEntity<Customer> createCustomer(@RequestParam String firstName, @RequestParam String lastName) {

        Customer c = new Customer(firstName, lastName);
        c.generateNumber();
        return ResponseEntity.ok(c);
    }
}
