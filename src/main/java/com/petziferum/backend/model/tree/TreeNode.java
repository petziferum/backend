package com.petziferum.backend.model.tree;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "tree")
public class TreeNode {

    @Id
    private String id;
    private List<Answer> answers;
    private List<Question> questions;

    public TreeNode() {}

    public TreeNode addQuestion(Question q) {
        this.questions.add(q);
        return this;
    }

    public TreeNode addAnswer(Answer a) {
        this.answers.add(a);
        return this;
    }

}