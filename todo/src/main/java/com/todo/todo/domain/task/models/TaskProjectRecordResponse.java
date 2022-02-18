package com.todo.todo.domain.task.models;

import com.todo.todo.domain.project.models.ProjectResponseDTO;

public record TaskProjectRecordResponse(Long id,
                                        String name,
                                        String description,
                                        boolean done) {
}
