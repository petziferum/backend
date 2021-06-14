package com.petziferum.backend.domain;

import com.petziferum.backend.model.PersistentEntity;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public abstract class BaseEntity implements PersistentEntity {

    @Id
    private String id;
    private String name;
    private String description;

    public BaseEntity() {
        id = ObjectId.get().toHexString();
    }

    public BaseEntity(String name, String description) {
        id = ObjectId.get().toHexString();
        this.name = name;
        this.description = description;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}