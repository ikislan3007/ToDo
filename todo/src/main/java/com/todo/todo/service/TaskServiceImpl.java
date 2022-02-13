package com.todo.todo.service;

import com.todo.todo.entity.Task;
import com.todo.todo.exception.TaskNotFoundException;
import com.todo.todo.mapper.TaskMapper;
import com.todo.todo.models.TaskCreateDTO;
import com.todo.todo.models.TaskResponseDTO;
import com.todo.todo.models.TaskUpdateDTO;
import com.todo.todo.repository.ProjectRepository;
import com.todo.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepo;
    private TaskMapper taskMapper;
    private ProjectRepository projectRepository;

    @Override
    public TaskResponseDTO save(TaskCreateDTO task) {

        Task newTask = taskRepo.save(taskMapper.map(task));
        return taskMapper.map(newTask);
    }



    @Autowired
    public void setTaskRepo(TaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }

    @Autowired
    public void setProjectRepo(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    @Override
    public TaskResponseDTO get(Long id) {
        return taskMapper.map(taskRepo.findById(id).orElseThrow(() -> new TaskNotFoundException(id)));
    }


   @Override
    public TaskResponseDTO update(TaskUpdateDTO task) {
        Task dbTask = taskRepo.findById(task.getId()).orElseThrow(() -> new TaskNotFoundException(task.getId()));

        taskMapper.map(task, dbTask);

        return taskMapper.map(taskRepo.save(dbTask));
    }

    @Override
    public void delete(Long id) {
        taskRepo.deleteById(id);
    }

    @Override
    public Page<TaskResponseDTO> getAll(Pageable pageable) {
        return taskRepo.findAll(pageable).map(taskMapper::map);
    }

}
