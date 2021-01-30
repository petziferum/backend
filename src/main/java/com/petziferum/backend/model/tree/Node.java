package com.petziferum.backend.model.tree;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tree")
public class Node {

    private String[] parents;
    private String name;
    private String description;

    public Node(){}
    public Node(String name, String description, String[] parents) {
        this.name = name;
        this.description = description;
        this.parents = parents;
    }

    public String[] getParents() {
        return parents;
    }

    public void setParents(String[] parents) {
        this.parents = parents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
