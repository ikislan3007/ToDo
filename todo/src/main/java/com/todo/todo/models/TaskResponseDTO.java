package com.todo.todo.models;

import java.util.Objects;

public final class TaskResponseDTO {
    Long id;
    String name;
    String description;
    boolean done;



    public Long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public boolean done() {
        return done;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (TaskResponseDTO) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.description, that.description) &&
                this.done == that.done;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, done);
    }

    @Override
    public String toString() {
        return "TaskResponseDTO[" +
                "id=" + id + ", " +
                "name=" + name + ", " +
                "description=" + description + ", " +
                "done=" + done + ']';
    }
}

