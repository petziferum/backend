package com.petziferum.backend.decisiontree;

import com.petziferum.backend.jokes.JokesRepository;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
public class DecisionTreeController {


    @Autowired
    DecisionTreeRepository dtrepo;

    @Autowired
    private TreeService treeService;

    @Autowired
    private JokesRepository jokeRepo;

    @Data
    @Document(collection = "jokes")
    public class Joke {
        @Id
        String id;
        String text;

    }

    //Diese Methode Ruft die Jokeapi auf und speichert den Witz in einer "Joke" Klasse im Attribut text
    //andere formen sind auf der Api Seite auch noch möglich
    //Dann wird die "postJoke" Methode aufgerufen mit der der Joke in der eigenen Datenbank gespeichert wird.
    @Scheduled(initialDelay = 1000, fixedRate = 30000L)
    void info() {
        String chuckUrl = "https://v2.jokeapi.dev/joke/Any?format=txt";
        RestTemplate rest = new RestTemplate();
        String jokes = rest.getForObject(chuckUrl, String.class);
        Joke newJoke = new Joke();
        newJoke.text = jokes;
        log.info(newJoke.text);
        //postJoke(newJoke);

    }

    @PostMapping
    public void postJoke(@RequestBody Joke j) {
        jokeRepo.save(j);
        System.out.println("Joke gespeichert: " + j.text);
    }

    @PostMapping("/postconversation")
    public ResponseEntity<Conversation> postConversation(@RequestBody Conversation c) {
        Conversation con = Conversation.builder().children(c.children).name(c.name)
                .text(c.text)
                .type(c.type)
                .build();
        dtrepo.save(con);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/tree")
    public ResponseEntity<ArrayList<Conversation>> getConversations(@RequestParam String name) {
        ArrayList<Conversation> cArray;
        cArray = treeService.findConversation(name);
        return ResponseEntity.ok(cArray);

    }

    @GetMapping("/treestart")
    public ResponseEntity<Conversation> getStart(@RequestParam String name) {
        System.out.println("suche nach "+ name);
        Conversation frage = dtrepo.findConversationByName(name);

        return ResponseEntity.ok(frage);
    }

    @ApiResponse(description = "Gibt eine Frage oder Antwort zurück")
    @GetMapping("/frageByName/{name}")
    public ResponseEntity<Conversation> getFrageByName(@PathVariable("name") String name) {
        final Conversation frageFound = dtrepo.findConversationByName(name);

        return new ResponseEntity<>(frageFound, HttpStatus.FOUND);
    }
}
