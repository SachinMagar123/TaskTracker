package com.sachin.task.services;

import com.sachin.task.domain.entities.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    List<Task> listTask(UUID tasklistId) ;
}
