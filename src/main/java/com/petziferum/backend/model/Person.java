package com.petziferum.backend.model;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;


@Document(collection = "persons")
public class Person {



    @Id
    private String id;
    private int age;
    private String firstName;
    private String lastName;
    private ArrayList<Skills> skills;

    public Person() {
    }

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, int age, ArrayList<Skills> skills){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.skills = skills;
    }
    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public ArrayList<Skills> getSkills() {
        return skills;
    }
    public void setSkills(ArrayList s){
        this.skills = s;
    }

    public int getAge() {
            return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static Person saveNewPerson(Person person){
        return new Person(person.firstName, person.lastName, person.age, person.skills);
    }
    public void addSkill(Skills skills) {
        this.skills.add(skills);
    }

    public Person(@Autowired ModelMapper mapper, final Person bw) { mapper.map(bw, this); }

}
