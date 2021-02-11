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

        public static Student erstelleStudent(){
            Student peter = new Student("Peter", "Lustig");
            return peter;
        }
}





