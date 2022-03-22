package com.cts.knowledgebasesystem.technologyservice.service;

import com.cts.knowledgebasesystem.technologyservice.entities.Technology;
import com.cts.knowledgebasesystem.technologyservice.exceptions.TechNameNotFoundException;
import com.cts.knowledgebasesystem.technologyservice.exceptions.TechnologyException;

import java.util.List;
import java.util.Map;

public interface TechnologyService {

    List<Technology> getAllAvailableTechnologies();
    Technology addListOfTechnologies(Technology techName) throws TechnologyException;
    Technology updateTechnology(Long techId, Technology technology) throws TechNameNotFoundException;
    boolean existsByTechnologyId(Long techId) throws TechnologyException;
}
