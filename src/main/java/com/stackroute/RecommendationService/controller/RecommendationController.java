package com.stackroute.RecommendationService.controller;


import com.stackroute.RecommendationService.domain.Freelancers;
import com.stackroute.RecommendationService.domain.Projects;
import com.stackroute.RecommendationService.service.FreelancerService;
import com.stackroute.RecommendationService.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RecommendationController {
    private FreelancerService freelancerService;
    private ProjectService projectService;

    @Autowired
    public RecommendationController(FreelancerService freelancerService, ProjectService projectService) {
        this.freelancerService = freelancerService;
        this.projectService = projectService;
    }



//The below method is used to retrieve all freelancers with a particular skill
//    @GetMapping("/recommendations/allfreelancer/Skill/{skillName}")
//    public ResponseEntity<Iterable<Freelancers>> getAllFreelancers(@PathVariable String skillName) {
//        Iterable<Freelancers> freelancers = freelancerService.getAllFreelancers(skillName);
//        return new ResponseEntity<>(freelancers, HttpStatus.OK);
//    }



//The below method is used to retrieve all projects with a particular skill
//@GetMapping("/recommendations/allfreelancer/Skill/{skillName}")
//public ResponseEntity<Iterable<Projects>> getAllProjects(@PathVariable String skillName) {
//    Iterable<Projects> projects = projectService.getAllProjects(skillName);
//    return new ResponseEntity<>(projects, HttpStatus.OK);
//}


    @GetMapping("/recommendations/allfreelancer/Skill/{skillName}")
    public ResponseEntity<Iterable<Freelancers>> getAllFreelancers(@PathVariable List<String> skillName) {
        List<Freelancers> freelancers=new ArrayList<>();
        for (String param:skillName) {
            freelancers.addAll(freelancerService.getAllFreelancers(param));
        }
        return new ResponseEntity<>(freelancers, HttpStatus.OK);
    }

    @GetMapping("/recommendations/allProjects/Skill/{skillName}")
    public ResponseEntity<Iterable<Projects>> getAllProjects(@PathVariable List<String> skillName) {
        List<Projects> projects= new ArrayList<>() ;
        for (String param : skillName) {
            System.out.println(param);
            projects.addAll(projectService.getAllProjects(param));
        }

        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

@PostMapping("/addProject/fromService")
    public ResponseEntity<?> receiveFromProjectDetails(@RequestBody String message){
    System.out.println(message);
    return new ResponseEntity<>("String received", HttpStatus.OK);
}
}
