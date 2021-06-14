package com.petziferum.backend.rest;

import com.petziferum.backend.domain.TheEntity;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = {"http://localhost:8080", "http://localhost:8010"})
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

    @Schema
    public class DtoClass {

        String textAttribute;
        public DtoClass(){};

        public String getTextAttribute() {
            return textAttribute;
        }

        public void setTextAttribute(String textAttribute) {
            this.textAttribute = textAttribute;
        }
    }

    @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TheEntity.class)))
    @PostMapping("/saveentity")
    public ResponseEntity<TheEntity> saveEntity(
            @RequestBody(description = "The Entity Object", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TheEntity.class))) DtoClass theentity
    ){
        if(theentity != null) {
            System.out.println(theentity.getTextAttribute());
            TheEntity te = new TheEntity(theentity.getTextAttribute());
            //erepo.save(te);
            System.out.println("Entity gespeichert: " + theentity.getTextAttribute());
            return new ResponseEntity<TheEntity>(te, HttpStatus.OK);
        } else if( theentity == null){
            return (ResponseEntity<TheEntity>) ResponseEntity.badRequest();
        }

        return new ResponseEntity<TheEntity>(new TheEntity(), HttpStatus.OK);


    }
}
