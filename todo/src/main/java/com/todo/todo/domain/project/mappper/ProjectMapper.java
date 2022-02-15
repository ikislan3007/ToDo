package com.todo.todo.domain.project.mappper;

import com.todo.todo.domain.project.entity.Project;
import com.todo.todo.domain.project.models.ProjectCreateDTO;
import com.todo.todo.domain.project.models.ProjectResponseDTO;
import com.todo.todo.domain.project.models.ProjectUpdateDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    Project map(ProjectCreateDTO projectCreateDTO);
    ProjectResponseDTO map(Project project);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void map(ProjectUpdateDTO projectUpdateDTO, @MappingTarget Project project);
}
