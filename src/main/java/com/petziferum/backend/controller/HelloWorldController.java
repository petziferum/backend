package com.petziferum.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String sayHello() {
        return "<h1>Hallo Petzi</h1><p>Hier gehts zu <a href='http://localhost:8010/swagger-ui.html'>Swagger-ui</a>";
    }
}
