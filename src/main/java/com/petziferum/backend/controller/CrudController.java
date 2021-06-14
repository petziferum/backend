package com.petziferum.backend.controller;

import com.petziferum.backend.model.PersistentEntity;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

public abstract class CrudController<O extends PersistentEntity, R extends CrudRepository<O, String>> {

    @Autowired
    protected R repository;

    @GetMapping("")
    public ResponseEntity<Iterable<O>> getAllObjects() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<O> getObject(@PathVariable String id) {
        Optional<O> object = repository.findById(id);

        if (object.isPresent()) {
            return ResponseEntity.ok(object.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<URI> addObject(@RequestBody O object) {
        String id = object.getId();

        if (id == null || !repository.existsById(id)) {
            repository.save(object);
            return ResponseEntity.created(
                    URI.create("../api" + provideEndpoint() + "/" + id)).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("")
    public ResponseEntity<String> replaceObject(@RequestBody O object) {
        String id = object.getId();

        if (id != null && repository.existsById(id)) {
            repository.save(object);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteAllObjects() {
        repository.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteObject(@PathVariable String id) {
        if (id != null && repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public abstract String provideEndpoint();

}