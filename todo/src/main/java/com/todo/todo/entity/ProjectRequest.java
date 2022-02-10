package com.todo.todo.entity;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class ProjectRequest {

    @Min(3)
    private String name;
}
