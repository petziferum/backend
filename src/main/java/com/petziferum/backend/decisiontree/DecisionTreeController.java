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


    @PostMapping("/postconversation")
    public ResponseEntity<Conversation> postConversation(@RequestBody Conversation c) {
        dtrepo.save(c);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/tree")
    public ResponseEntity<ArrayList<Conversation>> getConversations(@RequestParam String name) {
        ArrayList<Conversation> cArray = new ArrayList<Conversation>();
        Conversation frage = dtrepo.findConversationByName(name);
        cArray.add(frage);

        System.out.println("size: "+frage.children.size());
        System.out.println("childs: " + frage.children);
        for(int i = 0; i < frage.children.size(); i++) {
            Conversation antwort = dtrepo.findConversationByName(frage.children.get(i));
            System.out.println("i" + i + " antwort: " + antwort);
            if(antwort == null) {
                i++;
            } else cArray.add(antwort);
        }
        System.out.println("cArray: " + cArray);
        return ResponseEntity.ok(cArray);

    }

    @GetMapping("/treestart")
    public ResponseEntity<Conversation> getStart(@RequestParam String name) {
        System.out.println("suche nach "+ name);
        Conversation frage = dtrepo.findConversationByName(name);

        return ResponseEntity.ok(frage);
    }
}
