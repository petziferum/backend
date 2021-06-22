package com.petziferum.backend.controller;

import com.petziferum.backend.model.Conversation;
import com.petziferum.backend.model.tree.Answer;
import com.petziferum.backend.model.tree.Node;
import com.petziferum.backend.model.tree.Question;
import com.petziferum.backend.repository.tree.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tree")
public class TreeController extends CrudController<Node, NodeRepository> {

    @Autowired
    NodeRepository repository;

    @GetMapping("/conversation")
    public Conversation getConversation(@RequestParam String name){
        Conversation node = new Conversation();
        node.setName(name);
        //Question quest = new Question("frage","eine Frage", "erste Frage", null, false);
        List<Question> root = repository.findNextQuestion(name);
        Question q = root.get(0);
        System.out.println(q);
        //List<Answer> answer = repository.findByParents(q.getId());
        //Answer ans = new Answer("Antwort", "Die Antwort", "Antwort auf die erste Frage", null, null, 1);

        node.addQuestion(root.get(0));

        return node;
    }

    @GetMapping("/session")
    public String process(Model model, HttpSession session) {
        @SuppressWarnings("unchecked")
        List<String> messages = (List<String>) session.getAttribute("MY_SESSION_MESSAGES");

        if (messages == null) {
            messages = new ArrayList<>();
        }
        model.addAttribute("sessionMessages", messages);
        System.out.println(model + " " +  messages);

        return "index";
    }

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
    @GetMapping("/answers/{id}")
    public ResponseEntity<Iterable<Answer>> getAnswersById(@PathVariable String id) {
        if (repository.existsById(id)) {
            List<Answer> answers = repository.findAnswers(id);
            Collections.sort(answers);
            return ResponseEntity.ok(answers);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/question/{id}")
    public ResponseEntity<List> getNextQuestionById(@PathVariable String id) {
        if (repository.existsById(id)) {
            List<Question> question = repository.findNextQuestion(id);

            return ResponseEntity.ok(question);
            //return ResponseEntity.ok(question.isPresent() ? question.get() : new TreeEnd());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public String provideEndpoint() {
        return "/tree";
    }
}
