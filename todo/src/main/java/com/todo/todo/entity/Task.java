package com.todo.todo.entity;


import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue
//    @UniqueElements wtf
    private Long id;

    @NotNull(message = "Name cannot be null")
    @Size(min = 3, message
            = "Name must be at least 3 characters")
    private String name;

    @NotNull(message = "Description cannot be null")
    @Size(min = 10, message
            = "Description must be at least 10 characters")
    private String description;

    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project project;

    @Value("${some.key:false}")
    private boolean done;

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
