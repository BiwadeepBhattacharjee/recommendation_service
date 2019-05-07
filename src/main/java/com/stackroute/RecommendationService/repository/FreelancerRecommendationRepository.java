package com.stackroute.RecommendationService.repository;

import com.stackroute.RecommendationService.domain.Freelancers;
import com.stackroute.RecommendationService.domain.Projects;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface FreelancerRecommendationRepository extends Neo4jRepository<Freelancers,String> {
    @Query("MATCH (f:Freelancers),(s:Skill) where s.skillName=({skillName}) match(s)<-[:hasSkill]-(f) RETURN f LIMIT 10")
    List<Freelancers> findBySkills(String skillName);
    //The above method gives all freelancers who has the desired skill'
    @Query("CREATE (f:Freelancers{EmailId:({EmailId})})")
    Iterable<Freelancers> saveByEmailId(String EmailId);
}