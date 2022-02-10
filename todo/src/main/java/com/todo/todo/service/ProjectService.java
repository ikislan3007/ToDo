package com.todo.todo.service;

import com.todo.todo.entity.ProjectRequest;
import com.todo.todo.entity.ProjectResponse;

import java.util.List;

public interface ProjectService {
    ProjectResponse save(ProjectRequest projectRequest);
    ProjectResponse get(Long id);
    ProjectResponse update(ProjectRequest projectRequest, Long id);
    void delete(Long id);

    List<ProjectResponse> getAll(int page, int pageSize);
}
