package com.todo.todo.domain.project.entity;

import com.todo.todo.domain.BaseEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Project extends BaseEntity implements Serializable {



    @NotNull(message = "Name cannot be null")
    @Size(min = 3, message
            = "Name must be at least 3 characters")
    private String name;

  /*  @OneToMany(mappedBy="project")
    private Set<Task> tasks;*/

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
