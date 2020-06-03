package com.petziferum.backend;

import com.petziferum.backend.model.Person;
import com.petziferum.backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private PersonRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        /*repo.deleteAll();

        repo.save(new Person("Rick", "Sanchez"));
        repo.save(new Person("Morty", "Smith"));
        repo.save(new Person("Jerry", "Smith"));
*/
    }
}
