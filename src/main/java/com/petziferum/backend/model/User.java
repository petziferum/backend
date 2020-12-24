package com.petziferum.backend.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Document(collection = "users")
public class User {

  @Id
  private String id;

  @NotBlank
  @Size(max = 20)
  private String username; // Fehlt noch im frontend

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 30)
  private String firstName;

  @NotBlank
  @Size(max = 30)
  private String lastName;

  @NotBlank
  @Size(max = 40)
  private String userDepartment; // Referat

  @NotBlank
  @Size(max = 40)
  private String userOffice; // Abteilung

  private String userImage; // Avatar

  @NotBlank
  @Size(min = 12, max = 120)
  private String password;

  private boolean darkMode;


  private List<String> joinedProjects;
  private List<String> ownProjects;


  @DBRef
  private Set<Role> roles = new HashSet<>();
 // private PictureService pictureService;


  public User(String username, String email, String firstName, String lastName, String userDepartment,
              String userOffice, String userImage, String password) {
    this.username = username;
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.userDepartment = userDepartment;
    this.userOffice = userOffice;
    this.userImage = userImage;
    this.password = password;
  }


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
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

  public String getUserDepartment() {
    return userDepartment;
  }

  public void setUserDepartment(String userDepartment) {
    this.userDepartment = userDepartment;
  }

  public String getUserOffice() {
    return userOffice;
  }

  public void setUserOffice(String userOffice) {
    this.userOffice = userOffice;
  }

  public String getUserImage() {
      return userImage;
  }

  public void setUserImage(String userImage) {
    this.userImage = userImage;
  }

  public List<String> getJoinedProjects() {    return joinedProjects;  }

  public void setJoinedProjects(List<String> joinedProjects) {    this.joinedProjects = joinedProjects;  }

  public List<String> getOwnProjects() {
    return ownProjects;
  }

  public void setOwnProjects(List<String> ownProjects) {
    this.ownProjects = ownProjects;
  }

  public boolean isDarkMode() {
    return darkMode;
  }

  public void setDarkMode(boolean darkMode) {
    this.darkMode = darkMode;
  }
}
