package com.petziferum.backend.controller;

import com.petziferum.backend.model.tree.Answer;
import com.petziferum.backend.model.tree.Question;
import com.petziferum.backend.repository.tree.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tree")
public class TreeController {

    @Autowired
    NodeRepository repository;

    @GetMapping("/root")
    public ResponseEntity<Question> getRoot() {
        Optional<Question> node = repository.findRoot();

        if (node.isPresent()) {
            return ResponseEntity.ok(node.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/nextquestion")
    public ResponseEntity<List<Question>> getNextQuestion(@RequestParam String name){
        List<Question> q = repository.findNextQuestionByParents(name);
        return ResponseEntity.ok(q);
    }

    @GetMapping("/answers")
    public ResponseEntity<List<Answer>> getAnswers(@RequestParam String name) {
            List<Answer> answers = repository.findByParents(name);
            return ResponseEntity.ok(answers);
    }

    @GetMapping("/answers/all")
    public ResponseEntity<List<Answer>> getAnswers() {
        List<Answer> answers = repository.findByType("User");
        return ResponseEntity.ok(answers);

    }
    @GetMapping("/questions/all")
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = repository.findQuestionsByType("System");
        return ResponseEntity.ok(questions);

    }

    @PostMapping("/addquestion")
    public ResponseEntity addQuestion(@RequestBody Question question) {
        System.out.println("/n New Question posted: "+question);
        repository.save(question);
        return ResponseEntity.ok(question);
    }
    @PostMapping("/addanswer")
    public ResponseEntity<Answer> addAnswer(@RequestBody Answer answer){
        System.out.print("/n Neue Antwort: " + answer.getName());
        repository.save(answer);
        return ResponseEntity.ok(answer);
    }
}
