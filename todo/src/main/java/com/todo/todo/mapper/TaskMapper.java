package com.todo.todo.mapper;


import com.todo.todo.entity.Project;
import com.todo.todo.entity.Task;
import com.todo.todo.models.*;
import org.mapstruct.*;

@Mapper(componentModel ="spring")
public interface TaskMapper {

    Task map(TaskCreateDTO taskCreateDTO);

    TaskResponseDTO map(Task task);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void map(TaskUpdateDTO taskUpdateDTO, @MappingTarget Task task);

    ProjectResponseDTO map(Project project);
}

