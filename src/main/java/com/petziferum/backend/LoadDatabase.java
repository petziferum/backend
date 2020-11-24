package com.petziferum.backend;

import com.petziferum.backend.model.Employee;
import com.petziferum.backend.repository.EmployeeRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.logging.Logger;


public class LoadDatabase {

    private static final Logger log = (Logger) LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
            System.out.println("Bean wurde geladen!");
        return args -> {
            log.info("Preloading " + repository.save(new Employee("Bilbo Baggins", "burglar")));
            log.info("Preloading " + repository.save(new Employee("Frodo Baggins", "thief")));
        };
    }


}
