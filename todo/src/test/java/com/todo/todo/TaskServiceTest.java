package com.todo.todo;

import com.todo.todo.domain.project.entity.Project;
import com.todo.todo.domain.project.models.ProjectResponseDTO;
import com.todo.todo.domain.project.repository.ProjectRepository;
import com.todo.todo.domain.task.entity.Task;
import com.todo.todo.domain.task.models.TaskCreateDTO;
import com.todo.todo.domain.task.models.TaskResponseDTO;
import com.todo.todo.domain.task.models.TaskUpdateDTO;
import com.todo.todo.domain.task.repository.TaskRepository;
import com.todo.todo.domain.task.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TaskServiceTest {
    @Autowired
    private TaskService taskService;
    @MockBean
    private ProjectRepository projectRepository;
    @MockBean
    private TaskRepository taskRepository;
    private Project project;
    private Task task;

    @BeforeEach
    public void setUp() {
        project = new Project(Long.valueOf(72), "Project");

        task = new Task();
        task.setId(Long.valueOf(73));
        task.setName("Task Name");
        task.setDescription("Task Description");
        task.setDone(false);
        task.setProject(this.project);
    }
    @Test
    @DisplayName("Test save task")
    void testSave() {
        TaskCreateDTO dto = new TaskCreateDTO("task1", "this is task1", Long.valueOf(67));
        Optional<Project> projectOptional = Optional.of(project);

        doReturn(task).when(taskRepository).save(any());
        doReturn(projectOptional).when(projectRepository).findById(any());

        TaskResponseDTO taskResponseDTO = taskService.save(dto);
        assertEquals(taskResponseDTO.id(), task.getId());
        assertEquals(taskResponseDTO.name(), task.getName());
        assertEquals(taskResponseDTO.description(), task.getDescription());
        assertEquals(taskResponseDTO.project().id(), task.getProject().getId());

    }
    @Test
    @DisplayName("Test update task")
    void testUpdate() {
        TaskUpdateDTO dto = new TaskUpdateDTO(
                Long.valueOf(1),
                "task",
                "descriptionddqwd",
                Long.valueOf(1),
                false
        );

        Optional<Task> optionalTask = Optional.of(this.task);
        doReturn(optionalTask).when(taskRepository).findById(any());

        doReturn(task).when(taskRepository).save(any());

        TaskResponseDTO taskResponseDTO = taskService.update(dto);

        assertEquals(taskResponseDTO.id(), dto.id());
        assertEquals(taskResponseDTO.name(), dto.name());
        assertEquals(taskResponseDTO.description(), dto.description());
        assertEquals(taskResponseDTO.project().id(), dto.projectId());

    }
    @Test
    @DisplayName("Test get Task by Id")
    void testGetTask() {

        Task task = new Task();
        task.setName("task1");
        task.setDescription("something");
        task.setId(22L);

        ProjectResponseDTO responseDTOProject = new ProjectResponseDTO(22L, "project1");
        TaskResponseDTO taskDtoResponse = new TaskResponseDTO(22L, "task1", "something", responseDTOProject, false);

        assertEquals(task.getId(), taskDtoResponse.id());
    }
    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }


}
