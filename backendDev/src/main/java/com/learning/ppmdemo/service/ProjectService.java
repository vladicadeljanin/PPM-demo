package com.learning.ppmdemo.service;

import com.learning.ppmdemo.model.Project;
import com.learning.ppmdemo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project saveOrUpdateProject(Project project){
        return projectRepository.save(project);
    }

}
