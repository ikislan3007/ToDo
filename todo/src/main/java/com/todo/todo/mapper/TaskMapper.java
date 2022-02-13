package com.todo.todo.mapper;


import com.todo.todo.entity.Task;
import com.todo.todo.models.TaskCreateDTO;
import com.todo.todo.models.TaskResponseDTO;
import com.todo.todo.models.TaskUpdateDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel ="spring")
public interface TaskMapper {

    Task map(TaskCreateDTO taskCreateDTO);

    TaskResponseDTO map(Task task);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void map(TaskUpdateDTO taskUpdateDTO, @MappingTarget Task task);
}

