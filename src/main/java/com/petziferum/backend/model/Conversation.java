package com.petziferum.backend.model;

import com.petziferum.backend.model.tree.Answer;
import com.petziferum.backend.model.tree.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class Conversation {

    @Id
    private String Id;
    private String name;
    private String description;
    private ArrayList<Question> questionList = new ArrayList<>();
    private ArrayList<Answer> answerList = new ArrayList<>();




    public void addQuestion(Question question){
        this.questionList.add(question);
    }
    public void addAnswer(Answer answer){
        this.answerList.add(answer);
    }

}
