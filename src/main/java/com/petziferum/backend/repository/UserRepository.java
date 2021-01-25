package com.petziferum.backend.repository;

import com.petziferum.backend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
    public User findByFirstName(String firstName);
    public List<User> findByLastName(String lastName); //findBy ist die MongoDB Query und LastName muss ein getter in der Klasse sein
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
