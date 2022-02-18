package com.todo.todo.domain.project.models;

import com.todo.todo.domain.task.entity.Task;
import com.todo.todo.domain.task.models.TaskProjectRecordResponse;
import com.todo.todo.domain.task.models.TaskResponseDTO;

import java.util.List;

public record ProjectResponseDTO(Long id,
                                 String name,
                                 List<TaskProjectRecordResponse> tasksList) { }
