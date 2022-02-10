package com.todo.todo.controller;


import com.todo.todo.entity.TaskRequest;
import com.todo.todo.entity.TaskResponse;
import com.todo.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    public TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponse> create(@RequestBody TaskRequest taskRequest){
        TaskResponse responce=taskService.save(taskRequest);
        return ResponseEntity.ok(responce);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> update(@RequestBody TaskRequest taskRequest, @PathVariable Long id){
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
        TaskResponse response = taskService.get(id);
        return ResponseEntity.ok(response);
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
