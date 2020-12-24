package com.petziferum.backend;

import com.petziferum.backend.configuration.InitService;
import com.petziferum.backend.repository.ConstructionRepo;
import com.petziferum.backend.repository.PersonRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title ="Petzi API", version="2.5.1", description = "Petzis API info"))
public class Application implements CommandLineRunner {

    @Autowired
    public PersonRepository repo;

    @Autowired
    public ConstructionRepo crepo;

    @Autowired
    InitService initService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        //initService.Init();


    }
}
