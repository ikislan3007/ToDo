package com.todo.todo.service;

import com.todo.todo.entity.TaskRequest;
import com.todo.todo.entity.TaskResponse;

import java.util.List;

public interface TaskService {
    TaskResponse save(TaskRequest task);
    TaskResponse get(Long id);

    TaskResponse update(TaskRequest taskRequest, Long id);

    void delete(Long id);

    List<TaskResponse> getAll(int page, int pageSize);
}
