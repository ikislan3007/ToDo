package com.todo.todo.domain.task.service;

import com.todo.todo.domain.project.repository.ProjectRepository;
import com.todo.todo.domain.task.entity.Task;
import com.todo.todo.domain.task.mapper.TaskMapper;
import com.todo.todo.domain.task.models.TaskCreateDTO;
import com.todo.todo.domain.task.models.TaskResponseDTO;
import com.todo.todo.domain.task.models.TaskUpdateDTO;
import com.todo.todo.domain.task.repository.TaskRepository;
import com.todo.todo.infrastructure.exceptions.custom.ProjectNotFoundException;
import com.todo.todo.infrastructure.exceptions.custom.TaskNotFoundException;
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

        taskForSave.setProject(projectRepository.findById(task.projectId()).orElseThrow (() -> new ProjectNotFoundException(task.projectId())));
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
    public TaskResponseDTO update(TaskUpdateDTO task,Long id) {
        Task dbTask = taskRepo.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        taskMapper.map(task, dbTask);
        TaskResponseDTO updatedTask = taskMapper.map(taskRepo.save(dbTask));
        return updatedTask;
    }

    @Override
    public void delete(Long id) {
        if (taskRepo.existsById(id)) {
            taskRepo.deleteById(id);
        } else {
            throw new TaskNotFoundException(id);
        }
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
