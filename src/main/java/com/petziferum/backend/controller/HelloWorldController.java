package com.petziferum.backend.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

@RestController
public class HelloWorldController implements WebMvcConfigurer {

    @RequestMapping("/")
    public ModelAndView sayHello(ModelMap model) {
        //return "<h1>Hallo Petzi</h1><p>Hier gehts zu <a href='http://localhost:8010/swagger-ui.html'>Swagger-ui</a><br>" +
        //        "und hier wird ein Service ausgeführt.";
        //return "redirect:/swagger-ui/";

        // Automatische Weiterleitung durch ModelAndView möglich. Hier wird vom Pfad "/" auf den Pfad "/swagger-ui.html" weitergeleitet.

        model.addAttribute("attribute", "redirectWithRedirectPrefix");
        return new ModelAndView("redirect:/swagger-ui.html", model);
    }

    public void configurePathMatch(PathMatchConfigurer configurer){
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setUrlDecode(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }
}
