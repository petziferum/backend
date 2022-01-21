package com.petziferum.backend.decisiontree;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class ConversationTest {



    @Test
    void getText() {
        var text = "Das ist ein Test";
        var conversation = new Conversation();
        conversation.text = text;
        log.info("Teste Conversation");
        log.info("{}", conversation);
        assertEquals(text, conversation.text);
    }

    @Test
    void getName() {
    }

    @Test
    void getType() {
    }

    @Test
    void setType() {
    }
}