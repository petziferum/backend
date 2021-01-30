package com.petziferum.backend.repository.tree;

import com.petziferum.backend.model.tree.Node;
import com.petziferum.backend.model.tree.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface NodeRepository extends MongoRepository<Node, String> {

    @Query("{ 'parents' : null }")
    Optional<Question> findRoot();
}
