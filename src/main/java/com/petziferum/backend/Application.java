package com.petziferum.backend;

import com.petziferum.backend.repository.ConstructionRepo;
import com.petziferum.backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    public PersonRepository repo;

    @Autowired
    public ConstructionRepo crepo;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*
        initService.clearRepos();
        initService.answers();
        initService.Init();
        initService.initPerson();
        */
    }
}
