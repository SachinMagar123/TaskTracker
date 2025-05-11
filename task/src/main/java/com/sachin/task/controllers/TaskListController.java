package com.sachin.task.controllers;


import com.sachin.task.domain.dto.TaskDto;
import com.sachin.task.domain.dto.TaskListDto;
import com.sachin.task.mapper.TaskListMApperImpl;
import com.sachin.task.mapper.TaskListMapper;
import com.sachin.task.services.TaskListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/task-lists") // sets base url path for tasklist ops
public class TaskListController {

    private final TaskListService taskListService ;
    private final TaskListMapper taskListMapper ;


    public TaskListController(TaskListService taskListService, TaskListMapper taskListMapper) {
        this.taskListService = taskListService;
        this.taskListMapper = taskListMapper;
    }

    @GetMapping
   public List<TaskListDto> listTaskLists(){
        return taskListService.listTaskLists()
                .stream()
                .map(taskListMapper::toDto)
                .toList();
    }
}
