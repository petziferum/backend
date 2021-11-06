package com.petziferum.backend.model.tree;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;

public class Question {

    @Id
    private String id;
    private String name;
    private String text;
    private ArrayList<String> parents;

    public Question(String name, String text, ArrayList<String> parents) {
        this.name = name;
        this.text = text;
        this.parents = parents;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
