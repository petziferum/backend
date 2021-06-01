package com.petziferum.backend.rest;

import com.petziferum.backend.domain.TheEntity;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entity")
public class TheEntityController {

    @Autowired
    TheEntityRepository erepo;


    @ApiResponses(
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = TheEntity.class)))
            )
    @GetMapping("/getentity")
    public ResponseEntity getEntity() {
        List<TheEntity> entityList = erepo.findAll();
        return ResponseEntity.ok(entityList);
    }
}
