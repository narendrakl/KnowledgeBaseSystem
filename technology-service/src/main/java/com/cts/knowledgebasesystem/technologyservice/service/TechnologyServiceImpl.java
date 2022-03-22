package com.cts.knowledgebasesystem.technologyservice.service;

import com.cts.knowledgebasesystem.technologyservice.entities.Technology;
import com.cts.knowledgebasesystem.technologyservice.exceptions.TechNameNotFoundException;
import com.cts.knowledgebasesystem.technologyservice.exceptions.TechnologyException;
import com.cts.knowledgebasesystem.technologyservice.repos.TechnologyRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TechnologyServiceImpl implements TechnologyService{

    Logger logger = LoggerFactory.getLogger(TechnologyServiceImpl.class);
    @Autowired
    TechnologyRepo techRepo;

    @Override
    public List<Technology> getAllAvailableTechnologies() {
        logger.debug("Inside of getAllAvailableTechnologies :: TechnologyServiceImpl class");
        return techRepo.findAll();
    }

    @Override
    public Technology addListOfTechnologies(Technology techName) throws TechnologyException {
        logger.debug("Inside of addListOfTechnologies :: TechnologyServiceImpl class");
        techName.setTechnologyName(techName.getTechnologyName().toLowerCase());
        return techRepo.save(techName);
    }

    @Override
    public Technology updateTechnology(Long techId, Technology technology) throws TechNameNotFoundException {
        logger.debug("Inside of updateTechnology :: TechnologyServiceImpl class");
        Technology tech = techRepo.findById(techId).orElse(null);
        if(tech == null){
            throw  new TechNameNotFoundException("Technology you are trying to update is not available");
        }
        tech.setTechnologyName(technology.getTechnologyName().toLowerCase());
        return techRepo.save(tech);
    }

    @Override
    public boolean existsByTechnologyId(Long techId) throws TechnologyException {
        return techRepo.existsById(techId);
    }
}
