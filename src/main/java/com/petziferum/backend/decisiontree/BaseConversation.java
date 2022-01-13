package com.petziferum.backend.decisiontree;


import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public class BaseConversation {

    @Id
    private String id;
}
