package com.sachin.task.mapper;

import com.sachin.task.domain.dto.TaskDto;
import com.sachin.task.domain.entities.Task;

public interface TaskMapper {
    //taskdto to task
   Task fromDto(TaskDto taskDto);

   //task to taskDTO
   TaskDto toDto(Task task);
}
