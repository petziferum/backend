package com.petziferum.backend.model.tree;

import java.util.List;

public class Answer implements Comparable<Answer>{

    private String text;
    private String name;
    private List<String> competencies;
    private String justify = "end";
    private int index;
    private String type;

    public Answer(String name, String text) {
        this.text = text;
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int compareTo(Answer answer) {
        return Integer.compare(getIndex(), answer.getIndex());
    }
}
