package com.cts.knowledgebasesystem.questionservice.service;

import com.cts.knowledgebasesystem.questionservice.entities.Questions;
import com.cts.knowledgebasesystem.questionservice.exception.TechnologyException;
import com.cts.knowledgebasesystem.questionservice.repo.QuestionsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class QuestionsServiceImpl implements QuestionsService{

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TechnologyClientService techClientService;

    @Autowired
    QuestionsRepo qRepo;


    @Override
    public Questions addNewQuestion(Questions question) throws TechnologyException {
        Long techId = question.getTechId();
        if(!techClientService.existsByTechnologyId(techId)){
            logger.debug("Tech id {} referring to is not available", techId);
            throw new TechnologyException("Tech id referring to is not available");
        }
        return qRepo.saveAndFlush(question);
    }

    @Override
    public Map<String, List<String>> getListOfOptionsAvailableForQuestion(Long qId) throws TechnologyException {
        Map<String, List<String>> response = new HashMap<>();
        response.put("choice",qRepo.getAllOptionsForQuestion(qId));
        return response;
    }

    @Override
    public Map<String, List<String>> getListOfQuestionsAvailableForTechnology(Long techId) throws TechnologyException {
        Map<String, List<String>> response = new HashMap<>();
        response.put("questions",qRepo.getAllQuestionsForTechnology(techId).stream()
                .map(Questions::getQuestionDesc)
                .collect(Collectors.toList()));
        return response;
    }

}
