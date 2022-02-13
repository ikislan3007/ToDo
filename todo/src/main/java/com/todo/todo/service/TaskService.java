package com.todo.todo.service;

import com.todo.todo.models.TaskCreateDTO;
import com.todo.todo.models.TaskResponseDTO;
import com.todo.todo.models.TaskUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {

    TaskResponseDTO save(TaskCreateDTO task);

    TaskResponseDTO get(Long id);

    Page<TaskResponseDTO> getAll(Pageable pageable);

   TaskResponseDTO update(TaskUpdateDTO task);

    public void delete(Long id);
}