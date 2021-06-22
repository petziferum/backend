package com.petziferum.backend.repository;

import com.petziferum.backend.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface PersonRepository extends MongoRepository<Person, String> {

    public Person findByFirstName(String firstName);
    public List<Person> findThisFuckingUserByLastName(String lastName); //findBy ist die MongoDB Query und LastName muss ein getter in der Klasse sein Beispiel: find...By... z.B. findTheFuckingUserByFirstName
    public List<Person> findByAge(int age);
    public List<Person> findAll();

//    Page<Person> findById(String personId, Pageable pageable);
}
