package com.todo.todo.entity;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class TaskRequest {

    @Min(3)
    private String name;
    private String description;
    private boolean done;

    private Long projectId;
}
