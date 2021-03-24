package com.petziferum.backend.controller;

import com.petziferum.backend.model.ERole;
import com.petziferum.backend.model.Role;
import com.petziferum.backend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/role")
public class ProbaController {


    @Autowired
    RoleRepository probarepo;

    @PostMapping("/mod")
    public ResponseEntity<String> addRole(){
        System.out.println("Role 'MOD' added");

        Role newR = new Role(ERole.ROLE_MOD);
        probarepo.save(newR);
        return ResponseEntity.ok("Role added: " + newR.getName());
    }

    @GetMapping("/get")
    public ResponseEntity<List<Role>> getAllRoles(){
        List<Role> lr = probarepo.findAll();
        return ResponseEntity.ok(lr);
    }
}
