package com.todo.todo.models;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public final class TaskCreateDTO {

        @Length(min = 3, message = "Name length must be at least 3 characters")
        @NotNull(message = "Name must not be null")
        String name;
        String description;
        TaskCreateDTO() {
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
                return "TaskCreateDTO[]";
        }
}

