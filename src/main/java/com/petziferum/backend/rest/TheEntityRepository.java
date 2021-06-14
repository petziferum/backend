package com.petziferum.backend.rest;

import com.petziferum.backend.domain.TheEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheEntityRepository extends MongoRepository<TheEntity, String> {



}
