package com.petziferum.backend.model;

import org.springframework.data.annotation.Id;

public class Damage {

    @Id
    private String id;
    private String text;
    private int value;



    public static class Builder {
        private String text;
        private int value;

        public Builder(String text) {
            this.text = text;
        }
        public Builder withvalue(int value) {
            this.value = value;
            return this;
        }
        public Damage build() {
            Damage damage = new Damage();
            damage.text = this.text;
            damage.value = this.value;

            return damage;

        }
    }

    private Damage(){};

    public String gettext() {
        return text;
    }

    public int getvalue() {
        return value;
    }
}
