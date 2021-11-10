package com.petziferum.backend.decisiontree;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;


@Document("Conversations")
public class Conversation {

    @Id
    String id;
    String name;
    String text;
    ArrayList<String> children = new ArrayList<>();
    Type type;

    public Conversation(String name, String text, Type type) {
        this.name = name;
        this.text = text;
        this.type = type;
    }

    public void addChildren(String name) {
        this.children.add(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<String> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<String> children) {
        this.children = children;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
