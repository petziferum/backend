package com.petziferum.backend.decisiontree;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface DecisionTreeRepository extends MongoRepository<Conversation, String> {

    Conversation findConversationByName(String name);

    ArrayList<Conversation> getConversationByTypeEqualsAndNameContains(Type type, String name);
}
