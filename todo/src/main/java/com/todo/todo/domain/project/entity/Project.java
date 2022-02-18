package com.todo.todo.domain.project.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.todo.todo.domain.BaseEntity;
import com.todo.todo.domain.task.entity.Task;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project extends BaseEntity implements Serializable {
    @NotNull(message = "Name cannot be null")
    @Size(min = 3, message
            = "Name must be at least 3 characters")
    private String name;
    Task task;
    @ToString.Exclude
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "project")
    @JsonManagedReference
    List<Task> tasksList = new ArrayList<>();

    public List<Task> getTasksList() {
        return tasksList;
    }

    public void setTasksList(List<Task> tasksList) {
        this.tasksList = tasksList;
    }
    public Task getTask() {
        return task;
    }

    public Project() {
    }

    public Project(Long id, String name) {
        setId(id);
        setName(name);
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


}
