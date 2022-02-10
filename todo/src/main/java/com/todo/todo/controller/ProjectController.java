package com.todo.todo.controller;

import com.todo.todo.entity.ProjectRequest;
import com.todo.todo.entity.ProjectResponse;
import com.todo.todo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    public ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectResponse> create(@RequestBody ProjectRequest projectRequest) {
        ProjectResponse response = projectService.save(projectRequest);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponse> update(@RequestBody ProjectRequest projectRequest, @PathVariable Long id) {
        ProjectResponse response = projectService.update(projectRequest, id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        projectService.delete(id);
        return ResponseEntity.ok().body("deleted");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> get(@PathVariable Long id) {
        ProjectResponse response = projectService.get(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponse>> getAll(@RequestParam int page, @RequestParam int pageSize) {
        List<ProjectResponse> response = projectService.getAll(page, pageSize);
        return ResponseEntity.ok(response);
    }

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

}
