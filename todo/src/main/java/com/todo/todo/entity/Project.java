package com.todo.todo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Data
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "Name cannot be null")
    @Size(min = 3, message
            = "Name must be at least 3 characters")
    private String name;

    @OneToMany(mappedBy="project")
    private Set<Task> tasks;

}
