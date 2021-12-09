package com.petziferum.backend.decisiontree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TreeService {

    @Autowired
    DecisionTreeRepository dtrepo;

    public ArrayList<Conversation> findConversation(String name) {
        System.out.println("findConv " + name);
        ArrayList<Conversation> cArray = new ArrayList<Conversation>();
        Conversation frage = dtrepo.findConversationByName(name);
        if(frage != null) {
            System.out.println("frage: "+ frage);
            cArray.add(frage);
        } else {
            System.out.print("Nichts gefunden");
        }
        findAnswers(cArray, frage);

        return cArray;


    }

    private void findAnswers(ArrayList<Conversation> cArray, Conversation frage) {
        for (int i = 0; i < frage.children.size(); i++) {
            Conversation antwort = dtrepo.findConversationByName(frage.children.get(i));
            System.out.println("i" + i + " antwort: " + antwort);
            if (antwort == null) {
                i++;
            } else cArray.add(antwort);
        }
    }
}
