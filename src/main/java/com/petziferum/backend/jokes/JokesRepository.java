package com.petziferum.backend.jokes;

import com.petziferum.backend.decisiontree.DecisionTreeController;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JokesRepository extends MongoRepository<DecisionTreeController.Joke, String> {
}
