package com.todo.todo.domain.project.mappper;

import com.todo.todo.domain.project.entity.Project;
import com.todo.todo.domain.project.models.ProjectCreateDTO;
import com.todo.todo.domain.project.models.ProjectResponseDTO;
import com.todo.todo.domain.project.models.ProjectUpdateDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    Project map(ProjectCreateDTO projectCreateDTO);
    @Mapping(target="tasksList")
    ProjectResponseDTO map(Project project);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void map(ProjectUpdateDTO projectUpdateDTO, @MappingTarget Project project);
}
