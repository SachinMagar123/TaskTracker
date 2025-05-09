package com.sachin.task.mapper;

import com.sachin.task.domain.dto.TaskDto;
import com.sachin.task.domain.entities.Task;
import org.springframework.stereotype.Component;


@Component
public class TaskMapperImpl implements TaskMapper{
    @Override
    public Task fromDto(TaskDto taskDto) {
        return new Task(
                taskDto.id(),
                taskDto.title(),
                taskDto.description(),
                taskDto.dueDate(),
                taskDto.status(),
                taskDto.priority(),
                null,
                null,
                null
        );
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTaskname(),
                task.getDescription(),
                task.getDue_date(),
                task.getPriority(),
                task.getTaskstatus()
        );
    }
}
