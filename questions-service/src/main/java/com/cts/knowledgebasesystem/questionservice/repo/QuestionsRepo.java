package com.cts.knowledgebasesystem.questionservice.repo;

import com.cts.knowledgebasesystem.questionservice.entities.Options;
import com.cts.knowledgebasesystem.questionservice.entities.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface QuestionsRepo extends JpaRepository<Questions, Long> {

    @Query("SELECT p.choice from Options p where p.questions.qId = :qId")
    List<String> getAllOptionsForQuestion(Long qId);

    @Query("SELECT q from Questions q where q.techId = :techId")
    List<Questions> getAllQuestionsForTechnology(Long techId);
}
