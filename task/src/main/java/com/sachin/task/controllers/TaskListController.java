package com.sachin.task.controllers;


import com.sachin.task.domain.dto.TaskDto;
import com.sachin.task.domain.dto.TaskListDto;
import com.sachin.task.domain.entities.TaskList;
import com.sachin.task.mapper.TaskListMApperImpl;
import com.sachin.task.mapper.TaskListMapper;
import com.sachin.task.services.TaskListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @GetMapping(path = "/{task_list_id}")
    public Optional<TaskListDto> getTaskList(@PathVariable("task_list_id")UUID taskListID ){
        return taskListService.getTaskList(taskListID).map(taskListMapper::toDto);
    }

    @PostMapping
    public TaskListDto createTaskList(@RequestBody TaskListDto taskListDto){
       TaskList createdTasklist = taskListService.createTasklist(taskListMapper.fromDto(taskListDto));
    return taskListMapper.toDto(createdTasklist) ;
    }

    @PutMapping(path = "/{task_list_id}")
    public TaskListDto updateTaskList(@PathVariable("task_list_id") UUID id , @RequestBody TaskListDto taskListDto){
        TaskList updatedTaskList = taskListService.updateTasklist(id, taskListMapper.fromDto(taskListDto));

        return taskListMapper.toDto(updatedTaskList);
    }

    @DeleteMapping(path = "/{task_list_id}")
    public void deleteTaskList(@PathVariable("task_list_id") UUID id){
        taskListService.deleteTaskList(id);
    }
}
