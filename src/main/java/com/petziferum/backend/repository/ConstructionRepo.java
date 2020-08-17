package com.petziferum.backend.repository;

import com.petziferum.backend.model.Building;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConstructionRepo extends MongoRepository<Building, String> {

    List<Building> findAll();


}
