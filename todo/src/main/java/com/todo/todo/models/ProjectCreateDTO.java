package com.todo.todo.models;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public final class ProjectCreateDTO {

    @Length(min = 3, message = "Name length must be at least 3 characters")
    @NotNull(message = "Name must not be null")
    String name;

    ProjectCreateDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
