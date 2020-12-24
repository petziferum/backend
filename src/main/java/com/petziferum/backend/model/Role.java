package com.petziferum.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
public class Role {
  @Id
  private String id;

  private com.petziferum.backend.model.ERole name;

  public Role() {

  }

  public Role(com.petziferum.backend.model.ERole name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public com.petziferum.backend.model.ERole getName() {
    return name;
  }

  public void setName(com.petziferum.backend.model.ERole name) {
    this.name = name;
  }
}
