package com.todo.todo.entity;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
public class TaskRequest {

    @Size(min = 3, max = 200, message
            = "name must be between 3 and 200 characters")
    private String name;

    @Size(min = 3, max = 200, message
            = "Description must be between 10 and 200 characters")
    private String description;

    private boolean done;

    private Long projectId;
}
