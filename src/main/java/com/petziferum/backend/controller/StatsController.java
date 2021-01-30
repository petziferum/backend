package com.petziferum.backend.controller;


import com.petziferum.backend.model.PageStats;
import com.petziferum.backend.repository.StatsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/stats")
public class StatsController {

    @Autowired
    StatsRepo statsrepo;

    @PostMapping("/setstats")
    public ResponseEntity setCounter(@RequestBody Object version){
        PageStats counter = statsrepo.findByName("counter");
        counter.saveversion(version);
        counter.increment();
        counter.saveDate();
        System.out.println("neuer Counter " +counter.getVersion() +" " + counter.getCounter());
        statsrepo.save(counter);
        return ResponseEntity.ok(counter);
    }

    @GetMapping("/")
    public ResponseEntity getCounter(){
        PageStats counter = statsrepo.findByName("counter");

        statsrepo.save(counter);
        return ResponseEntity.ok(counter);
    }
}
