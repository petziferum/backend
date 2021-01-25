package com.petziferum.backend.repository;


import com.petziferum.backend.model.PageStats;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StatsRepo extends MongoRepository<PageStats, String> {
    PageStats findByName(String name);
    List<PageStats> findAll();
}
