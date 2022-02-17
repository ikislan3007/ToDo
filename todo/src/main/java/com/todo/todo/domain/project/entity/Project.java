package com.todo.todo.domain.project.entity;
import com.todo.todo.domain.BaseEntity;
import com.todo.todo.domain.task.entity.Task;
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
    Task task;

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
