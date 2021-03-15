package com.petziferum.backend.repository;

import com.petziferum.backend.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface ShopRepo extends MongoRepository<Product, String> {

    public ArrayList<Product> findAll();
}
