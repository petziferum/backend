package com.petziferum.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;


@Document(collection = "persons")
public class Person {



    @Id
    private String id;
    private int age;
    private final String firstName;
    private final String lastName;
    private ArrayList<Skills> skills;

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

}
