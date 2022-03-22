package com.cts.knowledgebasesystem.questionservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="technology-service", url="http://localhost:9100")
public interface TechnologyClientService {

    @GetMapping("/technology/{tId}/exists")
    boolean existsByTechnologyId(@PathVariable("tId") Long tId);
}
