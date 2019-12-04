package com.learning.ppmdemo.service;

import com.learning.ppmdemo.errorhandling.ProjectIdException;
import com.learning.ppmdemo.model.Project;
import com.learning.ppmdemo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project saveOrUpdateProject(Project project){
        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch (Exception e){
            throw new ProjectIdException("ProjectID '" + project.getProjectIdentifier() + "' already exists");
        }
    }

    public Project findProjectByIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if(project == null){
            throw new ProjectIdException("Project with identifier '" + projectId + "' does not exist.");
        }
        return project;
    }

    public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
    }

    public String deleteProject(String projectId){
        try{
            projectRepository.delete(findProjectByIdentifier(projectId.toUpperCase()));
            return "Project with identifier '" + projectId + "' is deleted.";
        }catch (Exception e){
            throw new ProjectIdException("Project with identifier '" + projectId + "' is not deleted.");
        }
    }
}
