package com.petziferum.backend.model;

import com.petziferum.backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "persons")
public class Person extends BaseEntity{


    private int age;
    private Skills skills;

    public Person(String firstName, String lastName, int age, Skills skills){
        super(firstName, lastName);
        this.age = age;
        this.skills = skills;
    }

    public int getAge() {
            return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
