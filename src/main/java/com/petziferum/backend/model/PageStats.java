package com.petziferum.backend.model;

import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "statistics")
public class PageStats {

    @Id
    String id;
    String name;
    String lastedited;
    private int counter;

    public PageStats(String name, String lastedited, int counter) {
            this.name = name;
            this.counter = counter;
            this.lastedited = lastedited;
    }

    public void increment(){
        counter++;
    }

    public void decrement() {
        counter--;
    }

    public void saveDate() {
        Date heute = new Date();
        System.out.println("heute "+ heute);
        lastedited = heute.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getLastedited() {
        return lastedited;
    }

    public void setLastedited(String lastedited) {
        this.lastedited = lastedited;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
