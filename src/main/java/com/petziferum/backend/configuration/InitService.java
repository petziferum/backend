package com.petziferum.backend.configuration;


import com.petziferum.backend.model.*;
import com.petziferum.backend.repository.ConstructionRepo;
import com.petziferum.backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class InitService {



    @Autowired
    public PersonRepository prepo;
    @Autowired
    public ConstructionRepo crepo;

        public void clearRepos() {

            crepo.deleteAll();
            prepo.deleteAll();
        }

    public void Init() {


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
