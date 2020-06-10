package com.petziferum.backend.model;

import com.petziferum.backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "persons")
public class Person {

    @Id private String id;
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age){
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }
    static Person createNewPerson (Person person) {
        return new Person(
        person.firstName, person.lastName, person.age
        );
    }

    public int getAge() {
            return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
