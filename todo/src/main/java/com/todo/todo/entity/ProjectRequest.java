package com.todo.todo.entity;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
public class ProjectRequest {

    @Size(min = 3, max = 200, message
            = "Name must be between 3 and 200 characters")
    private String name;
}
