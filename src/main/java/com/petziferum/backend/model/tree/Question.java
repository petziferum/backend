package com.petziferum.backend.model.tree;

public class Question extends Node {

    private boolean scalable;
    private String text;
    public Question() {}

    public Question(String name, String text, String description, String[] parents, boolean scalable) {
        super(name, description, parents);
        this.text = text;
        this.scalable = scalable;
    }

    public boolean isScalable() {
        return scalable;
    }

    public void setScalable(boolean scalable) {
        this.scalable = scalable;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
