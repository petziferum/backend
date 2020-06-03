package com.petziferum.backend.controller;

import com.petziferum.backend.model.Person;
import com.petziferum.backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class PersonController {

    @Autowired
    PersonRepository repo;


    @GetMapping("/persons")
    public ResponseEntity getAllPersons(){
        List<Person> list = repo.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/persons/{firstName}")
     public Person getPerson(@RequestParam(value="firstName", required = false) String firstName, @RequestParam(value="lastName",required = false) String lastName){
        Person p = new Person(firstName, lastName);

        return p;
    }
}
