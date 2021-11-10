package com.petziferum.backend.decisiontree;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DecisionTreeRepository extends MongoRepository<Conversation, String> {

    Conversation findConversationByName(String name);
}
