package com.todo.todo.web;

import com.todo.todo.domain.task.models.TaskCreateDTO;
import com.todo.todo.domain.task.models.TaskResponseDTO;
import com.todo.todo.domain.task.models.TaskUpdateDTO;
import com.todo.todo.domain.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/task")
public class TaskController {
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponseDTO> create(@Valid @RequestBody TaskCreateDTO task) {
        return ResponseEntity.ok(taskService.save(task));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> get(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.get(id));
    }

    @GetMapping
    public ResponseEntity<Page<TaskResponseDTO>> get(Pageable pageable) {
        return ResponseEntity.ok(taskService.getAll(pageable));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> update(@PathVariable Long id, @Valid @RequestBody TaskUpdateDTO task ) {
        return ResponseEntity.ok(taskService.update(task,id));
    }
    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }


}
