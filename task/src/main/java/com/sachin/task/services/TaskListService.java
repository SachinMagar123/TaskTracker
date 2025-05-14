package com.sachin.task.services;

import com.sachin.task.domain.dto.TaskListDto;
import com.sachin.task.domain.entities.TaskList;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskListService {
    List<TaskList> listTaskLists();

    TaskList createTasklist(TaskList taskList);

    Optional<TaskList> getTaskList(UUID id);
}
