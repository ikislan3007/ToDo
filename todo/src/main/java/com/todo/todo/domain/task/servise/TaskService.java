package com.todo.todo.domain.task.servise;

import com.todo.todo.domain.task.models.TaskCreateDTO;
import com.todo.todo.domain.task.models.TaskResponseDTO;
import com.todo.todo.domain.task.models.TaskUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {

    TaskResponseDTO save(TaskCreateDTO task);

    TaskResponseDTO get(Long id);

    Page<TaskResponseDTO> getAll(Pageable pageable);

   TaskResponseDTO update(TaskUpdateDTO task);

    public void delete(Long id);
}