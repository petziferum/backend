package com.petziferum.backend.repository;

import com.petziferum.backend.model.ERole;
import com.petziferum.backend.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;



public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}
