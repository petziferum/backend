package com.petziferum.backend.controller;

import com.petziferum.backend.model.tree.Node;
import com.petziferum.backend.model.tree.Question;
import com.petziferum.backend.repository.tree.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/tree")
public class TreeController {

    @Autowired
    NodeRepository repository;

    @GetMapping("/root")
    public ResponseEntity<Question> getRoot() {
        Optional<Question> node = repository.findRoot();

        if (node.isPresent()) {
            return ResponseEntity.ok(node.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/addquestion")
    public ResponseEntity addQuestion(@RequestBody Node question) {
        System.out.println(question);
        return ResponseEntity.ok(question);
    }
}
