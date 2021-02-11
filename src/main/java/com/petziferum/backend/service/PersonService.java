package com.petziferum.backend.service;

import com.petziferum.backend.model.Person;
import com.petziferum.backend.model.Skills;
import com.petziferum.backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository pr;

    public class NameList {
        List<Object> namen;
        int length;

        public void setLength(int length) {
            this.length = length;
        }

        public int getLength() {
            return length;
        }
         public void addNamen(String firstName, String lastName){
            String vollerName = firstName + ", " + lastName;
            this.namen.add(vollerName);
         }
    }

    public Object showNames(){
        List<Person> pl = pr.findAll();
        System.out.print("pl: " + pl);
        NameList n = new NameList();
        for(Person name : pl){
          n.addNamen(name.getFirstName(),name.getLastName());
        }
        n.setLength(n.length);
        return n;
    }
    public Person createPerson() {
        System.out.print("neue Person anlegen");
        Person p1 = new Person("Luke", "Skywalker");
        p1.setSkills(setSkillList("Klettern", "Headbangen","Stinken"));
        return p1;
    }

    public ArrayList setSkillList(String... args){
        ArrayList<Skills> sl = new ArrayList<>();
        for(String arg : args){
            Skills s = new Skills();
            s.setSkillName(arg);
            s.setSkillClass("Skill");
            sl.add(s);
        }
        System.out.print("Skills: " + sl);
        return sl;
    }

}
