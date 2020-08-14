package com.petziferum.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "constructionitems")
public class Building {

    @Id
    private String id;
    private String name;
    private ConstructionIdentifier constructionIdentifier;

    public Building(String name, ConstructionIdentifier constructionIdentifier) {
        this.name = name;
        this.constructionIdentifier = constructionIdentifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ConstructionIdentifier getConstructionIdentifier() {
        return constructionIdentifier;
    }

    public void setConstructionIdentifier(ConstructionIdentifier constructionIdentifier) {
        this.constructionIdentifier = constructionIdentifier;
    }
}
