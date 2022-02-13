package com.todo.todo.service;

import com.todo.todo.entity.Project;
import com.todo.todo.exception.ProjectNotFoundException;
import com.todo.todo.mapper.ProjectMapper;
import com.todo.todo.models.ProjectCreateDTO;
import com.todo.todo.models.ProjectResponseDTO;
import com.todo.todo.models.ProjectUpdateDTO;
import com.todo.todo.repository.ProjectRepository;
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
        Project newProject=projectRepository.save(projectMapper.map(project));
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
        Project dbProject = projectRepository.findById(project.getId()).orElseThrow(() -> new ProjectNotFoundException(project.getId()));

        projectMapper.map(project, dbProject);

        return projectMapper.map(projectRepository.save(dbProject));
    }

    @Override
    public void delete(Long id) {

            projectRepository.deleteById(id);

    }


    @Autowired
    public void setTaskRepo(ProjectRepository taskRepo) {
        this.projectRepository = projectRepository;
    }

    @Autowired
    public void setTaskMapper(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }
}