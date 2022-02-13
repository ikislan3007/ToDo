package com.todo.todo.models;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public final class TaskUpdateDTO {

    @NotNull(message = "Id is missing")
    Long id;

    @Length(min = 3, message = "Name length must be at least 3 characters")
    @NotNull(message = "Name must not be null")
    String name;

    String description;

    boolean done;

    TaskUpdateDTO() {
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this || obj != null && obj.getClass() == this.getClass();
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "TaskUpdateDTO[]";
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }



}


