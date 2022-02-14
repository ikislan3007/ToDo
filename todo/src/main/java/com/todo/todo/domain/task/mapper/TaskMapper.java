package com.todo.todo.domain.task.mapper;


import com.todo.todo.domain.project.models.ProjectResponseDTO;
import com.todo.todo.domain.task.models.TaskCreateDTO;
import com.todo.todo.domain.task.models.TaskResponseDTO;
import com.todo.todo.domain.task.models.TaskUpdateDTO;
import com.todo.todo.domain.project.entity.Project;
import com.todo.todo.domain.task.entity.Task;
import org.mapstruct.*;

@Mapper(componentModel ="spring")
public interface TaskMapper {

    Task map(TaskCreateDTO taskCreateDTO);

    TaskResponseDTO map(Task task);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void map(TaskUpdateDTO taskUpdateDTO, @MappingTarget Task task);

    ProjectResponseDTO map(Project project);
}

