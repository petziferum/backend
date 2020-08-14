package com.petziferum.backend.model;

import org.springframework.data.annotation.Id;

public class Damage {

    @Id
    private String id;
    private String name;
    private int level;



    public static class Builder {
        private String name;
        private int level;

        public Builder(String name) {
            this.name = name;
        }
        public Builder withLevel(int level) {
            return this;
        }
        public Damage build() {
            Damage damage = new Damage();
            damage.name = this.name;
            damage.level = this.level;

            return damage;

        }
    }

    private Damage(){};

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }
}
