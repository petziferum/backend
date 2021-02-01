package com.petziferum.backend.model.tree;

import java.util.List;

public class Answer extends Node implements Comparable<Answer>{

    private String text;
    private List<String> competencies;
    private String justify = "end";
    private int index;
    private String type;

    public Answer(String name, String text, String description, String[] parents,
                  List<String> competencies, int index) {
        super(name, description, parents);

        this.type ="User";
        this.competencies = competencies;
        this.text = text;
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getCompetencies() {
        return competencies;
    }

    public void setCompetencies(List<String> competencies) {
        this.competencies = competencies;
    }

    public String getJustify() {
        return justify;
    }

    public void setJustify(String justify) {
        this.justify = justify;
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
