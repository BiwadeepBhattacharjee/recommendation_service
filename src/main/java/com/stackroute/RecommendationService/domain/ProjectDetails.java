package com.stackroute.RecommendationService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDetails {

@Id
//    private String projectId;
    private String projectId= UUID.randomUUID().toString();
    private String projectOwnerEmailId;
    private String projectName;
    private String projectStatus;
    private List<BidOfFreelancer> allBidsOfFreelancers;
    private String projectCompletionDate;
    private String projectPreference;
    private String projectLocation;
    private String projectDescription;
    private List<BidSpecsProvidedByProjectOwner> bidSpecsProvidedByProjectOwners=new ArrayList<>();
    private List<String> skillsSetList=new ArrayList<>();

}
