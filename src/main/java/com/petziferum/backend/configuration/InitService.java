package com.petziferum.backend.configuration;


import com.petziferum.backend.model.*;
import com.petziferum.backend.repository.ConstructionRepo;
import com.petziferum.backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

       prepo.deleteAll();

        Skills skill = new Skills();
        skill.setSkillName("Portal");
        skill.setSkillClass("zaubern");

        Damage ws = new Damage.Builder("Wasserschaden").withvalue(5).build();

        prepo.save(new Person("Rick", "Sanchez", 100, skill));

        ConstructionIdentifier ci = new ConstructionIdentifier("Aschheimer Brunnen", "Ein alter dreckiger Brunnen", "200kk39", new Person("Gerhard", "Brunzler", 200, skill));
        Building c = new Building("Bauwerk", ci, ws);

        crepo.save(c);

    }
}