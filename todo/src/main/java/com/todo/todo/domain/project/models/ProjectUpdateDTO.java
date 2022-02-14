package com.todo.todo.domain.project.models;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public record ProjectUpdateDTO(@NotNull(message = "Id is missing")
                               Long id,
                               @Length(min = 3, message = "Name length must be at least 3 characters")
                               @NotNull(message = "Name must not be null")
                               String name) {
}
