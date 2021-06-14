package com.petziferum.backend.model.tree;

import com.petziferum.backend.domain.BaseEntity;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tree")
public class Node extends BaseEntity {

    private String[] parents;

    public Node() {}

    public Node(String name, String description, String[] parents) {
        super(name, description);
        this.parents = parents;
    }

    public String[] getParents() {
        return parents;
    }

    public void setParents(String[] parents) {
        this.parents = parents;
    }

}