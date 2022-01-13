package com.petziferum.backend.decisiontree;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;


@Document("Conversations")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Conversation extends BaseConversation {

    String text;
    String name;
    ArrayList<String> children = new ArrayList<>();
    Type type;

    public void addChildren(String name) {
        this.children.add(name);
    }
}
