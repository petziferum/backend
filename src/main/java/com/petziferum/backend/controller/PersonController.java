package com.petziferum.backend.controller;

import com.petziferum.backend.model.Building;
import com.petziferum.backend.model.Person;
import com.petziferum.backend.model.Student;
import com.petziferum.backend.repository.ConstructionRepo;
import com.petziferum.backend.repository.PersonRepository;
import com.petziferum.backend.service.PersonService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = {"http://localhost:8080", "http://localhost:8010"})
@RestController
@RequestMapping("/p")
public class PersonController  {

    @Autowired
    PersonRepository repo;
    @Autowired
    ConstructionRepo crepo;


    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping("/student")
    @ApiResponse(content = @Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))) //Als Rückgabewert wird hier "Student" deklariert, da in der Methode nur "Object" angegeben wurde und das sehr unspezifisch ist.
    public Object neuerStudent(@RequestParam String firstName, String lastName){

        Student student = Student.erstelleStudent(firstName, lastName);
                return  student;
    }

    @GetMapping("/listAllNames")
    public Object controller(){
        return personService.showNames();
    }

    @CrossOrigin(value = {"http://localhost:8080", "http://localhost:8010"})
    @GetMapping("/allitems")
    public ResponseEntity getConstructionItems() {
        List<Building> clist = crepo.findAll();
                return ResponseEntity.ok(clist);
    }

    @PostMapping("/saveConstructionItem")
    public ResponseEntity saveNewConstructionItem(@RequestBody Building building){
        System.out.print(building);
        crepo.save(building);
        return ResponseEntity.ok("Bauwerk gespeichert " + building);
    };

    @GetMapping("/age")
    public ResponseEntity getDepotValue(@RequestParam int age){
        List<Person> ageList = repo.findByAge(age);
        return ResponseEntity.ok(ageList);
    }
    @GetMapping("/lastname")
    public ResponseEntity getPersonByLastName(@RequestParam String lastname){
        List<Person> PersonList = repo.findThisFuckingUserByLastName(lastname);
        return ResponseEntity.ok(PersonList);
    }

    @GetMapping("/persons")
    public ResponseEntity getAllPersons(){
        List<Person> list = repo.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/savePerson")
    public ResponseEntity postPerson(@RequestBody Person person){ //erwartet ein Person Object
        System.out.println(person);
        repo.save(Person.saveNewPerson(person));
        return ResponseEntity.ok("person gespeichert: " + person);
    }
}
