package com.todo.todo.domain.project.service;

import com.todo.todo.domain.project.models.ProjectCreateDTO;
import com.todo.todo.domain.project.models.ProjectResponseDTO;
import com.todo.todo.domain.project.models.ProjectUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService {

    ProjectResponseDTO save(ProjectCreateDTO project);

    ProjectResponseDTO get(Long id);

    Page<ProjectResponseDTO> getAll(Pageable pageable);

    ProjectResponseDTO update(ProjectUpdateDTO project,Long id);

    void delete(Long id);
}
