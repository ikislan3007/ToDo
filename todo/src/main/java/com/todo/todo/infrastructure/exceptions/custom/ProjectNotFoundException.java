package com.todo.todo.infrastructure.exceptions.custom;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(Long id) {
        super("Project with id " + id + " doesn't exist.");
    }
}
