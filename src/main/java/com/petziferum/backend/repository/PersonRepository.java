package com.petziferum.backend.repository;

import com.petziferum.backend.model.Person;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface PersonRepository extends MongoRepository<Person, String> {

}
