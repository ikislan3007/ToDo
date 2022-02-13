package com.todo.todo.service;

import com.todo.todo.models.ProjectCreateDTO;
import com.todo.todo.models.ProjectResponseDTO;
import com.todo.todo.models.ProjectUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService {

    ProjectResponseDTO save(ProjectCreateDTO project);

    ProjectResponseDTO get(Long id);

    Page<ProjectResponseDTO> getAll(Pageable pageable);

    ProjectResponseDTO update(ProjectUpdateDTO project);
    public void delete(Long id);
}
