package com.cts.knowledgebasesystem.questionservice.controller;

import com.cts.knowledgebasesystem.questionservice.entities.Questions;
import com.cts.knowledgebasesystem.questionservice.exception.TechnologyException;
import com.cts.knowledgebasesystem.questionservice.service.QuestionsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/question")
public class QuestionsApi {

    @Autowired
    QuestionsService questionsService;

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @PostMapping("/addNewQuestion")
    public ResponseEntity<Questions> addNewQuestion(@RequestBody Questions questions) throws TechnologyException {
        logger.info("Inside of addNewQuestion::"+this.getClass().getName());
        Questions newlyAddedQuestion = questionsService.addNewQuestion(questions);
        return new ResponseEntity(newlyAddedQuestion, HttpStatus.CREATED);
    }

    @GetMapping("/getOptions/{qId}")
    public ResponseEntity<Map<String, List<String>>> getListOfOptionsAvailableForQuestion(@PathVariable("qId") Long qId) throws TechnologyException {
        logger.info("Inside of getOptions::"+this.getClass().getName());
        return ResponseEntity.ok(questionsService.getListOfOptionsAvailableForQuestion(qId));
    }

    @GetMapping("/getQuestions/{techId}")
    public ResponseEntity<Map<String, List<String>>> getListOfQuestionsAvailableForTechnology(@PathVariable("techId") Long techId) throws  TechnologyException {
        logger.info("Inside of getQuestions::"+this.getClass().getName());
        return  ResponseEntity.ok(questionsService.getListOfQuestionsAvailableForTechnology(techId));
    }
}
