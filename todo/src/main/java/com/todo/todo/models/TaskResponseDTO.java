package com.todo.todo.models;

public record TaskResponseDTO (
        Long id,
        String name,
        String description,
        ProjectResponseDTO project,
        boolean done
) {}


