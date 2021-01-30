package com.petziferum.backend.configuration;


import com.petziferum.backend.model.tree.Question;
import com.petziferum.backend.repository.ConstructionRepo;
import com.petziferum.backend.repository.PersonRepository;
import com.petziferum.backend.repository.tree.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitService {



    @Autowired
    public PersonRepository prepo;
    @Autowired
    public ConstructionRepo crepo;
    @Autowired
    public NodeRepository noderepo;


        public void clearRepos() {

            crepo.deleteAll();
            prepo.deleteAll();
        }

    public void Init() {
            noderepo.deleteAll();
            String[] p = {null};
            Question q = new Question("erste Frage", "Wie kann ich dir helfen?","Beginn",p,false );
            noderepo.save(q);

/*
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

 */


    }
}
