package com.petziferum.backend.model;

import ch.qos.logback.core.status.Status;
import nonapi.io.github.classgraph.json.Id;

import java.util.Objects;

public class Order {

    @Id String id;
    private String description;
    private Status status;

    Order(){}

    Order(String description, Status status){
        this.description = description;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(!(o instanceof Order)){
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(this.id, order.id) && Objects.equals(this.description, order.description) && this.status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.description, this.status);
    }
    @Override
    public String toString(){
        return "Order(" + "id= " + this.id + ", description= " + this.description + ", status= " + this.status + ")";
    }
}
