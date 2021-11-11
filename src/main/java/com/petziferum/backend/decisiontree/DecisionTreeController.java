package com.petziferum.backend.decisiontree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*")
@RestController
public class DecisionTreeController {

    @Autowired
    DecisionTreeRepository dtrepo;

    @Autowired
    private TreeService treeService;


    @PostMapping("/postconversation")
    public ResponseEntity<Conversation> postConversation(@RequestBody Conversation c) {
        dtrepo.save(c);
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
}
