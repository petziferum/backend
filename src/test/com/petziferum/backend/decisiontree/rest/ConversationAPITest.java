package com.petziferum.backend.decisiontree.rest;

import com.petziferum.backend.decisiontree.Conversation;
import com.petziferum.backend.decisiontree.DecisionTreeController;
import com.petziferum.backend.decisiontree.DecisionTreeRepository;
import com.petziferum.backend.decisiontree.TreeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Slf4j
class ConversationAPITest {

    DecisionTreeController treeController;

    @Autowired
    DecisionTreeRepository treeRepository;

    @Autowired
    TreeService treeService;

    @Test
    void TreeServiceFindetRichtigeAntwort() {
        var mental = Conversation.builder().name("stimmenTest").build();

        log.info("Conversation gefunden " + mental);
        assertEquals("stimmenTest", mental.getName());
    }
}
