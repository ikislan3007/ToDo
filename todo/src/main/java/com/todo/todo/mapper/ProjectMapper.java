package com.todo.todo.mapper;

import com.todo.todo.entity.Project;
import com.todo.todo.models.ProjectCreateDTO;
import com.todo.todo.models.ProjectResponseDTO;
import com.todo.todo.models.ProjectUpdateDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel ="spring")
public interface ProjectMapper {

    Project map(ProjectCreateDTO projectCreateDTO);

    ProjectResponseDTO map(Project project);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void map(ProjectUpdateDTO projectUpdateDTO, @MappingTarget Project project);
}
