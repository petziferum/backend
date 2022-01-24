package com.petziferum.backend;

import com.petziferum.backend.repository.ConstructionRepo;
import com.petziferum.backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    public PersonRepository repo;

    @Autowired
    public ConstructionRepo crepo;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // Auch möglich mit fixedDelayString = "PT10M" für alle 10 Minuten
    // Möglichkeit cron = "* * * * *" Sternchenreihenfolge erklärt in https://www.youtube.com/watch?v=92-qLIxv0JA oder https://crontab.guru/
    @Scheduled(initialDelay = 1000L, fixedRate = 500000L) //Zeit zwischen den Ausführungen in ms
    void somJob() {
        System.out.println("Now its: " + new Date());
    }

    @Configuration
    @EnableScheduling // Hier wird Scheduling eingeschaltet
    @ConditionalOnProperty(name = "scheduling.enabled", matchIfMissing = true) // Scheduling wird hier eingestellt
    class SchedulingConfiguration {
    }

    @RequestMapping("/")
    public ModelAndView sayHello(ModelMap model) {
        model.addAttribute("attribute", "redirectWithRedirectPrefix");
        return new ModelAndView("redirect:/swagger-ui.html", model);
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
