package com.petziferum.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;



@Document("Employee")
public class Employee {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String role;

    Employee() {}

    public Employee(String firstName, String role) {

        this.firstName = firstName;
        this.role = role;
    }

    public String getId() {
        return this.id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getfirstName() {
        return this.firstName;
    }

    public String getRole() {
        return this.role;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Employee))
            return false;
        Employee employee = (Employee) o;
        return Objects.equals(this.id, employee.id) && Objects.equals(this.firstName, employee.firstName)
                && Objects.equals(this.role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.firstName, this.role);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + ", firstName='" + this.firstName + '\'' + ", role='" + this.role + '\'' + '}';
    }
}