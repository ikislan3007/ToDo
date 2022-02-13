package com.todo.todo.entity;


import com.todo.todo.BaseEntity;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Data
public class Task extends BaseEntity implements Serializable {

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

    public void setProject(Project project) {
        this.project = project;
    }

    public Project getProject() {
        return this.project;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
