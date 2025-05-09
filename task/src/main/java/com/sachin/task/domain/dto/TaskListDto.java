package com.sachin.task.domain.dto;

import com.sachin.task.domain.entities.Task;

import java.util.List;
import java.util.UUID;

public record TaskListDto(

        UUID id,
        String titile,
        String Description,
        List<TaskDto> tasks,

        //count for numbers of tasks in tasklist
        Integer count,

        //represents percentage of completion by number 0 to 1
        Double progress
        
) {
}
