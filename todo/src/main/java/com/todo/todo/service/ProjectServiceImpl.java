package com.todo.todo.service;

import com.todo.todo.entity.*;
import com.todo.todo.exception.ProjectNotFoundException;
import com.todo.todo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    @Override
    public ProjectResponse save(ProjectRequest projectRequest) {
        Project project = mapToSave(projectRequest);
        Project savedProject = projectRepository.save(project);
        ProjectResponse response = mapToResponse(savedProject);
        return response;
    }

    @Override
    public ProjectResponse get(Long id) {
        Project task = projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException(id));
        ProjectResponse response = mapToResponse(task);
        return response;
    }

    @Override
    public ProjectResponse update(ProjectRequest projectRequest, Long id) {
        Project project = mapToSave(projectRequest);
        project.setId(id);
        Project savedProject = projectRepository.save(project);
        ProjectResponse response = mapToResponse(savedProject);
        return response;
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    @Autowired
    public void setProjectRepo(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    private Project mapToSave(ProjectRequest projectRequest) {
        Project result = new Project();
        result.setName(projectRequest.getName());
        return result;
    }

    private ProjectResponse mapToResponse(Project savedProject) {
        ProjectResponse result = new ProjectResponse();
        result.setId(savedProject.getId());
        result.setName(savedProject.getName());
        return result;
    }

    @Override
    public List<ProjectResponse> getAll(int page, int pageSize) {
        if (page != 0 && pageSize != 0) {
            Pageable pageAndElements = PageRequest.of(page, pageSize);
            return projectRepository.findAll(pageAndElements).stream().map((Project project) ->  mapToResponse(project)).toList();
        }
        return projectRepository.findAll().stream().map((Project project) ->  mapToResponse(project)).toList();
    }
}
