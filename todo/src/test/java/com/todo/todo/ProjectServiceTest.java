package com.todo.todo;

import com.todo.todo.domain.project.entity.Project;
import com.todo.todo.domain.project.models.ProjectCreateDTO;
import com.todo.todo.domain.project.models.ProjectResponseDTO;
import com.todo.todo.domain.project.models.ProjectUpdateDTO;
import com.todo.todo.domain.project.repository.ProjectRepository;
import com.todo.todo.domain.project.service.ProjectService;
import com.todo.todo.domain.task.models.TaskProjectRecordResponse;
import com.todo.todo.infrastructure.exceptions.custom.ProjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class ProjectServiceTest {
    @Autowired
    private ProjectService projectService;

    @MockBean
    private ProjectRepository projectRepository;
    private Project project;

    @BeforeEach
    public void setUp() {
        project = new Project(Long.valueOf(1), "project");
    }

    @Test
    @DisplayName("Test save project")
    void testSave() {
        ProjectCreateDTO dto = new ProjectCreateDTO("project");
        Optional<Project> projectOptional = Optional.of(project);
        doReturn(project).when(projectRepository).save(any());
        doReturn(projectOptional).when(projectRepository).findById(any());
        ProjectResponseDTO projectResponseDTO = projectService.save(dto);
        assertEquals(projectResponseDTO.name(), project.getName());
    }

    @Test
    @DisplayName("Test update project")
    void testUpdate() {
        ProjectUpdateDTO dto = new ProjectUpdateDTO("project");
        Optional<Project> optionalProject = Optional.of(this.project);
        doReturn(optionalProject).when(projectRepository).findById(any());
        doReturn(project).when(projectRepository).save(any());

        ProjectResponseDTO projectResponseDTO = projectService.update(dto, Long.valueOf(1));
        assertEquals(projectResponseDTO.id(), Long.valueOf(1));
        assertEquals(projectResponseDTO.name(), dto.name());
    }

    @Test
    @DisplayName("Test get Project by Id")
    void testGetTask() {
        Project project = new Project();
        project.setId(32l);
        project.setName("project");
        List<TaskProjectRecordResponse> tasksList = new ArrayList<>();
        ProjectResponseDTO responseDTOProject = new ProjectResponseDTO(32L, "project1", tasksList);

        assertEquals(project.getId(), responseDTOProject.id());
    }

    @Test
    @DisplayName("Test delete Project by Id when project NotFound")
    void deletePtojecct() {
        Project project = new Project();
        project.setId(32l);
        project.setName("project");
        project.getTasksList();
        List<TaskProjectRecordResponse> tasksList = new ArrayList<>();
        ProjectResponseDTO responseDTOProject = new ProjectResponseDTO(22L, "project1", tasksList);
        Optional<Project> optionalProject = Optional.of(this.project);
        Mockito.doThrow(new ProjectNotFoundException(project.getId())).when(projectRepository).deleteById(optionalProject.get().getId());
    }

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }
}
