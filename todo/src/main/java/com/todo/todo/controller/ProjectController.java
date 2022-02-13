package com.todo.todo.controller;

import com.todo.todo.models.ProjectCreateDTO;
import com.todo.todo.models.ProjectResponseDTO;
import com.todo.todo.models.ProjectUpdateDTO;
import com.todo.todo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/project")
public class ProjectController {
    public ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectResponseDTO> create(@Valid @RequestBody ProjectCreateDTO task) {
        return ResponseEntity.ok(projectService.save(task));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponseDTO> get(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.get(id));
    }

    @GetMapping
    public ResponseEntity<Page<ProjectResponseDTO>> get(Pageable pageable) {
        return ResponseEntity.ok(projectService.getAll(pageable));
    }

    @PutMapping
    public ResponseEntity<ProjectResponseDTO> update(@Valid @RequestBody ProjectUpdateDTO project) {
        return ResponseEntity.ok(projectService.update(project));
    }
    @DeleteMapping("/{id}")
    public void  delete(@PathVariable Long id) {
        projectService.delete(id);
    }


    @Autowired
    public void setTaskService(ProjectService projectService) {
        this.projectService = projectService;
    }




}
