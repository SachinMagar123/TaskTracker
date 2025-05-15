package com.sachin.task.services;

import com.sachin.task.domain.entities.Task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskService {
    List<Task> listTask(UUID tasklistId) ;

    Task createTask(UUID taskListId , Task task);

    Optional<Task> getTask(UUID taskListId , UUID taskId);
}
