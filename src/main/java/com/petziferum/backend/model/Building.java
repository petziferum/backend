package com.petziferum.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "constructionitems")
public class Building {

    @Id
    private String id;
    private String name;
    private ConstructionIdentifier constructionIdentifier;
    private Damage damage;

    public Building(String name, ConstructionIdentifier constructionIdentifier, Damage damage) {
        this.name = name;
        this.constructionIdentifier = constructionIdentifier;
        this.damage = damage;
    }

    public Damage getDamage() {
        return damage;
    }

    public void setDamage(Damage damage) {
        this.damage = damage;
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
