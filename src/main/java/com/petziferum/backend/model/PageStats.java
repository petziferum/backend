package com.petziferum.backend.model;

import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "statistics")
public class PageStats {

    @Id
    String id;
    String name;
    String modified;
    Object version;
    private int counter;

    public PageStats(String name, String modified, int counter) {
            this.name = name;
            this.counter = counter;
            this.modified = modified;
    }

    public void increment(){
        counter++;
    }

    public void saveversion(Object versionstring) {
        System.out.println("version" + versionstring);
        version = versionstring;
    }

    public void saveDate() {
        Date heute = new Date();
        System.out.println("heute "+ heute);
        modified = heute.toString();
    }
    public Object getVersion() {
        return version;
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

    public String getmodified() {
        return modified;
    }

    public void setmodified(String modified) {
        this.modified = modified;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
