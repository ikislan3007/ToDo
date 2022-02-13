package com.todo.todo.models;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public final class ProjectUpdateDTO {
    @NotNull(message = "Id is missing")
    Long id;

    @Length(min = 3, message = "Name length must be at least 3 characters")
    @NotNull(message = "Name must not be null")
    String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
