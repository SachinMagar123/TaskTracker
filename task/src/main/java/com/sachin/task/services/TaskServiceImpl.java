package com.sachin.task.services;

import com.sachin.task.domain.entities.Task;
import com.sachin.task.repositories.TaskListRepository;
import com.sachin.task.repositories.TaskRepository;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.UUID;

public class TaskServiceImpl implements TaskService{

    private  final TaskListRepository taskListRepository;
    private final TaskRepository taskRepository ;

    public TaskServiceImpl(TaskListRepository taskListRepository, TaskRepository taskRepository) {
        this.taskListRepository = taskListRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> listTask(UUID tasklistId) {
        return taskRepository.findByTasklist_Id(tasklistId);
    }
}
