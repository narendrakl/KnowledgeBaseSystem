package com.cts.knowledgebasesystem.technologyservice.controllers;

import com.cts.knowledgebasesystem.technologyservice.entities.Technology;
import com.cts.knowledgebasesystem.technologyservice.exceptions.TechNameNotFoundException;
import com.cts.knowledgebasesystem.technologyservice.exceptions.TechnologyException;
import com.cts.knowledgebasesystem.technologyservice.service.TechnologyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/technology")
public class TechnologyApi {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    TechnologyService techService;

    @PostMapping("/add")
    public ResponseEntity<Technology> addTechnology(@Valid @RequestBody Technology techName) throws TechnologyException {
        logger.info("Inside of addTechnology::"+this.getClass().getName());
        return new ResponseEntity(techService.addListOfTechnologies(techName), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Technology>> getAvailableTechnologies(){
        logger.info("Inside of getAvailableTechnologies::"+this.getClass().getName());
        return ResponseEntity.ok(techService.getAllAvailableTechnologies());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Technology> updateTechnology(@PathVariable("id") Long techId, @Valid @RequestBody Technology tech) throws TechNameNotFoundException {
        logger.info("Inside of updateTechnology::"+this.getClass().getName());
        return new ResponseEntity(techService.updateTechnology(techId, tech), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{tId}/exists")
    public ResponseEntity<Boolean> existsByTechnologyId(@PathVariable("tId") Long tId) throws TechnologyException {
        return ResponseEntity.ok(techService.existsByTechnologyId(tId));
    }
}
