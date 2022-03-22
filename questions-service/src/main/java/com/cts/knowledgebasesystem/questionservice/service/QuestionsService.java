package com.cts.knowledgebasesystem.questionservice.service;

import com.cts.knowledgebasesystem.questionservice.entities.Questions;
import com.cts.knowledgebasesystem.questionservice.exception.TechnologyException;

import java.util.List;
import java.util.Map;

public interface QuestionsService {
    public Questions addNewQuestion(Questions question) throws TechnologyException;
    public Map<String, List<String>> getListOfOptionsAvailableForQuestion(Long qId) throws TechnologyException;
    public Map<String, List<String>> getListOfQuestionsAvailableForTechnology(Long techId) throws TechnologyException;
}
