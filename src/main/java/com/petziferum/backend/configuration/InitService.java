package com.petziferum.backend.configuration;


import com.petziferum.backend.model.*;
import com.petziferum.backend.model.tree.Answer;
import com.petziferum.backend.model.tree.Question;
import com.petziferum.backend.repository.ConstructionRepo;
import com.petziferum.backend.repository.PersonRepository;
import com.petziferum.backend.repository.tree.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class InitService {



    @Autowired
    public PersonRepository prepo;
    @Autowired
    public ConstructionRepo crepo;
    @Autowired
    public NodeRepository noderepo;


        public void clearRepos() {
            noderepo.deleteAll();
            crepo.deleteAll();
            prepo.deleteAll();
        }

        public void answers(){
            String[] belongsto = {"root"};
            Answer a = new Answer("info", "Ich brauche Informationen", "infotext", belongsto ,null,1);
            Answer b = new Answer("reden", "Ich will nur reden", "nur reden", belongsto ,null,1);
            noderepo.save(a);
            noderepo.save(b);
        }
    public void Init() {
        String[] p = {null};
        Question q = new Question("root", "Wie kann ich dir helfen?", "Beginn", p, false);
        noderepo.save(q);
    }

public void initPerson() {
        Skills skill = new Skills();
        skill.setSkillName("Portal");
        skill.setSkillClass("zaubern");
        ArrayList<Skills> list = new ArrayList<>();
        list.add(skill);

        Damage ws = new Damage.Builder("Wasserschaden").withvalue(5).build();
        ArrayList<Damage> damageList = new ArrayList<>();
        damageList.add(ws);

        Person rick = new Person("Rick", "Sanchez", 99, list);


        ConstructionIdentifier ci = new ConstructionIdentifier("Aschheimer Brunnen", "Ein alter dreckiger Brunnen", "200kk39", new Person("Gerhard", "Brunzler", 200, list));
        Building c = new Building("Bauwerk", ci, damageList);

        prepo.save(rick);
        crepo.save(c);




    }
}
