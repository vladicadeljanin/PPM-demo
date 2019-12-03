package com.learning.ppmdemo.controller;

import com.learning.ppmdemo.model.Project;
import com.learning.ppmdemo.service.MapValidationErrorService;
import com.learning.ppmdemo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/project")
public class ProjectController {

    private ProjectService projectService;
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    public ProjectController(ProjectService projectService, MapValidationErrorService mapValidationErrorService) {
        this.projectService = projectService;
        this.mapValidationErrorService = mapValidationErrorService;
    }
    @PostMapping(value = "")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){
        ResponseEntity<?> response = mapValidationErrorService.mapValidationErrorService(result);
        if(response != null) return response;
        Project newProject = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(newProject, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{projectId}")
    public ResponseEntity<Project> findByProjectId(@PathVariable String projectId){
        Project project = projectService.findProjectByIdentifier(projectId);

        return new ResponseEntity<Project>(project, HttpStatus.FOUND);
    }

    @GetMapping(value = "")
    public ResponseEntity<Iterable<Project>> findAllProjects(){
        return new ResponseEntity<Iterable<Project>>(projectService.findAllProjects(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{projectId}")
    public ResponseEntity<String> deleteProject(@PathVariable String projectId){
        return new ResponseEntity<String>(projectService.deleteProject(projectId), HttpStatus.OK);
    }

}
