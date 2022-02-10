package com.todo.todo.entity;

import lombok.Data;

@Data
public class TaskResponse {
    private Long id;
    private String name;
    private String description;
    private boolean done;
    private Long projectId;
}
