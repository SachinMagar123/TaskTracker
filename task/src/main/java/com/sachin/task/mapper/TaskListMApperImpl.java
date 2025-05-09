package com.sachin.task.mapper;

import com.sachin.task.domain.dto.TaskListDto;
import com.sachin.task.domain.entities.Task;
import com.sachin.task.domain.entities.TaskList;
import com.sachin.task.domain.entities.TaskStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskListMApperImpl implements TaskListMapper{

    private final TaskMapper taskMapper ;

    public TaskListMApperImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskList fromDto(TaskListDto taskListDto) {
        return new TaskList(
                taskListDto.id(),
                taskListDto.title(),
                taskListDto.description(),
                null,null,

                Optional.ofNullable(taskListDto.tasks()).map(tasks -> tasks.stream().map(taskMapper::fromDto).toList()).orElse(null)
        );
    }

    @Override
    public TaskListDto toDto(TaskList taskList) {
        final List<Task> tasks = taskList.getTasks();
        return new TaskListDto(
                taskList.getId(),
                taskList.getTitle(),
                taskList.getDescription(),

                Optional.ofNullable(tasks)
                        .map(t -> t.stream()
                                .map(taskMapper::toDto)
                                .toList())
                        .orElse(null),
                Optional.ofNullable(tasks)
                        .map(List::size)
                        .orElse(0),
                calculateTaskListProgress(tasks)
        );
    }
    private Double calculateTaskListProgress(List<Task> tasks) {
        if(null == tasks) {
            return null;
        }
        long closedTaskCount = tasks.stream()
                .filter(task -> TaskStatus.closed == task.getTaskstatus())
                .count();
        return (double) closedTaskCount / tasks.size();
    }
    }

