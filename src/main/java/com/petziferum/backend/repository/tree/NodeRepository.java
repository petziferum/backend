package com.petziferum.backend.repository.tree;

import com.petziferum.backend.model.tree.Answer;
import com.petziferum.backend.model.tree.Node;
import com.petziferum.backend.model.tree.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface NodeRepository extends MongoRepository<Node, String> {

    @Query("{ 'id' : root }")
    Optional<Question> findRoot();

    List<Answer> findByType(String type);

    List<Question> findQuestionsByType(String type);

         List<Answer> findByParents(String name);

    List<Question> findNextQuestionByParents(String name);

    @Query("{ '_class' : 'com.petziferum.backend.model.tree.Answer', 'parents' : ?0 }")
    List<Answer> findAnswers(String question);

    @Query("{ '_class' : 'com.petziferum.backend.model.tree.Question', 'parents' : ?0 }")
    Optional<Question> findNextQuestion(String answer);


}
