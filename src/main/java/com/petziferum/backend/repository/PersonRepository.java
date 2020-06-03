package com.petziferum.backend.repository;

import com.petziferum.backend.model.Person;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PersonRepository extends MongoRepository<Person, String> {

    public Person findByFirstName(String firstName);
}
