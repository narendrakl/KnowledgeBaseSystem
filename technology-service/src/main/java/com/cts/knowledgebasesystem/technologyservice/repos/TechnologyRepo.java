package com.cts.knowledgebasesystem.technologyservice.repos;

import com.cts.knowledgebasesystem.technologyservice.entities.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepo extends JpaRepository<Technology, Long> {

}
