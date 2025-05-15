package com.sachin.task.controllers;


import com.sachin.task.domain.dto.TaskDto;
import com.sachin.task.domain.dto.TaskListDto;
import com.sachin.task.domain.entities.Task;
import com.sachin.task.mapper.TaskMapper;
import com.sachin.task.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/task-lists/{task_list_id}/tasks")
public class TaskController {

    private final TaskMapper taskMapper;
    private final TaskService taskService;

    public TaskController(TaskMapper taskMapper, TaskService taskService) {
        this.taskMapper = taskMapper;
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskDto> listTasks(@PathVariable("task_list_id")UUID tasklistId){
      return  taskService.listTask(tasklistId).stream().map(taskMapper::toDto).toList();
    }

    @PostMapping
    public TaskDto createTask(@PathVariable("task_list_id")UUID tasklistId , @RequestBody TaskDto taskDto){
        Task createdTask = taskService.createTask(tasklistId , taskMapper.fromDto(taskDto));
        return taskMapper.toDto(createdTask) ;
    }

    @GetMapping(path = "/{task_id}")
    public Optional<TaskDto> getTask(@PathVariable("task_list_id") UUID tasklistId , @PathVariable("task_id") UUID taskId) {
        return taskService.getTask(tasklistId, taskId).map(taskMapper::toDto);
    }
}
