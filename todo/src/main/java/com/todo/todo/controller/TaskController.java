package com.todo.todo.controller;


import com.todo.todo.entity.TaskRequest;
import com.todo.todo.entity.TaskResponse;
import com.todo.todo.exception.ProjectNotFoundException;
import com.todo.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    public TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponse> create(@Valid @RequestBody TaskRequest taskRequest){
        TaskResponse responce=taskService.save(taskRequest);
        return ResponseEntity.ok(responce);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> update(@Valid @RequestBody TaskRequest taskRequest, @PathVariable Long id){
        TaskResponse responce = taskService.update(taskRequest, id);
        return ResponseEntity.ok(responce);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.ok().body("deleted");
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> get(@PathVariable Long id) {
        try {
            TaskResponse response = taskService.get(id);
            return ResponseEntity.ok(response);
        } catch(ProjectNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAll(@RequestParam int page, @RequestParam int pageSize) {
        List<TaskResponse> response = taskService.getAll(page, pageSize);
        return ResponseEntity.ok(response);
    }

    @Autowired
    public void setTaskService(TaskService taskService){
        this.taskService=taskService;
    }


}
