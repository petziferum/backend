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

    @PostMapping("/setcounter")
    public ResponseEntity setCounter(@RequestBody PageStats pagestats){
        System.out.println(pagestats);
        statsrepo.save(pagestats);
        return ResponseEntity.ok("Neuer Counter gespeichert: " + pagestats);
    }

    @GetMapping("/")
    public ResponseEntity getCounter(){
        PageStats counter = statsrepo.findByName("counter");
        counter.increment();
        counter.saveDate();
        statsrepo.save(counter);
        return ResponseEntity.ok(counter);
    }
}
