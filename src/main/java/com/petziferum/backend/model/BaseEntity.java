package com.petziferum.backend.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public abstract class BaseEntity {

    @Id
    private String Id;
    private String firstName;
    private String lastName;

    public BaseEntity(String firstName, String lastName) {
        Id = ObjectId.get().toHexString();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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
