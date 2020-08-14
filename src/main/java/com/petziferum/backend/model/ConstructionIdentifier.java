package com.petziferum.backend.model;


import org.springframework.data.annotation.Id;

public class ConstructionIdentifier {

    @Id
    private String id;
    private final String name;
    private final String description;
    private final String constructionNumber;
    private final Person owner;

    public ConstructionIdentifier(String name, String description, String constructionNumber, Person owner) {
        this.name = name;
        this.description = description;
        this.constructionNumber = constructionNumber;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getConstructionNumber() {
        return constructionNumber;
    }

    public Person getOwner() {
        return owner;
    }
}
