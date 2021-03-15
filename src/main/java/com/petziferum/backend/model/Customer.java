package com.petziferum.backend.model;

import nonapi.io.github.classgraph.json.Id;

public class Customer {

    @Id String id;
    String customerNumber;
    String firstName;
    String lastName;

    static int userNumber;

    public Customer (String firstName, String lastName){

        this.firstName = firstName;
        this.lastName = lastName;

    }

    public void generateNumber(){

        userNumber++;
        System.out.println("Nummber: "+ userNumber);
        System.out.println("Wir haben jetzt " + userNumber + " Kunden.");

        this.customerNumber = String.format("%08d", userNumber);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
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
