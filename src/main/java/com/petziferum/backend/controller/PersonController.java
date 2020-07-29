package com.petziferum.backend.controller;

import com.petziferum.backend.model.Person;
import com.petziferum.backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PersonController  {

    @Autowired
    PersonRepository repo;


    @GetMapping("/persons")
    public ResponseEntity getAllPersons(){
        List<Person> list = repo.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/post")
    public ResponseEntity saveOrUpdatePerson(@RequestBody Person person){ //erwartet ein Person Object
        System.out.println("post Person: " + person.getFirstName() + " " + person.getLastName() + " Id: " + person.getId());
        repo.save(person);
        return ResponseEntity.ok(person);
    }

    @GetMapping("/persons/{firstName}")
     public Person getPerson(@RequestParam(value="firstName", required = false) String firstName, @RequestParam(value="lastName",required = false) String lastName){
        Person p = new Person(firstName, lastName, 0);
        return p;
    }
}
