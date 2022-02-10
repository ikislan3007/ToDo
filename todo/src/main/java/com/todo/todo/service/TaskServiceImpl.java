package com.todo.todo.service;

import com.todo.todo.entity.Project;
import com.todo.todo.entity.Task;
import com.todo.todo.entity.TaskRequest;
import com.todo.todo.entity.TaskResponse;
import com.todo.todo.exception.ProjectNotFoundException;
import com.todo.todo.exception.TaskNotFoundException;
import com.todo.todo.repository.ProjectRepository;
import com.todo.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepo;
    private ProjectRepository projectRepository;

    @Override
    public TaskResponse save(TaskRequest task) {
        Task saveTask = mapToSave(task);
        Task savedTask = taskRepo.save(saveTask);
        TaskResponse response = mapToResponse(savedTask);
        return response;
    }


    //mappers
    private TaskResponse mapToResponse(Task savedTask) {
        TaskResponse result = new TaskResponse();
        result.setId(savedTask.getId());
        result.setName(savedTask.getName());
        result.setDescription(savedTask.getDescription());
        result.setDone(savedTask.isDone());
        result.setProjectId(savedTask.getProject().getId());

        return result;
    }

    private Task mapToSave(TaskRequest task) {
        Task result = new Task();
        result.setName(task.getName());
        result.setDescription(task.getDescription());
        result.setDone(task.isDone());
        Project project = projectRepository.findById(task.getProjectId()).orElseThrow(() -> new ProjectNotFoundException(task.getProjectId()));
        result.setProject(project);

        return result;
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
    public TaskResponse get(Long id) {
        Task task = taskRepo.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        TaskResponse response = mapToResponse(task);
        return response;
    }

    @Override
    public TaskResponse update(TaskRequest taskRequest, Long id) {
        Task updateTask = mapToSave(taskRequest);
        updateTask.setId(id);
        Task savedTask = taskRepo.save(updateTask);
        TaskResponse response = mapToResponse(savedTask);
        return response;
    }

    @Override
    public void delete(Long id) {
        taskRepo.deleteById(id);
    }

    @Override
    public List<TaskResponse> getAll(int page, int pageSize) {
        if (page != 0 && pageSize != 0) {
            Pageable pageAndElements = PageRequest.of(page, pageSize);
            return taskRepo.findAll(pageAndElements).stream().map((Task task) ->  mapToResponse(task)).toList();
        }
        return taskRepo.findAll().stream().map((Task task) ->  mapToResponse(task)).toList();

    }
}
