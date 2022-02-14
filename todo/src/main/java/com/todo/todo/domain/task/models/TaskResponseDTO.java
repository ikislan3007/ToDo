package com.todo.todo.domain.task.models;

import com.todo.todo.domain.project.models.ProjectResponseDTO;

public record TaskResponseDTO (
        Long id,
        String name,
        String description,
        ProjectResponseDTO project,
        boolean done
) {}


