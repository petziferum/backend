package com.petziferum.backend.model;

public class Student {
        String firstName;
        String lastName;

        public Student(){};

        public Student(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getLastName(){
            return lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public static Student erstelleStudent(String f, String l){
            String name = f;
            String lastName = l;
            Student peter = new Student(name, lastName);
            return peter;
        }
}





