package com.todo.todo.domain.project.servise;

import com.todo.todo.domain.project.entity.Project;
import com.todo.todo.domain.project.mappper.ProjectMapper;
import com.todo.todo.domain.project.models.ProjectCreateDTO;
import com.todo.todo.domain.project.models.ProjectResponseDTO;
import com.todo.todo.domain.project.models.ProjectUpdateDTO;
import com.todo.todo.domain.project.repository.ProjectRepository;
import com.todo.todo.infrastructure.exceptions.custom.ProjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;
    private ProjectMapper projectMapper;

    @Override
    public ProjectResponseDTO save(ProjectCreateDTO project) {
        Project projectForSave = projectMapper.map(project);
        Project newProject = projectRepository.save(projectForSave);
        return projectMapper.map(newProject);
    }

    @Override
    public ProjectResponseDTO get(Long id) {
        return  projectMapper.map(projectRepository.findById(id).orElseThrow(()->new ProjectNotFoundException(id)));
    }

    @Override
    public Page<ProjectResponseDTO> getAll(Pageable pageable) {
        return projectRepository.findAll(pageable).map(projectMapper::map);
    }

    @Override
    public ProjectResponseDTO update(ProjectUpdateDTO project) {
        Project dbProject = projectRepository.findById(project.id()).orElseThrow(() -> new ProjectNotFoundException(project.id()));

        projectMapper.map(project, dbProject);

        return projectMapper.map(projectRepository.save(dbProject));
    }

    @Override
    public void delete(Long id) {

            projectRepository.deleteById(id);

    }


    @Autowired
    public void setProjectRepository(
            ProjectRepository taskRepo) {
        this.projectRepository = taskRepo;
    }

    @Autowired
    public void setProjectMapper(ProjectMapper projectMapper) {

        this.projectMapper = projectMapper;
    }
}
