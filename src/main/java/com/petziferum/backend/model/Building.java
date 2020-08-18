package com.petziferum.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "constructionitems")
public class Building {

    @Id
    private String id;
    private String name;
    private ConstructionIdentifier constructionIdentifier;
    private ArrayList<Damage> damages;

    public Building(String name, ConstructionIdentifier constructionIdentifier, ArrayList<Damage> damages) {
        this.name = name;
        this.constructionIdentifier = constructionIdentifier;
        this.damages = damages;
    }

    public ArrayList<Damage> getDamages() {
        return damages;
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
