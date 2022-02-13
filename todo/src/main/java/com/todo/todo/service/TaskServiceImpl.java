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
        Task taskForSave = taskMapper.map(task);
        taskForSave.setProject(projectRepository.findById(task.projectId()).get());
        Task newTask = taskRepo.save(taskForSave);
        return taskMapper.map(newTask);
    }



    @Autowired
    public void setTaskRepo(TaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }

    @Override
    public TaskResponseDTO get(Long id) {
        return taskMapper.map(taskRepo.findById(id).orElseThrow(() -> new TaskNotFoundException(id)));
    }


   @Override
    public TaskResponseDTO update(TaskUpdateDTO task) {
        Task dbTask = taskRepo.findById(task.id()).orElseThrow(() -> new TaskNotFoundException(task.id()));
        taskMapper.map(task, dbTask);
        TaskResponseDTO updatedTask = taskMapper.map(taskRepo.save(dbTask));
        return updatedTask;
    }

    @Override
    public void delete(Long id) {
        taskRepo.deleteById(id);
    }

    @Override
    public Page<TaskResponseDTO> getAll(Pageable pageable) {
        return taskRepo.findAll(pageable).map(taskMapper::map);
    }

    @Autowired
    public void setTaskMapper(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Autowired
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

}
