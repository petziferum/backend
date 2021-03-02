package com.petziferum.backend.controller;

import com.petziferum.backend.service.FbCocktailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class FirebaseController {

    @Autowired
    FbCocktailService fbservice;

    @RequestMapping("/fb/cocktail")
    public Object getCocktail() throws InterruptedException, ExecutionException{
        return fbservice.getCocktail();
    }
}
