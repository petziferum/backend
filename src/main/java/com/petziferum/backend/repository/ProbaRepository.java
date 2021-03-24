package com.petziferum.backend.repository;

import com.petziferum.backend.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProbaRepository extends MongoRepository<Role, String> {
}
